package com.mycom.enjoytrip.user.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.sql.DataSource;

import org.springframework.stereotype.Repository;

import com.mycom.enjoytrip.common.DBManager;
import com.mycom.enjoytrip.user.dto.UserDto;

@Repository
public class UserDaoImpl implements UserDao {
	
	private final DataSource dataSource;
	public UserDaoImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public int userRegist(UserDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = -1;
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("insert into users (userEmail, userPwd, userNm) ");
			sb.append("values (?,?,?) ");
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getUserEmail());
			pstmt.setString(2, dto.getUserPwd());
			pstmt.setString(3, dto.getUserNm());
			
			rs = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return rs;
	}

	@Override
	public int userUpdate(UserDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int rs = -1;
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("update users set userPwd=?, userNm=? ");
			sb.append(" where userEmail=? ");
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, dto.getUserPwd());
			pstmt.setString(2, dto.getUserNm());
			pstmt.setString(3, dto.getUserEmail());
			
			rs = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return rs;
	}

	@Override
	public UserDto userDetail(String userEmail) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		System.out.println(userEmail);
		UserDto userDto = null;
		
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("select *  ");
			sb.append(" from users where userEmail = ? ");
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			
			pstmt.setString(1, userEmail);
			
			rs = pstmt.executeQuery();
			
			if (rs.next()) {

				userDto = new UserDto();
				userDto.setUserEmail(rs.getString("userEmail"));
				userDto.setUserNm(rs.getString("userNm"));
				userDto.setUserPhone(rs.getString("userPhone"));
				userDto.setUserProfile(rs.getString("userProfile"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return userDto;
	}
	
	@Override
	public UserDto userLogin(String userId, String userPwd) {
		
		return null;
	}

	@Override
	public void userLogout() {
		// TODO Auto-generated method stub
		
	}


	

}
