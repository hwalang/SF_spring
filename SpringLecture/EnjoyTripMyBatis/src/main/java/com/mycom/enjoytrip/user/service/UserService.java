package com.mycom.enjoytrip.user.service;

import com.mycom.enjoytrip.user.dto.UserDto;

public interface UserService {

	int userRegist(UserDto dto);
	int userUpdate(UserDto dto);
	UserDto userDetail(String userEmail);
	UserDto userLogin(String userEmail, String userPwd);
	void userLogout();
	
}
