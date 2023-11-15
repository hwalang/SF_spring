package com.mycom.myboard.auth.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.auth.service.LoginService;
import com.mycom.myboard.user.dto.UserDto;

@RestController
public class LoginController {

	@Autowired
	LoginService loginService;
	
	// UserController와 같은 방식으로 사용하는 것을 권장
	// 여기서는 다양한 방식을 사용하는 관점에서
	// json result : success | fail를 map으로 전달
	@PostMapping(value="login")
	public Map<String, String> login(@RequestBody UserDto dto, HttpSession session) {
		UserDto userDto = loginService.login(dto);
		Map<String, String> map = new HashMap<>();
		
		// 성공
		if ( userDto != null ) {
			session.setAttribute("userDto", userDto);	// server가 사용
			
			// client가 필요한 정보
			map.put("result", "success");
			map.put("userName", userDto.getUserName());
			map.put("userProfileImageUrl", userDto.getUserProfileImageUrl());
			
			return map;
		}
		// 실패
		map.put("result", "fail");
		return map;
	}
	
	@GetMapping(value="logout")
	public Map<String, String> logout(HttpSession session) {
		session.invalidate();
		
		Map<String, String> map = new HashMap<>();
		map.put("result", "success");
		
		return map;
	}
}
