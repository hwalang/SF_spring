package main.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.SidoDto;

public class MainDaoImpl implements MainDao {

	@Override
	public List<SidoDto> sidoList() {
		System.out.println("MainDaoImpl: sidoList");
		
		List<SidoDto> list = new ArrayList<>();
		
		// Query문을 작성하고 결과를 받는다.
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();

			// Statement 객체 - select
			pstmt = con.prepareStatement("SELECT sido_code, sido_name FROM sido;");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				// 테이블 컬럼의 타입에 맞게 ResultSet 객체의 getXXX() 호출하고 결과를 받는다.
				int sidoCode = rs.getInt("sido_code");
				String sidoName = rs.getString("sido_name");
				
				// 데이터가 있으면 추가
				list.add(new SidoDto(sidoCode, sidoName));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		// 해당 list를 받는 class에서 null check 해야 한다.
		return list;
	}

}
