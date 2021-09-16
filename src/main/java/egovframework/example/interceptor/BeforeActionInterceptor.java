package egovframework.example.interceptor;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import egovframework.example.service.BoardService;

public class BeforeActionInterceptor extends HandlerInterceptorAdapter{

	@Resource(name="boardService")
	private BoardService boardService;
	
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object Handler) throws Exception{
		
		List<Map> boards1 = boardService.getBoardsByDepth(1);
		
		req.setAttribute("boards", boards1);
		
		return true;
	}
}
