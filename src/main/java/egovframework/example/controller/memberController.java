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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
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
				mav.addObject("SMSAgree", "on");
				mav.addObject("emailAgree", "on");
			}
		}
		
		mav.addObject("param",param);
		
		mav.setViewName("/member/join");
		
        return mav;
    }
	
	@RequestMapping("/member/memberIdDupliCheck.do")
    public ModelAndView doMemberIdDupliCheck(HttpServletRequest req, @RequestParam("memberId") String memberId) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> member = memberService.getMemberByMemberId(memberId);
		
		boolean isId = memberId.matches("^[a-zA-Z]{1}[a-zA-Z0-9_]{5,13}$");
		
		if ( isId == false ) {
			mav.addObject("resultCode", "F-1 아이디를 6글자 이상 13글자 이하 영문으로 숫자가 먼저 오지 않게 지정해주세요.");
			mav.setView(jsonView);
			return mav;
		}
		
		if ( member != null ) {
			mav.addObject("resultCode", "F-2 이미 존재하는 아이디 입니다.");
			mav.setView(jsonView);
			return mav;
		} 
		
		mav.addObject("resultCode", "S-1 사용가능한 아이디 입니다.");
		
		mav.setView(jsonView);
		return mav; 
	}
	@RequestMapping("/member/doJoin.do")
    public String doJoin(HttpServletRequest req, @RequestParam Map<String,Object> param) throws Exception {
		
		String smsAgree = (String) param.get("SMSAgree");
		String emailAgree = (String) param.get("emailAgree");
		
		if(smsAgree == null) {
			smsAgree = "N";
			param.put("smsAgree", smsAgree);
		}
		
		if(emailAgree == null) {
			emailAgree = "N";
			param.put("emailAgree", emailAgree);
		}
		
		System.out.println("param= " + param);
		
		String msg = memberService.checkJoinMember(param);
		
		if( msg.contains("S-1") == false ) {
			return Util.msgAndBack(req, msg);
		}
		
		memberService.doJoin(param);
		
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
    public String doLogin(HttpServletRequest req, HttpSession session, @RequestParam Map<String,Object> param) throws Exception {
        
		String memberId = (String) param.get("memberId");
		String memberPw = (String) param.get("memberPw");
		String afterLoginURI = (String) param.get("afterLoginURI");
		
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
		
        String msg = String.format("%s님의 로그인을 환영합니다.", member.getMember_name() );
        
        if(afterLoginURI.contains("member")) {
        	afterLoginURI = null;
        }
        
        if(afterLoginURI == null || afterLoginURI == "") {
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
	public ModelAndView doFindId(HttpServletRequest req, HttpSession session, @RequestParam Map<String, Object> param) {
		
		ModelAndView mav = new ModelAndView();
		
		System.out.println("param= " + param);
		
		Map<String, Object> member = memberService.getMemberByMemberNameAndEmail(param);
		
		if(member == null) {
			mav.addObject("resultCode", "F-1 입력하신 정보와 일치하는 아이디가 없습니다.");
			
			mav.setView(jsonView);
			
			return mav;
		}
		
		String memberId = (String) member.get("memberId");
		mav.addObject("resultCode" , "S-1 회원님의 아이디는 " + memberId + " 입니다.");
		
		mav.setView(jsonView);
		return mav;
	}
	
	@RequestMapping("/member/doFindPw.do")
	public ModelAndView doFindPw(HttpServletRequest req, HttpSession session, @RequestParam Map<String, Object> param) {
		
		ModelAndView mav = new ModelAndView();
		
		Map<String, Object> member = memberService.getMemberByIdAndEmailAndBirth(param);
		
		if(member == null) {
			mav.addObject("resultCode", "F-1 입력하신 정보와 일치하는 계정이 없습니다.");
		}
		
		System.out.println("param= " + param);
		System.out.println("member= " + member);
		
		mav.setView(jsonView);
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
