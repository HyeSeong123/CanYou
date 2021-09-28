
package egovframework.example.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import egovframework.example.service.BoardService;

@Controller
public class HomeController {

	@Resource(name="boardService")
	private BoardService boardService;
	
	@RequestMapping("/index.do")
    public ModelAndView showIndexPage(ModelAndView mav) throws Exception {
        
        mav.setViewName("index");
        return mav;
    }
	@GetMapping("/")
	public String home() {
		return "index.do";
	}
}
