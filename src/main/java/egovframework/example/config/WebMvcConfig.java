package egovframework.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter{
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		registry.addMapping("/**");
	}
	
	@Autowired
	@Qualifier("beforeActionInterceptor")
	HandlerInterceptor beforeActionInterceptor;
	
	@Autowired
	@Qualifier("needToLoginInterceptor")
	HandlerInterceptor needToLoginInterceptor;
	
	@Autowired
	@Qualifier("needToLogoutInterceptor")
	HandlerInterceptor needToLogoutInterceptor;
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(beforeActionInterceptor).addPathPatterns("/**").excludePathPatterns("/resource/**")
		.excludePathPatterns("/gen/**");
		
		registry.addInterceptor(needToLoginInterceptor)
		.addPathPatterns("/**")
		.excludePathPatterns("/")
		.excludePathPatterns("/index.do")
		.excludePathPatterns("/member/join.do")
		.excludePathPatterns("/member/doJoin.do")
		.excludePathPatterns("/member/doLogin.do")
		.excludePathPatterns("/member/login.do")
		.excludePathPatterns("/login/accessDenine.do")
		.excludePathPatterns("/member/find.do")
		.excludePathPatterns("/member/doFind.do");
		
		registry.addInterceptor(needToLogoutInterceptor)
		.addPathPatterns("/member/login.do")
		.addPathPatterns("/member/doLogin.do")
		.addPathPatterns("/member/join.do")
		.addPathPatterns("/member/doJoin.do")
		.addPathPatterns("/member/find.do")
		.addPathPatterns("/member/doFind.do");
	}
}
