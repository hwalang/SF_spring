import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.mysql.cj.protocol.Resultset;

public class JDBCTest {
	static Connection conn = null;
	static PreparedStatement pstmt = null;
	static Resultset rs = null;

	public static void main(String[] args) {
		// JDBC Driver Memory Loading.... <= Class.forName(), ClassNotFoundException
		// Connection <= DriverManager.getConnection()	<= id, pwd, url
		// Statement, PreparedStatement <= Connection
		// insert, delete, update => executeUpdate()
		// select => executeQuery() <= ResultSet 객체 <= 목록, 상세 출력
		
		// 자원 반납 - close()
		// SQLException, <= try-catch-finally, AutoClosable...
		
		String url = "jdbc:mysql://localhost:3306/enjoytrip";
		String id = "root";
		String pw = "001004";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, id, pw);
			System.out.println("Connection 객체 생성");
		} catch(Exception e) {
            e.printStackTrace();
        }
		finally {
			
		}
				
	
		
	}
	
	public int insertEmp() {
		StringBuilder sb = new StringBuilder();
		
		
		return -1;
	}
	
	public int updateEmp() {
		return -1;
	}
	
	public int deleteEmp() {
		return -1;
	}
	
	public void selectEmp() {
		
	}
	
	public void selectDetailEmp() {
		
	}
}
