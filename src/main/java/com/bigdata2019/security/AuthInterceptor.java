package com.bigdata2019.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class AuthInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(
		HttpServletRequest request, 
		HttpServletResponse response,
		Object handler)
			throws Exception {
		
		//1. Handler 종류(DefaultServletHttpRequestHandler or HandlerMethod ?)
		if( handler instanceof HandlerMethod == false) {
			return true;
		}
		
		//2. casting
		HandlerMethod handlerMethod = (HandlerMethod)handler;
		
		//3. @Auth 받기
		Auth auth = handlerMethod.getMethodAnnotation(Auth.class);
		
		//4. @Auth 가 없다면 통과
		if(auth == null) {
			return true;
		}
		
		//5. 인증여부 체크
		HttpSession session = request.getSession();
		if(session == null || session.getAttribute("authUser") == null ) {
			response.sendRedirect(request.getContextPath() + "/user/login");
			return false;
		}
		
		//6. 통과
		return true;
	}

}
