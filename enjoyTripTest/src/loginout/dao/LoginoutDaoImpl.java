package loginout.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.DBManager;
import dto.SidoDto;
import dto.UserDto;

public class LoginoutDaoImpl implements LoginoutDao {

	@Override
	public UserDto login(String userEmail) {
		
		System.out.println("LoginoutDaoImpl");
		UserDto userDto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();

			// Statement 객체 - select
			StringBuilder sb = new StringBuilder();
			sb	.append("SELECT user_id, user_name, user_email, user_phone, user_password FROM users ")
				.append(" where user_email=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userEmail);
			
			System.out.println(pstmt.toString());
			
			rs = pstmt.executeQuery();
			
			
			// user_email이 있는 경우
			if (rs.next()) {
				userDto = new UserDto(
						rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_phone"),
						rs.getString("user_password")
				);
				System.out.println("LoginoutDaoImpl: " + userDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return userDto;
	}

	@Override
	public UserDto SearchFromId(int userId) {
		System.out.println("SearchFromId");
		
		UserDto userDto = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();

			// Statement 객체 - select
			StringBuilder sb = new StringBuilder();
			sb	.append("SELECT user_id, user_name, user_email, user_phone, user_password FROM users ")
				.append(" where user_id=?");
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, userId);
			
			System.out.println(pstmt.toString());
			
			rs = pstmt.executeQuery();
			
			
			// user_email이 있는 경우
			if (rs.next()) {
				userDto = new UserDto(
						rs.getInt("user_id"),
						rs.getString("user_name"),
						rs.getString("user_email"),
						rs.getString("user_phone"),
						rs.getString("user_password")
				);
				System.out.println("LoginoutDaoImpl: " + userDto);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		
		return userDto;
	}

}
