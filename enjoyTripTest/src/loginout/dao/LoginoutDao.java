package loginout.dao;

import dto.UserDto;

public interface LoginoutDao {
	
	// password를 넘겨주지 않았는데 어떻게 아이디가 일치하는지 알 수 있나?
	// 이메일로 ID를 검색하고, 해당 ID에 있는 password와 ID를 같이 가져온다. -> email: unique
	// service에서 password가 같은지 확인
	UserDto login(String userEmail);
	
	// ID로 회원정보 불러오기
	UserDto SearchFromId(int userId);
}
