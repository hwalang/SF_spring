package common;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {

	// Connection 객체를 가져온다.
	public static Connection getConnection() {

		Connection con = null;
		try {
			// Connection Pool을 먼저 java 실행환경( tomcat )으로부터 이름을 전달하고 그 객체를 얻는다.
			Context context = new InitialContext();
			DataSource ds = (DataSource) context.lookup("java:comp/env/jdbc/enjoy_trip"); // "규칙 + jdbc/mysql"
			// Connection Pool로부터 Connection 객체를 얻는다.
			con = ds.getConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return con;
	}

	// DB 자원 회수
//	public static void releaseConnection(ResultSet rs, PreparedStatement pstmt, Connection con) {
//
//		try {
//			// 귀한 자원 역순으로 null 체크하면서 close()
//			if (rs != null)
//				rs.close();
//			if (pstmt != null)
//				pstmt.close();
//			if (con != null)
//				con.close();	// ConnectionPool에 반납
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//	}
	
	public static void releaseConnection(AutoCloseable... params) {
	
	for (AutoCloseable ac : params) {
		if ( ac != null ) {
			try {
				ac.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
}
}
