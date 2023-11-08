	
package user.service;

import user.dto.UserDto;

public interface UserService {
    int userRegister(UserDto userDto);
    boolean isIdUnique(String userId);
    int userEdit(String userId, String userName, String userPassword);
    int userDelete(String userId);
}