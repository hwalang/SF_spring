package loginout.service;

import user.dto.UserDto;

public interface LoginoutService {
	UserDto login(String userId, String userPassword);
}
