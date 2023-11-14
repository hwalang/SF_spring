package loginout.dao;

import user.dto.UserDto;

public interface LoginoutDao {
	UserDto login(String userId);
}
