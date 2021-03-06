package egovframework.example.interceptor;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egovframework.example.service.MemberService;
import egovframework.example.util.Util;

@Component("needToLoginInterceptor")
public class NeedToLoginInterceptor extends HandlerInterceptorAdapter{
	
	@Resource(name="memberService")
	private MemberService memberService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object Handler) throws Exception{
		
		boolean isLogined = (boolean) req.getAttribute("isLogined");
		
		boolean isAjax = (boolean) req.getAttribute("isAjax");
		
		if (isLogined == false) {
			String resultCode = "F-L";
			String resultMsg = "로그인 후 이용해주세요.";
			
			if (isAjax == false) {
				resp.setContentType("text/html; charset=UTF-8");
				resp.getWriter().append("<script>");
				resp.getWriter().append("alert('" + resultMsg +"');");
				resp.getWriter().append("location.replace('/member/login.do?afterLoginUrl=" + Util.reqAttr(req, "afterLoginURI", "index.do") + "');");
				resp.getWriter().append("</script>");
			} else {
				resp.setContentType("application/json; charset=UTF-8");
				resp.getWriter().append("{\"resultCode\":\"" + resultCode + "\",\"msg\":\"" + resultMsg + "\"}");
			}
			
			return false;
		}
		
		return true;
	}
}
