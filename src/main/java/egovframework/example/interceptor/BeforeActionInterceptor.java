package egovframework.example.interceptor;

import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egovframework.example.dto.Member;
import egovframework.example.service.BoardService;
import egovframework.example.util.Util;

@Component("beforeActionInterceptor")
public class BeforeActionInterceptor extends HandlerInterceptorAdapter{

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object Handler) throws Exception{
		
		String requestURI = req.getRequestURI();
		boolean isLogined = false;
		boolean isAjax = requestURI.endsWith("Ajax");
		Map<String, Object> param = Util.getParamMap(req);
		Enumeration<String> parameterNames = req.getParameterNames();

		if (isAjax == false) {
			if (param.containsKey("ajax") && param.get("ajax").equals("Y")) {
				isAjax = true;
			}
		}
		
		System.out.println("ajax= " + isAjax);
		
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			Object paramValue = req.getParameter(paramName);

			param.put(paramName, paramValue);
		}
		
		List<Map> boards1 = boardService.getBoardsByDepth(1);
		List<Map> boards2 = boardService.getBoardsByDepth(2);
		
		HttpSession session = req.getSession();
		Member loginedMember = (Member) session.getAttribute("loginedMember");
		
		if(loginedMember != null) {
			isLogined = true;
		}
		
		req.setAttribute("boards", boards1);
		req.setAttribute("boards2", boards2);
		req.setAttribute("isLogined", isLogined);
		req.setAttribute("isAjax", isAjax);
		req.setAttribute("requestURI", requestURI);
		req.setAttribute("loginedMember", loginedMember);
		
		return true;
	}
}
