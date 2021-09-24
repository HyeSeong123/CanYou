package egovframework.example.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.dto.Member;
import egovframework.example.service.MemberService;
import egovframework.example.util.Util;

@Controller
public class memberController {

	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping("/member/join.do")
    public ModelAndView showJoin(ModelAndView mav) throws Exception {
        
        mav.setViewName("member/join");
        return mav;
    }
	@RequestMapping("/member/doJoin.do")
    public String doJoin(HttpServletRequest req, @RequestParam Map<String,Object> param) throws Exception {
        
		String memberEmail = (String) param.get("member_email");
		String memberNickname = (String) param.get("member_nickname");
		String memberId = (String) param.get("member_id");
		String memberPw = (String) param.get("member_pw");
		String pwConfirm = (String) param.get("confirm_pw");
		String memberPhNum = (String) param.get("member_phNum");
		
		Map<String,Object> checkId = memberService.getMemberByMemberId(memberId);
		Map<String,Object> checkNickname = memberService.getMemberByMemberNickname(memberNickname);
		int checkMail = memberService.getMemberByMemberEmailCount(memberEmail);
		
		if(checkId != null) {
			return Util.msgAndBack(req, "중복된 아이디 입니다.");
		}
		
		if(checkNickname != null) {
			return Util.msgAndBack(req, "이미 존재하는 닉네임 입니다.");
		}
		
		if (checkMail >= 1) {
			return Util.msgAndBack(req, "해당 메일로 이미 계정을 생성 하셨습니다.");
		}
		
		if (memberPw.contains(" ")) {
			return Util.msgAndBack(req, "패스워드에 공백이 존재할 수 없습니다.");
		}
		
		if (! memberPw.equals(pwConfirm) ) {
			return Util.msgAndBack(req, "패스워드와 패스워드 확인란이 일치하지 않습니다.");
		}
		
		if (memberPw.length() < 7) {
			return Util.msgAndBack(req, "패스워드는 8글자 이상이어야 합니다.");
		}
		
		String phMatch = "[^0-9]";
		memberPhNum = memberPhNum.replaceAll(phMatch,"");
		
		if(memberPhNum.length() != 11) {
			return Util.msgAndBack(req, "휴대전화 번호 양식에 맞춰주세요 (숫자 11개)");
		}
		
		param.put("member_phNum", memberPhNum);
		
		memberService.doJoin(param);
		
		String msg = String.format("%s님의 회원가입을 환영합니다", param.get("member_nickname"));
		String redirectUrl = "/index.do";
		
		return Util.msgAndReplace(req,msg, redirectUrl);
    }
	
	@RequestMapping("/member/login.do")
    public ModelAndView showLogin(ModelAndView mav) throws Exception {
        
        mav.setViewName("member/login");
        return mav;
    }
	
	@RequestMapping("/member/doLogin.do")
    public String doLogin(HttpServletRequest req, @RequestParam Map<String,Object> param) throws Exception {
        
		String memberId = (String) param.get("member_id");
		String memberPw = (String) param.get("member_pw");
		
		Member member = memberService.doLoginCheck(param);

		if(member == null) {
			return Util.msgAndBack(req, "존재하지 않는 아이디 입니다.");
		}
		
		System.out.println("memberPw= " + member.getMember_pw());
		
		if( ! member.getMember_pw().equals(memberPw) ) {
			return Util.msgAndBack(req, "패스워드가 일치하지 않습니다."); 
		}
		
        String msg = String.format("%s님의 로그인을 환영합니다.", member.getMember_nickname() );
        
        return Util.msgAndReplace(req, msg, "/index.do");
    }
}
