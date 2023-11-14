package loginout.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import user.dto.UserDto;
import loginout.service.LoginoutService;
import loginout.service.LoginoutServiceImpl;

@WebServlet("/loginout")
public class LoginoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private LoginoutService loginoutService = new LoginoutServiceImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String job = request.getParameter("job");
		switch(job) {
		case "logout": logout(request, response); break;
		case "login": loginAjax(request, response); break;
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private void loginAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("login");
		String userId = request.getParameter("userId");
		String userPassword = request.getParameter("userPassword");
		System.out.println(userId);
		System.out.println(userPassword);
		
		// DB 로그인 성공
		// 사용자 정보를 DB에서 가져와 UserDto 객체를 만든 후 session에 저장
		UserDto userDto = loginoutService.login(userId, userPassword);		
		
		Gson gson = new Gson();
		JsonObject jsonObject = new JsonObject();
		
		// 성공
		if (userDto != null) {
			request.getSession().setAttribute("userDto", userDto);
			jsonObject.addProperty("result", "success");
		}
		else {
			jsonObject.addProperty("result", "fail");
		}
		
		String jsonStr = gson.toJson(jsonObject);
		System.out.println(jsonStr);
		
		response.getWriter().write(jsonStr);
	}
	
	protected void logout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("logout");
		request.getSession().invalidate();  // 세션 무효화
		
		// 화면
		request.getRequestDispatcher("/main").forward(request, response);
	}

}
