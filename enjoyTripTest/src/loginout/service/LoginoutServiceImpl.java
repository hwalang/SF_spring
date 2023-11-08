package loginout.service;

import dto.UserDto;
import loginout.dao.LoginoutDao;
import loginout.dao.LoginoutDaoImpl;

public class LoginoutServiceImpl implements LoginoutService {

	private LoginoutDao loginoutDao = new LoginoutDaoImpl();
	
	@Override
	public UserDto login(String userEmail, String userPassword) {
		System.out.println("LoginoutServiceImpl");
		
		UserDto userDto = loginoutDao.login(userEmail);
		
		// 로그인 성공
		if (userDto != null && userDto.getUserPassword().equals(userPassword)) {
			// password invalidation
			userDto.setUserPassword(null);
			return userDto;
		}
		
		// user_email이 옳바르지 않거나, userPassword가 올바르지 않은 경우
		return null;
	}

	
	
}
