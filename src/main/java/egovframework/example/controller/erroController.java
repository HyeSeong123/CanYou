package egovframework.example.controller;

import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class erroController {
	@RequestMapping("/common/error.do")
	public String error(HttpRequest req) throws Exception{
		
		return "/common/error";
	}
}
