package com.mycom.enjoytrip.user.dao;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.enjoytrip.user.dto.UserDto;

@Mapper
public interface UserDao {

	// 회원가입, 로그인, 로그아웃, 정보 수정, 회원 탈퇴
	int userRegist(UserDto dto);
	int userUpdate(UserDto dto);
	UserDto userDetail(String userEmail);
	UserDto userLogin(String userId, String userPwd);
	void userLogout();
	
}
