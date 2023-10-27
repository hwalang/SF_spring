package com.mycom.basic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UrlMappingController {

	@RequestMapping(value = "/hello")
	public String m0() {
		System.out.println("/hello");
		return "/hello";
	}
	
	@RequestMapping(value = { "/hello1", "/hello2", "/hello3" })
	public String m0_2() {
		System.out.println("/hello123");
		return "/hello123";
	}
	
	@RequestMapping("/subtest/**")	// subset/aewf/awfewa/fwfaw/efawef/awefw/aef/waefa/w 가능
	public String m8_2() {
		System.out.println("/subtest/**");
		return "/subtest/**";
	}
	

	// method type 지정( GET, POST, PUT - REST API )
	@RequestMapping(value = "/method", method = RequestMethod.GET)
	public String m2() {
		System.out.println("/method get");
		return "/get";
	}
	@RequestMapping(value = "/method", method = RequestMethod.POST)
	public String m3() {
		System.out.println("/method post");
		return "/post";
	}

	@RequestMapping(value = "/method/{num}", method = RequestMethod.PUT) // put - key:value
	public String m4(@PathVariable int num) { // put 방식으로 받은 param의 value를 num으로 받는다.
		System.out.println("/method put num: " + num);
		return "/put";
	}
	// http://localhost:8080/myapp/method/123/and/hello
	@RequestMapping(value = "/method/{num}/and/{str}", method = RequestMethod.PUT) // put - key:value
	public String m5(@PathVariable int num, @PathVariable String str) { // put 방식으로 받은 param의 value를 num으로 받는다.
		System.out.println("/method put num: " + num);
		System.out.println("/method put str: " + str);
		return "/put num-str";
	}

	// 2. Url Mapping - @GetMapping
	@GetMapping(value = "/getmapping")
	public String m6() {
		System.out.println("/getmapping");
		return "/getmapping";
	}

	
	// 3. Url Mapping - @PostMapping
	@PostMapping(value = "/postmapping")
	public String m7() {
		System.out.println("/postmapping");
		return "/postmapping";
	}
}
