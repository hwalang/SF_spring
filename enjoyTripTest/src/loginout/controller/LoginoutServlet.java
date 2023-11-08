package loginout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import dto.UserDto;
import loginout.service.LoginoutService;
import loginout.service.LoginoutServiceImpl;

@WebServlet("/loginout")
public class LoginoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private LoginoutService loginoutService = new LoginoutServiceImpl();
	private String path = null;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String job = request.getParameter("job");
		path = request.getParameter("path");

		switch (job) {
		case "login":
			login(request, response);
			break;
		case "login_ajax":
			loginAjax(request, response);
			break;
		case "logout":
			logout(request, response);
			break;
		case "register":
			register(request, response);
			break;
		case "leave":
			break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

	private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("LoginoutServlet - login");

		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");

		System.out.println(userEmail);
		System.out.println(userPassword);

		// 사용자정보를 DB에서 가져와서 UserDto 객체를 만든 후 session에 저장
		UserDto userDto = loginoutService.login(userEmail, userPassword); // 비번은 보호

		// 성공
		if (userDto != null) {
			request.getSession().setAttribute("userDto", userDto);
			
			// path에 따라 경로를 변경한다.
			if (path.equals("index") || path.equals("mypage")) {
				request.getRequestDispatcher("/index.jsp").forward(request, response);
			} else if (path.equals("find")) {
				request.getRequestDispatcher("/find.jsp").forward(request, response);
			} else if (path.equals("board")) {
				request.getRequestDispatcher("/board.jsp").forward(request, response);
			} else if (path.equals("tripDetail")) {
				request.getRequestDispatcher("/tripDetail.jsp").forward(request, response);
			}
			
		} else { // 실패
			System.out.println("로그인 실패 !!");
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		}

		// action은 무조건 동기 처리하기 때문에 새로운 페이지를 만들어줘야 한다.
		// 하지만 ajax를 사용하면 비동기 처리할 수 있다.

	}

	private void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginoutServlet - logout");

		// session에 저장된 userDto를 제거한다.
		// removeAttribute: 데이터는 지워지지만 공간은 살아있다.
		// invalidate: session 공간까지 제거한다.
		request.getSession().invalidate();

		// 돌아가기
		request.getRequestDispatcher("/index.jsp").forward(request, response);
	}

	private void loginAjax(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("LoginoutServlet - loginAjax");

		String userEmail = request.getParameter("userEmail");
		String userPassword = request.getParameter("userPassword");
		System.out.println(userEmail);
		System.out.println(userPassword);

		UserDto userDto = loginoutService.login(userEmail, userPassword);
		System.out.println(userDto);

		// Tomcat에 gson.jar를 넣었다.
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		// 성공
		if (userDto != null) {
			request.getSession().setAttribute("userDto", userDto);
			jsonObject.addProperty("result", "success");
		} else { // 실패
			jsonObject.addProperty("result", "fail");
		}

		String jsonStr = gson.toJson(jsonObject);	// "success" 또는 "fail"
		System.out.println(jsonStr);
		
		response.getWriter().write(jsonStr);
	}

	private void register(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("register");
	}

}
