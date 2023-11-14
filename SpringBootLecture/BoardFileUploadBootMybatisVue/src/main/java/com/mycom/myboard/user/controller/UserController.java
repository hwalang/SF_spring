package com.mycom.myboard.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.user.dto.UserDto;
import com.mycom.myboard.user.dto.UserResultDto;
import com.mycom.myboard.user.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	UserService userService;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;
	
	// axios - json이 default이기 때문에 param에 @RequestBody를 붙인다.
	// 일반적인 urlParam는 붙이면 안 된다.
	// @RequestBody
	@PostMapping(value="/users")
	public UserResultDto register(@RequestBody UserDto dto) {
		System.out.println(dto);
		UserResultDto userResultDto = userService.userRegister(dto);
		return userResultDto;
	}
}
