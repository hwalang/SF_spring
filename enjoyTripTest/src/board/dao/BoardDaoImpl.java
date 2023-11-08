package board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import board.dto.BoardDto;
import common.DBManager;

public class BoardDaoImpl implements BoardDao {

	private static BoardDaoImpl instance = new BoardDaoImpl();

	private BoardDaoImpl() {
	}

	public static BoardDaoImpl getInstance() {
		return instance;
	}

	@Override
	public int boardInsert(BoardDto boardDto) {
		
		System.out.println("daoImpl:" + boardDto);
		Connection con = null;
		PreparedStatement pstmt = null;

		int ret = -1;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("INSERT INTO BOARD ( userSeq, board_writername, board_title, board_content, board_createtime) ");
			sb.append(" VALUES ( ?, ?, ?, ?, now() ); ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardDto.getUserSeq());
			pstmt.setString(2, boardDto.getBoard_writername());
			pstmt.setString(3, boardDto.getBoard_title());
			pstmt.setString(4, boardDto.getBoard_content());

			ret = pstmt.executeUpdate();
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return ret;
	}

	@Override
	public int boardUpdate(BoardDto boardDto) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int ret = -1;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("UPDATE BOARD SET TITLE = ?, CONTENT = ? ");
			sb.append(" WHERE BOARD_ID = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, boardDto.getBoard_title());
			pstmt.setString(2, boardDto.getBoard_content());
			pstmt.setInt(3, boardDto.getBoard_id());

			ret = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return ret;
	}

	@Override
	public int boardDelete(int boardId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		int ret = -1;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();

			StringBuilder sb = new StringBuilder();
			sb.append("DELETE FROM BOARD ");
			sb.append(" WHERE BOARD_ID = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);

			ret = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return ret;
	}

	@Override
	public List<BoardDto> boardList(int limit, int offset) {

		List<BoardDto> list = new ArrayList<BoardDto>();
		System.out.println("전체 다 보이는 곳 들어오니");

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();

			StringBuilder sb = new StringBuilder();
//            sb.append("SELECT b.board_id, b.board_writername, b.board_title, b.board_content, b.board_createtime ");
//            sb.append("  FROM BOARD b, USERS u");
//            sb.append(" ORDER BY b.BOARD_ID DESC");
//            sb.append(" LIMIT ? OFFSET ? ");

			sb.append("SELECT b.board_id, b.userSeq, u.user_name, b.board_title, b.board_content, b.board_createtime ");
			sb.append("  FROM BOARD b, USERS u");
			sb.append(" WHERE b.userSeq = u.user_id ");
			sb.append(" ORDER BY b.BOARD_ID DESC");
			sb.append(" LIMIT ? OFFSET ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, limit);
			pstmt.setInt(2, offset);
			rs = pstmt.executeQuery();

			int cnt = 0;
			while (rs.next()) {
				cnt++;
				BoardDto boardDto = new BoardDto();
				boardDto.setBoard_id(rs.getInt("board_id"));
				
				boardDto.setUserSeq(rs.getInt("userSeq"));
				boardDto.setUserName(rs.getString("user_name"));
				
				boardDto.setBoard_title(rs.getString("board_title"));
				boardDto.setBoard_content(rs.getString("board_content"));
				boardDto.setBoard_createtime(rs.getTimestamp("board_createtime").toString());
				
				list.add(boardDto);
			}
			System.out.println("cnt: " + cnt);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return list;
	}

	@Override
	public int boardListTotalCnt() {
		int totalCnt = -1;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM BOARD");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return totalCnt;
	}

	@Override
	public List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord) {
		List<BoardDto> list = new ArrayList<BoardDto>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBManager.getConnection();

			StringBuilder sb = new StringBuilder();
//			sb.append(
//					"SELECT b.BOARD_ID, b.USER_SEQ, u.USER_NAME, b.TITLE, b.CONTENT, b.REG_DT, b.READ_COUNT ");
//			sb.append("  FROM BOARD b, USERS u");
			sb.append("SELECT b.board_id, b.board_writername, b.board_title, b.board_content, b.board_createtime ");
			sb.append("  FROM BOARD b");
//			sb.append(" WHERE b.USER_SEQ = u.USER_SEQ AND");
			sb.append("  where b.board_title like ? ");
			sb.append(" ORDER BY b.board_id DESC");
			sb.append(" LIMIT ? OFFSET ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, "%" + searchWord + "%");
			pstmt.setInt(2, limit);
			pstmt.setInt(3, offset);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				BoardDto boardDto = new BoardDto();
				boardDto.setBoard_id(rs.getInt("board_id"));
				boardDto.setBoard_writername(rs.getString("board_writername"));
				boardDto.setBoard_title(rs.getString("board_title"));
				boardDto.setBoard_content(rs.getString("board_content"));
				boardDto.setBoard_createtime(rs.getTimestamp("board_createtime").toString());
				list.add(boardDto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return list;
	}

	@Override
	public int boardListSearchWordTotalCnt(String searchWord) {
		int totalCnt = -1;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DBManager.getConnection();
			pstmt = con.prepareStatement("SELECT COUNT(*) FROM BOARD WHERE board_title LIKE ? ");
			pstmt.setString(1, "%" + searchWord + "%");
			rs = pstmt.executeQuery();

			if (rs.next()) {
				totalCnt = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		return totalCnt;
	}

	@Override
	public BoardDto boardDetail(int boardId) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		BoardDto boardDto = null;

		try {
			con = DBManager.getConnection();

			StringBuilder sb = new StringBuilder();
//            sb.append("SELECT b.board_id, b.userSeq, u.userName,");
//            sb.append("       b.board_title, b.board_content, b.board_createtime,");
//            sb.append("  FROM BOARD b, USERS u ");
//            sb.append(" WHERE b.BOARD_ID = ? ");
//            sb.append("   AND b.USER_SEQ = u.USER_SEQ ");

			sb.append("SELECT b.board_id, b.board_writername,");
			sb.append("       b.board_title, b.board_content, b.board_createtime ");
			sb.append("  FROM BOARD b");
			sb.append(" WHERE b.board_id = ? ");

			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, boardId);

			rs = pstmt.executeQuery();

			if (rs.next()) {
				boardDto = new BoardDto();
				boardDto.setBoard_id(rs.getInt("board_id"));
//                boardDto.setUserSeq(rs.getInt("userSeq"));
//                boardDto.setUserName(rs.getString("userName"));
				boardDto.setBoard_writername(rs.getString("board_writername"));
				boardDto.setBoard_title(rs.getString("board_title"));
				boardDto.setBoard_content(rs.getString("board_content"));
				// boardDto.setRegDt(rs.getDate("REG_DT"));
				// boardDto.setRegDt(rs.getDate("REG_DT").toLocalDate ());
				boardDto.setBoard_createtime(rs.getTimestamp("board_createtime").toString());
				System.out.println("BoardDaoImpls boardDetail: "+boardDto);
			}
			
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}
		return boardDto;
	}

}
