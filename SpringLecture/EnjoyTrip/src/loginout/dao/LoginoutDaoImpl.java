package loginout.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBManager;
import user.dto.UserDto;

public class LoginoutDaoImpl implements LoginoutDao {
	
	@Override
	public UserDto login(String userId) {
		UserDto userDto = null;

        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
//        int ret = -1;
        try {

            con = DBManager.getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append("select * from users ")
            .append(" where user_id = ?");
            
            pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, userId);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // 테이블 컬럼의 타입에 맞게 ResultSet 객체의 getXXX() 호출하고 결과를 받는다.
//            	(int userNum, String userId, String userPassword, String userName, String profileImg) 
                userDto = new UserDto(
            		rs.getInt("user_num"),
            		rs.getString("user_id"),
            		rs.getString("user_pw"),
            		rs.getString("user_nm"),
            		rs.getString("profile_img")
        		);
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(rs, pstmt, con);
        }
        return userDto;
    
	}
}
