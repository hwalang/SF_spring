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
        // exclude 요청에는 아래 출력 X
        System.out.println("LoginInterceptor >>>> " + request.getRequestURI());
        System.out.println(handler);
        
        // CORS 에서  put, delete 등 오류 해결 코드
        if (request.getMethod().equals("OPTIONS")) {
            return true;
        }
        
        HttpSession session = request.getSession();
        UserDto userDto = (UserDto) session.getAttribute("userDto");

        if( userDto == null ) {
            response.getWriter().write(jsonStr);            
            return false;
        }

        return true;
	}
	
	// 이제 어디에 적용할 건지 정해주면 된다.
	// WebMvcConfig에서 설정한다.

}
