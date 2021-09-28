package egovframework.example.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	private static final Logger logger = LoggerFactory.getLogger(memberController.class);
	
	@RequestMapping(value="/login/loginPage.do")
	public String loginPage() {
		return "/login/loginPage";
	}
	
	@RequestMapping(value="/login/accessDenine.do")
	public String accessDeninedPage() throws Exception{
		return "/login/accessDenine";
	}
}
