package loginout.service;

import user.dto.UserDto;
import loginout.dao.LoginoutDao;
import loginout.dao.LoginoutDaoImpl;

public class LoginoutServiceImpl implements LoginoutService {
	
	private LoginoutDao loginoutDao = new LoginoutDaoImpl();
	
	@Override
	public UserDto login(String userId, String userPassword) {
		UserDto userDto = loginoutDao.login(userId);
		
		if ( userDto != null && userDto.getUserPassword().equals(userPassword) ) {
			// password invalidation
			userDto.setUserPassword(null);
			
			return userDto;
		}
		return null;	// userEmail이 올바르지 않거나, userPassword가 올바르지 않은 2가지가 모두 포함.
	}
}
