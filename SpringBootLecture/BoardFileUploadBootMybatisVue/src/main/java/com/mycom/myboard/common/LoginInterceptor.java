package com.mycom.myboard.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.mycom.myboard.user.dto.UserDto;

// client에 대한 응답을 성공/실패 - json 문자열  "result":"login"
// client가 login을 받으면 vue에서 login component로 보낸다. 그렇지 않으면 해당 페이지로 이동시킨다.
@Component
public class LoginInterceptor implements HandlerInterceptor {
	
	private final String jsonStr = "{\"result\":\"login\"}";

	// DispatcherServlet에서 Controller로 들어가기 전에 호출 -> 로그인 체크
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		System.out.println("LoginInterceptor >>> " + request.getRequestURI());
		
		// JSP를 사용하지 않기 때문에 비동기 처리만 하면 된다.
		HttpSession session = request.getSession();
		UserDto userDto = (UserDto) session.getAttribute("userDto");
		
		if (userDto == null) {
			// login이 필요하다는 응답을 보내준다.
			response.getWriter().write(jsonStr);
			return false;		// 통과 불가
		}
		
		return true;
	}
	
	// 이제 어디에 적용할 건지 정해주면 된다.
	// WebMvcConfig에서 설정한다.

}
