package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import common.DBManager;
import main.dto.SidoDto;

public class MainDaoImpl implements MainDao {
	
	@Override
	public List<SidoDto> sidoList(){
		List<SidoDto> list = new ArrayList<SidoDto>();
		
		Connection con = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
        	con = DBManager.getConnection();
        	
            // Statement 객체 - select
            pstmt = con.prepareStatement("select sido_code, sido_name from sido;");
            rs = pstmt.executeQuery();
            
            while( rs.next() ) {
            	// 테이블 컬럼의 타입에 맞게 ResultSet 객체의 getXXX() 호출하고 결과를 받는다.
                list.add(new SidoDto(rs.getInt("sido_code"),rs.getString("sido_name") ));
            }
            System.out.println("sidoList(main.dao): "+list);
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
        	DBManager.releaseConnection(rs, pstmt, con);
        }
		return list;


	}
}
