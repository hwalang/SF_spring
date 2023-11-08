package user.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBManager;
import dto.UserDto;
import loginout.dao.LoginoutDao;
import loginout.dao.LoginoutDaoImpl;

@WebServlet("/users")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String job = request.getParameter("job");

		switch (job) {
		case "G":
			goUsers(request, response);
			break;
		case "A":
			addUsers(request, response);
			break;
		case "M":
			modifyUsers(request, response);
			break;
		case "D":
			detailUsers(request, response);
			break;
		case "R":
			removeUsers(request, response);
			break;
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void goUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("goUsers");
		// PATH: /-> Webcontent
		request.getRequestDispatcher("/users/users.jsp").forward(request, response);
	}

	// 회원가입
	private void addUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("addUsers");
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userPassword = request.getParameter("userPassword");

		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(userPhone);
		System.out.println(userPassword);

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;

		// DB에 받아온 값을 Insert 해줌!
		try {
			System.out.println("ConnectionPool");
			con = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append("insert into users(user_name, user_email, user_phone, user_password) values(?,?,?,?);");
			System.out.println(sb.toString());
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userPhone);
			pstmt.setString(4, userPassword);
			System.out.println(pstmt.toString());
			
			ret = pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		// 회원등록 성공, 실패
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void modifyUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("modifyUsers");
		
		// 현재 session에서 email 가져오기
		UserDto curUser = (UserDto) request.getSession().getAttribute("userDto");
		
		// 정보 수정에서 가져온 데이터
		String userName = request.getParameter("userName");
		String userEmail = request.getParameter("userEmail");
		String userPhone = request.getParameter("userPhone");
		String userPassword = request.getParameter("userPassword");

		System.out.println(userName);
		System.out.println(userEmail);
		System.out.println(userPhone);
		System.out.println(userPassword);
		
		// Email로 user_id 가져오기
		LoginoutDao loginoutDao = new LoginoutDaoImpl();
		UserDto userDto = loginoutDao.login(curUser.getUserEmail());
		System.out.println("userDto: " + userDto);
		
		int userId = userDto.getUserId();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;

		// UPDATE
		try {
			System.out.println("ConnectionPool");
			con = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append("update users "
					+ "set user_name=?, user_email=?, user_phone=?, user_password=? "
					+ " where user_id=?;");
			System.out.println(sb.toString());
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setString(1, userName);
			pstmt.setString(2, userEmail);
			pstmt.setString(3, userPhone);
			pstmt.setString(4, userPassword);
			pstmt.setInt(5, userId);
			System.out.println(pstmt.toString());
			
			ret = pstmt.executeUpdate();
			// end update
			
			// session에 저장
			curUser = loginoutDao.SearchFromId(curUser.getUserId());
			request.getSession().setAttribute("userDto", curUser);

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		// 업데이트 성공
		request.getRequestDispatcher("/mypage.jsp").forward(request, response);
	}


	// 마이페이지 내정보 표시
	private void detailUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("detailUsers");
		
	}

	
	// 회원 탈퇴
	private void removeUsers(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("removeUsers");
		
		// 세션에 저장된 로그인 정보 가져오기
		UserDto userDto = null;
		
		userDto = (UserDto) request.getSession().getAttribute("userDto");
		System.out.println(userDto);

		int userId = userDto.getUserId();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int ret = -1;

		// DELETE
		try {
			System.out.println("ConnectionPool");
			con = DBManager.getConnection(); // DB와 연결하기
			StringBuilder sb = new StringBuilder();
			sb.append("delete from users where user_id=?;");
			System.out.println(sb.toString());
			pstmt = con.prepareStatement(sb.toString());
			pstmt.setInt(1, userId);
			
			ret = pstmt.executeUpdate();
			
			// session에서 제거
			request.getSession().invalidate();
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBManager.releaseConnection(rs, pstmt, con);
		}

		// 제거 성공
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
