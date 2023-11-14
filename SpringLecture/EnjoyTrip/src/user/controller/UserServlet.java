package user.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import user.dto.UserDto;
import user.service.UserService;
import user.service.UserServiceImpl;

@WebServlet("/user/*")
public class UserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    UserService userService = UserServiceImpl.getInstance();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)    throws ServletException, IOException {        
        process(request, response);
    }
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)    throws ServletException, IOException {        
        process(request, response);
    }
    
    protected void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // encoding
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        
        String contextPath = request.getContextPath();
        String path = request.getRequestURI().substring(contextPath.length());
        
        System.out.println(path);
        
        switch( path ) {
            case "/user/register" : register(request, response); break;
            case "/user/isIdUnique" : isIdUnique(request, response); break;
            case "/user/editInfo" : editInfo(request, response); break;
            case "/user/deleteUser" : editInfo(request, response); break;
        }
        
    }

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
	
	private void editInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
	}

	protected void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        
    	String userId = request.getParameter("userId");
        String userName = request.getParameter("userName");
        String userPassword = request.getParameter("userPassword");
        String repeatPassword = request.getParameter("repeatPassword");

        UserDto userDto = new UserDto();
        userDto.setUserId(userId);
        userDto.setUserName(userName);
        userDto.setUserPassword(userPassword);
        System.out.println(userId +" "+ userName+" "+userPassword+" "+repeatPassword);

        int ret = userService.userRegister(userDto);

        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();

        if (ret == 1) {
            jsonObject.addProperty("result", "success");
        } else {
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        response.getWriter().write(jsonStr);        
    }
    
    protected void isIdUnique(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    
        String userId = request.getParameter("userId");

        boolean ret = userService.isIdUnique(userId);

        Gson gson = new Gson();

        JsonObject jsonObject = new JsonObject();

        if (ret) {
            jsonObject.addProperty("result", "success");
        } else {
            jsonObject.addProperty("result", "fail");
        }

        String jsonStr = gson.toJson(jsonObject);
        response.getWriter().write(jsonStr);        
    }

}