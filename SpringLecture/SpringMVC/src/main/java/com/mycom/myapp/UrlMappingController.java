package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/mvc")
public class UrlMappingController {

	// 1. Url Mapping - RequestMapping

	// void: jsp로 분기하지 않는다. -> return 값이 없기 때문
	// http://localhost:8080/myapp/hello 로 이동
	@RequestMapping(value = "/hello")
	public void m0() {
		System.out.println("/hello");
	}

	// 하나의 method가 2개 이상의 url을 받을 수 있다. -> 반대는 안 된다.
	@RequestMapping(value = { "/hello1", "/hello2", "/hello3" })
	public void m0_2() {
		System.out.println("/hello123");
	}

	// value 생략 및 sub domain 가능
	@RequestMapping("/hello/ssafy")
	public void m1() {
		System.out.println("/hello/ssafy");
	}
	@RequestMapping("/subtest/*")	// subtest/아무거나
									// subtest만 작성하면 인식할 수 없다.
									// subtest/afeaw/daf : 바로 밑 주소까지만 인식한다.
	public void m8() {
		System.out.println("/subtest/*");
	}
	@RequestMapping("/subtest/**")	// subset/aewf/awfewa/fwfaw/efawef/awefw/aef/waefa/w 가능
	public void m8_2() {
		System.out.println("/subtest/*");
	}
	

	// method type 지정( GET, POST, PUT - REST API )
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public void m2() {
		System.out.println("/method get");
	}
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public void m3() {
		System.out.println("/method post");
	}

	@RequestMapping(value = "/method/{num}", method = RequestMethod.PUT) // put - key:value
	public void m4(@PathVariable int num) { // put 방식으로 받은 param의 value를 num으로 받는다.
		System.out.println("/method put num: " + num);
	}
	// http://localhost:8080/myapp/method/123/and/hello
	@RequestMapping(value = "/method/{num}/and/{str}", method = RequestMethod.PUT) // put - key:value
	public void m5(@PathVariable int num, @PathVariable String str) { // put 방식으로 받은 param의 value를 num으로 받는다.
		System.out.println("/method put num: " + num);
		System.out.println("/method put str: " + str);
	}

	
	
	// 2. Url Mapping - @GetMapping
	@GetMapping(value = "/getmapping")
	public void m6() {
		System.out.println("/getmapping");
	}

	
	
	// 3. Url Mapping - @PostMapping
	@PostMapping(value = "/postmapping")
	public void m7() {
		System.out.println("/postmapping");
	}
}
