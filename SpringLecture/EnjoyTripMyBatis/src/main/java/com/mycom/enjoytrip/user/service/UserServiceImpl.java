package com.mycom.enjoytrip.user.service;

import org.springframework.stereotype.Service;

import com.mycom.enjoytrip.user.dao.UserDao;
import com.mycom.enjoytrip.user.dto.UserDto;

@Service
public class UserServiceImpl implements UserService {

	private final UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		super();
		this.userDao = userDao;
	}


	@Override
	public int userRegist(UserDto dto) {
		return userDao.userRegist(dto);
	}

	@Override
	public UserDto userDetail(String userEmail) {
		return userDao.userDetail(userEmail);
	}

	@Override
	public int userUpdate(UserDto dto) {
		
		// 정보 수정하기 전에 비밀번호 확인하는 페이지를 거친다.
		// ex. jobssafy
		
		return userDao.userUpdate(dto);
	}


	@Override
	public UserDto userLogin(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void userLogout() {
		// TODO Auto-generated method stub
		
	}

}
