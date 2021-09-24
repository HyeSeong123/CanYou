package egovframework.example.util;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.servlet.ModelAndView;

public class Util {

	public static String msgAndBack(HttpServletRequest req, String msg) {
		req.setAttribute("historyBack", true);
		req.setAttribute("msg", msg);
		return "common/redirect";
	}

	public static String msgAndReplace(HttpServletRequest req, String msg, String redirectUrl) {
		req.setAttribute("redirectUrl", redirectUrl);
		req.setAttribute("msg", msg);
		return "common/redirect";
	}
}
