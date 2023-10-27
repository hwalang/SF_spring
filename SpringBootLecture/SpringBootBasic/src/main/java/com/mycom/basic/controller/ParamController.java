package com.mycom.basic.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.basic.dto.CarDto;

@RestController
public class ParamController {
	
	// 데이터를 받아서 로그인 성공, 게시글 작성, 수정 등 다양한 데이터 입력을 받고
	// response를 내려준 뒤 성공했을 때, 특정 페이지로 이동시키려면 controller를 다시 수행하는 것이 아니라
	// js로 페이지 이동을 수행한다.
	@GetMapping("/param1")
	public Map<String, String> m1(HttpServletRequest request) { 
		String seq = request.getParameter("seq");
		System.out.println(seq);
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;		// 로그인이 성공하면 js로 페이지 이동을 수행( window.location ... )
	}
	
	
	// 회원가입, 게시글 작성할 때 유용
	// 데이터를 DB에 저장한 뒤에 map 데이터를 보내준다.
	@PostMapping("/car")
	public Map<String, String> m2(CarDto dto) {
		System.out.println(dto);
		System.out.println("insert success!!");
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
	
	// 사용자가 입력한 dto를 session에 저장한다.
	@PostMapping("/car2")
	public Map<String, String> m3(CarDto dto, HttpSession session) {
		System.out.println(dto);
		System.out.println("insert success!!");
		session.setAttribute("carDto", dto);		// session에 dto 담기
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		return map;
	}
	
	
	// session에 있는 dto를 가져와서 html에 보낸다.
	@GetMapping("/car3")
	public CarDto m4(HttpSession session) {
		System.out.println("select car detail");
		CarDto dto = (CarDto) session.getAttribute("carDto");		// session에 dto 담기

		return dto;
	}
	
}
