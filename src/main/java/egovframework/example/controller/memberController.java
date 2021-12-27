package egovframework.example.controller;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.condition.ParamsRequestCondition;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import egovframework.example.dto.Member;
import egovframework.example.service.MemberService;
import egovframework.example.util.Util;

@Controller
public class memberController {
	
	private static final Logger logger = LoggerFactory.getLogger(memberController.class);
	
	@Autowired
	MappingJackson2JsonView jsonView;
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@RequestMapping("/member/join_policy.do")
    public ModelAndView showJoinPolicy(ModelAndView mav, @RequestParam Map<String, Object> param) throws Exception {
		String afterLoginURI = (String) param.get("requestURI");
		
		mav.addObject("afterLoginURI", afterLoginURI);
		mav.addObject("param", param);
		
        mav.setViewName("/member/join_policy");
        return mav;
    }
	
	@RequestMapping("/member/join_policyCheck.do")
    public String checkJoinPolicy(HttpServletRequest req, @RequestParam Map<String, Object> param) throws Exception {
		
		String policyUse = (String) param.get("policyUse");
		String privacyPolicy = (String) param.get("privacyPolicy");
		String marketing = (String) param.get("marketPolicy");
		
		if( policyUse == null || policyUse.trim().equals("on") == false ) {
			return Util.msgAndReplace(req, "이용약관에 동의 해주셔야 회원가입이 가능합니다", "/member/join_policy.do");
		}
		
		if( privacyPolicy == null || privacyPolicy.trim().equals("on") == false ) {
			return Util.msgAndReplace(req, "개인정보 처리방침에 동의 해주셔야 회원가입이 가능합니다", "/member/join_policy.do");
		}
		
		String url = "/member/join.do";
		
		if( marketing != null ) {
			url= url + "?marketing=" + marketing;
		}
		
		return Util.replace(req, url);
    }
	
	@RequestMapping("/member/join.do")
    public ModelAndView showJoin(HttpServletRequest req,  ModelAndView mav, @RequestParam Map<String, Object> param) throws Exception {
		String afterLoginURI = (String) param.get("requestURI");
		
		String marketing = req.getParameter("marketing");
		
		if( marketing != null) {
			if( marketing.equals("on") ) {
				mav.addObject("SMS_agree", "on");
				mav.addObject("email_agree", "on");
			}
		}
		
		mav.addObject("afterLoginURI", afterLoginURI);
		mav.addObject("param",param);
		
		mav.setViewName("/member/join");
		
        return mav;
    }
	
	@RequestMapping("/member/doJoin.do")
    public String doJoin(HttpServletRequest req, @RequestParam Map<String,Object> param) throws Exception {
		
		System.out.println("param= " + param);
		
		String msg = memberService.checkJoinMember(param);
		
		if( msg.contains("S-1") == false ) {
			return Util.msgAndBack(req, msg);
		}
		
		msg = msg.replace("S-1, ", "");
		
		String redirectUrl = "/member/login.do";
		
		return Util.msgAndReplace(req, msg, redirectUrl);
    }
	
	@RequestMapping("/member/login.do")
    public ModelAndView showLogin(ModelAndView mav, @RequestParam Map<String, Object> param) throws Exception {
        
		String afterLoginURI = (String) param.get("requestURI");
		if(afterLoginURI != null) {
			mav.addObject("afterLoginURI", afterLoginURI);
		}
        mav.setViewName("member/login");
        return mav;
    }
	
	@RequestMapping("/member/logout.do")
    public String showLogout(HttpServletRequest req,HttpSession session, String redirectURI) throws Exception {
        
		session.removeAttribute("loginedMember");
		
		redirectURI =  Util.ifNull(redirectURI, "/index.do");
		
        return Util.msgAndReplace(req, "로그아웃 되었습니다.", redirectURI);
    }
	
	@RequestMapping("/member/doLogin.do")
    public String doLogin(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param, String afterLoginURI) throws Exception {
        
		String memberId = (String) param.get("member_id");
		String memberPw = (String) param.get("member_pw");
		
		Member member = memberService.doLoginCheck(param);
		
		System.out.println("afterLogin = " + afterLoginURI);
		
		if(memberId == null) {
			return Util.msgAndBack(req, "아이디를 입력해주세요");
		}
		
		if(memberPw == null) {
			return Util.msgAndBack(req, "패스워드를 입력해주세요");
		}
		
		if(member == null) {
			return Util.msgAndBack(req, "존재하지 않는 아이디 입니다.");
		}
		
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		
		boolean loginPwCheck = encoder.matches(memberPw, member.getMember_pw());
		
		if( loginPwCheck == false ) {
			return Util.msgAndBack(req, "패스워드가 일치하지 않습니다."); 
		}
		
        String msg = String.format("%s님의 로그인을 환영합니다.", member.getMember_nickname() );
        
        if(afterLoginURI.contains("member")) {
        	afterLoginURI = null;
        }
        
        if(afterLoginURI == null) {
        	afterLoginURI = "/index.do";
        }
        
        session.setAttribute("loginedMember", member);
        
        return Util.msgAndReplace(req, msg, afterLoginURI);
    }
	
	@RequestMapping("/member/memberFindId.do")
    public ModelAndView showMemberFindId(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param, String afterLoginURI) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/member/memberFindId");
		
		return mav; 
    }
	
	@RequestMapping("/member/memberFindPw.do")
    public ModelAndView showMemberFindPw(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param, String afterLoginURI) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/member/memberFindPw");
		
		return mav; 
    }
	@RequestMapping("/member/doFindId.do")
	public String doFindId(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param) {
		
		Map<String, Object> member = memberService.getMemberByMemberNameAndEmail(param);
		
		if(member== null) {
			Util.msgAndBack(req, "입력하신 정보와 일치하는 계정이 없습니다.");
		}
		
		String memberName = (String) member.get("memberName");
		String memberEmail = (String) member.get("memberEmail");
		
		return Util.replace(req, "/member/resultFindId.do?memberName=" + memberName + "&memberEmail=" + memberEmail);
	}
	
	@RequestMapping("/member/resultFindId.do")
    public ModelAndView resuldFindId(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param, String memberName, String memberEmail) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		param.put("member_name", memberName);
		param.put("member_email", memberEmail);
		
		Map<String, Object> member = memberService.getMemberByMemberNameAndEmail(param);
		
		if(member != null) {
			String mName = (String) member.get("memberName");
			String mEmail = (String) member.get("memberEmail");
			String mId = (String) member.get("memberId");
			
			mav.addObject("memberName", mName);
			mav.addObject("memberEmail", mEmail);
			mav.addObject("memberId", mId);
		}
		
		else if ( member == null ) {
			mav.addObject("error", true);
		}
		
		mav.setViewName("/member/resultFindId");
		
		return mav; 
    }
	
	@RequestMapping("/member/myInforBeforePage.do")
    public ModelAndView showMyInforBeforePage(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param, String afterLoginURI) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("/member/myInforBeforePage");
		
		return mav; 
    }
	
	@RequestMapping("/member/myInfor.do")
    public ModelAndView myInfor(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param, String afterLoginURI) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		String memberId = (String) param.get("memberId");
		Integer changeMemberId = Integer.parseInt(memberId);
		
		if(memberId != null) {
			Map<String,Object> member = memberService.getMemberById(changeMemberId);
			
			if ( member != null ) {
				mav.addObject("member", member);
			}
		}
		
		mav.setView(jsonView);
		
		mav.setViewName("/member/myInfor");
		
		return mav; 
    }
	
}
