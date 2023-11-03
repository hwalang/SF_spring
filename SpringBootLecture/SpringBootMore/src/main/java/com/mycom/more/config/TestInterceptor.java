package com.mycom.more.config;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Component
public class TestInterceptor implements HandlerInterceptor {

	// DispatcherServlet에서 Controller로 들어가기 전에 호출 -> 로그인 체크
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("TestInterceptor >>> " + request.getRequestURI());
		
		// #1 무조건 통과
		// return true;	// 통과시켜서 Controller로 들어간다.
		
		// #2 선택적인 통과: 로그인 했으면 통과
		// 세션에 "login":"success" 데이터가 있으면 통과
		// 없으면 "/login" 페이지로 이동
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("login");
		if ("success".equals(login))
			return true;
		
		response.sendRedirect(request.getContextPath() + "/login");
		return false;
	}

}
