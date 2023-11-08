package user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import common.DBManager;
import user.dto.UserDto;

public class UserDaoImpl implements UserDao{
    
    private static UserDaoImpl instance = new UserDaoImpl();
    
    private UserDaoImpl() {}

    public static UserDaoImpl getInstance() {
        return instance;
    }
    
    @Override
    public int userRegister(UserDto userDto) {

        Connection con = null;
        PreparedStatement pstmt = null;
        
        int ret = -1;
        
        try {
            con = DBManager.getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(" insert into users ")
                .append(" ( user_id, user_pw, user_nm, profile_img ) ")
                .append(" values( ?, ?, ?, null)");
            
            pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1,  userDto.getUserId());
            pstmt.setString(2,  userDto.getUserPassword());
            pstmt.setString(3,  userDto.getUserName());
//            pstmt.setString(4,  userDto.getProfileImg());
            

            ret = pstmt.executeUpdate();

        }catch(Exception e) {            
            e.printStackTrace();
        }finally {
            DBManager.releaseConnection(pstmt, con);
        }
        
        return ret;
    }

    @Override
    public boolean isIdUnique(String userId) {
        Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        boolean ret = false;
        
        try {
            con = DBManager.getConnection();
            StringBuilder sb = new StringBuilder();
            sb.append(" select count(*) cnt ")
                .append(" from users ")
                .append(" where user_id = ? ");
            
            pstmt = con.prepareStatement(sb.toString());
            pstmt.setString(1, userId);
            
            rs = pstmt.executeQuery();
            
            if( rs.next() ) {
                int cnt = rs.getInt("cnt");
                if( cnt == 0 ) ret = true;
            }

        }catch(Exception e) {            
            e.printStackTrace();
        }finally {
            DBManager.releaseConnection(rs, pstmt, con);
        }
        
        return ret;
    }

}