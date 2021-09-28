package egovframework.example.interceptor;

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

@Component("beforeActionInterceptor")
public class BeforeActionInterceptor extends HandlerInterceptorAdapter{

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object Handler) throws Exception{
		
		boolean isLogined = false;
		boolean isAjax = false;
		
		String requestURI = req.getRequestURI();
		
		List<Map> boards1 = boardService.getBoardsByDepth(1);
		
		HttpSession session = req.getSession();
		
		Member loginedMember = (Member) session.getAttribute("loginedMember");
		
		req.setAttribute("boards", boards1);
		req.setAttribute("isLogined", isLogined);
		req.setAttribute("isAjax", isAjax);
		req.setAttribute("requestURI", requestURI);
		req.setAttribute("loginedMember", loginedMember);
		
		return true;
	}
}
