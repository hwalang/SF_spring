package map.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import main.dto.SidoDto;
import main.dto.GugunDto;
import user.dto.UserDto;

public class MapDaoImpl implements MapDao {

	@Override
	public List<GugunDto> gugunList(int sidoCode) {
		List<GugunDto> list =  new ArrayList<GugunDto>();
        
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        
        try {
            con = DBManager.getConnection();
            
            StringBuilder sb = new StringBuilder();
            sb.append("select gugun_code, gugun_name from gugun ")
            .append(" where sido_code=?");
            
            pstmt = con.prepareStatement(sb.toString());
            pstmt.setInt(1, sidoCode);
            
            rs = pstmt.executeQuery();

            while (rs.next()) {
                // 테이블 컬럼의 타입에 맞게 ResultSet 객체의 getXXX() 호출하고 결과를 받는다.
            	list.add(new GugunDto(
            		rs.getInt("gugun_code"),
            		rs.getString("gugun_name"),
            		rs.getInt("sido_code")
        		));
            }
            System.out.println("gugunList(map.dao): "+list);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            DBManager.releaseConnection(rs, pstmt, con);
        }

		return list;
	}
}
