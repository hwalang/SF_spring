package user.service;

import user.dto.UserDto;
import user.dao.UserDao;
import user.dao.UserDaoImpl;

public class UserServiceImpl implements UserService {

	private static UserServiceImpl instance = new UserServiceImpl();

	private UserServiceImpl() {
	}

	public static UserServiceImpl getInstance() {
		return instance;
	}

	UserDao userDao = UserDaoImpl.getInstance();

	@Override
	public int userRegister(UserDto userDto) {
		return userDao.userRegister(userDto);
	}

	@Override
	public boolean isIdUnique(String userId) {
		return userDao.isIdUnique(userId);
	}

	@Override
	public int userEdit(String userId, String userName, String userPassword) {
		
		return 0;
	}

	@Override
	public int userDelete(String userId) {
		
		return 0;
	}

}