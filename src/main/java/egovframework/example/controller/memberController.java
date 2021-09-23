package egovframework.example.controller;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.service.BoardService;

@Controller
public class memberController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("/member/login.do")
    public ModelAndView showLogin(ModelAndView mav) throws Exception {
        
        mav.setViewName("member/login");
        return mav;
    }
	@RequestMapping("/member/join.do")
    public ModelAndView showJoin(ModelAndView mav) throws Exception {
        
        mav.setViewName("member/join");
        return mav;
    }
	@RequestMapping("/member/doJoin.do")
    public ModelAndView doJoin(ModelAndView mav, @RequestParam Map<String,Object> param) throws Exception {
        
		System.out.println("param= " + param); 
		
        mav.setViewName("/index");
        return mav;
    }
}