package com.mycom.enjoytrip.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.enjoytrip.user.dto.UserDto;
import com.mycom.enjoytrip.user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

	private final UserService userService;
	public UserController(UserService userService) {
		this.userService = userService;
	}

	// @PostMapping("/regist")
	@GetMapping("/regist")
	public String userReist(UserDto dto) {
		userService.userRegist(dto);
		System.out.println(dto);
		return "login";
	}
	
	@PostMapping("/update")
	public UserDto userUpdate(UserDto dto) {
		userService.userUpdate(dto);
		System.out.println(dto);
		return dto;
	}
	
	
	@PostMapping("/detail")
	@ResponseBody
	public UserDto detail(UserDto userDto) {
		return userService.userDetail(userDto.getUserEmail());
	}
	
	
}
