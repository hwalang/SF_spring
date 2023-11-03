package com.mycom.enjoytrip.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.enjoytrip.dto.UserDto;
import com.mycom.enjoytrip.service.UserService;

@RestController
//@CrossOrigin(origins="*", allowedHeaders="*")
public class UserController {
	
	@Autowired
	UserService service;

	@PostMapping("users")
	public int regist(UserDto dto) {
		System.out.println("UserController regist");
		return service.regist(dto);
	}
	
	@GetMapping("users")
	public UserDto login(UserDto dto, HttpSession session) {
		
		UserDto userDto = service.login(dto);
		if (userDto != null) {
			System.out.println("로그인 성공");
			session.setAttribute("userDto", userDto);
			session.setAttribute("login", "ok");
			System.out.println("session에 userDto, login-ok 저장");
		}
		else {
			System.out.println("로그인 실패");
		}
		
		return userDto;
	}
	
	@GetMapping("users/{userId}")
	public UserDto detail(@PathVariable int userId) {
		return service.detail(userId);
	}
	
	@PutMapping("/users/{userId}")
	public int update(@PathVariable int userId, UserDto dto) {
		return service.update(dto);
	}
	
	@DeleteMapping("/users/{userId}")
	public int delete(@PathVariable int userId) {
		return service.delete(userId);
	}
}
