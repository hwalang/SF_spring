package com.mycom.enjoytrip.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycom.enjoytrip.common.DBManager;
import com.mycom.enjoytrip.dto.BoardDto;

@Repository
public class BoardDaoImpl implements BoardDao {
	
	@Autowired
	DataSource dataSource;

	@Override
	public List<BoardDto> boardList() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<BoardDto> list = new ArrayList<>();
			
		try {
			StringBuilder sb = new StringBuilder();
			// users table의 userId를 기준으로 join 한다.
			// 두 테이블에서 userId 값이 일치한 record만 반환한다.
			sb.append("select b.boardId, b.boardTitle, b.boardRegDate, b.boardLike, b.boardViewCnt, b.userId, u.userNm ");
			sb.append(" from board b ");
			sb.append(" inner join users u ");
			sb.append(" on u.userId = b.userId ");
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				BoardDto dto = new BoardDto();
				dto.setBoardId(rs.getInt("boardId"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setBoardRegDate(rs.getTimestamp("boardRegDate").toLocalDateTime());
				dto.setBoardLike(rs.getInt("boardLike"));
				dto.setBoardViewCnt(rs.getInt("boardViewCnt"));
				dto.setUserId(rs.getInt("userId"));
				dto.setUserNm(rs.getString("userNm"));
				list.add(dto);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return list;
	}

	@Override
	public BoardDto boardDetail(int boardId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		BoardDto dto = null;
		try {
			
			StringBuilder sb = new StringBuilder();
			sb.append("select b.boardId, b.boardTitle, b.boardContent, b.boardRegDate, b.boardLike, b.boardViewCnt, b.userId, u.userNm, u.userProfile ");
			sb.append(" from board b, users u ");
			sb.append(" where b.boardId = ? ");
			sb.append(" and u.userId = b.userId ");
			
			con = dataSource.getConnection();
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				dto = new BoardDto();
				dto.setBoardId(rs.getInt("boardId"));
				dto.setBoardTitle(rs.getString("boardTitle"));
				dto.setBoardContent(rs.getString("boardContent"));
				dto.setBoardRegDate(rs.getTimestamp("boardRegDate").toLocalDateTime());
				dto.setBoardLike(rs.getInt("boardLike"));
				dto.setBoardViewCnt(rs.getInt("boardViewCnt"));
				dto.setUserId(rs.getInt("userId"));
				dto.setUserNm(rs.getString("userNm"));
				dto.setUserProfile(rs.getString("userProfile"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		
		return dto;
	}

	@Override
	public int boardWrite(BoardDto dto) {
		Connection con = null;
		PreparedStatement pstmt = null;
		int ret = -1;
			
		try {
			StringBuilder sb = new StringBuilder();
			sb.append("insert into board (boardTitle, boardContent) ");
			sb.append(" values (?, ?, ?) ");
			
			con = dataSource.getConnection();
//			pstmt = con.prepareStatement(sb.toString());
//			pstmt.setInt(1, dto.getEmployeeId());
//			pstmt.setString(2, dto.getFirstName());
//			pstmt.setString(3, dto.getLastName());
//			pstmt.setString(4, dto.getEmail());
//			pstmt.setString(5, dto.getHireDate());
			
			ret = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(pstmt, con);
		}
		
		return ret;
	}
	
	@Override
	public int boardEdit(BoardDto dto) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int boardDelete(int boardId) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
