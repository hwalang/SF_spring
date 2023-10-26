package com.mycom.enjoytrip.user.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.enjoytrip.user.dto.UserDto;

@Mapper
public interface UserDao {

	// 회원가입, 로그인, 로그아웃, 정보 수정, 회원 탈퇴
	int userRegist(UserDto dto);
	int userUpdate(UserDto dto);
	UserDto userDetail(String userEmail);
	
	
	void userLogout();
	UserDto userLogin(@Param("userEmail") String userEmail, @Param("userPwd") String userPwd);
}
