package com.mycom.myadv.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Interceptor는 JSP를 사용하지 않고, JSON만 리턴한다.
@RestController // @Controller + @ResponsBody
				// 모든 method에 @ResponseBody 를 붙여준다.
public class TestInterceptorController {

	@GetMapping("/login")
	public String m1() {
		System.out.println("Interceptor Controller: /login");
		return "/login";
	}

	// 로그인 성공 페이지 요청
	@GetMapping("/login/ok")
	public String m2(HttpSession session) {
		System.out.println("Interceptor Controller: /login/ok");
		session.setAttribute("login", "success");
		return "/login/ok";
	}

	// 로그아웃( 로그인 후 접근 가능 )
	@GetMapping("/logout")
	public String m3(HttpSession session) {
		System.out.println("Interceptor Controller: /logout");
		session.invalidate();
		return "/logout";
	}
	
	// 마이페이지( 로그인 후 접근 가능 )
	@GetMapping("/users")
	public String m4() {
		System.out.println("Interceptor Controller: /users");
		return "/users";
	}
}
