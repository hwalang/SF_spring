package com.mycom.enjoytrip.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.enjoytrip.dao.UserDao;
import com.mycom.enjoytrip.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	public int regist(UserDto dto) {
		System.out.println("UserService regist");
		return dao.regist(dto);
	}

	@Override
	public UserDto login(UserDto dto) {
		System.out.println("로그인 시도");
		return dao.login(dto);
	}

	@Override
	public UserDto detail(int userId) {
		return dao.detail(userId);
	}

	@Override
	public int update(UserDto dto) {
		return dao.update(dto);
	}

	@Override
	public int delete(int userId) {
		return dao.delete(userId);
	}
	
	

}
