package bookmark.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bookmark.dto.BookmarkDto;
import bookmark.service.*;

@WebServlet("/Bookmark")
public class BookmarkServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private BookmarkService bookmarkService = new BookmarkServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		switch (action) {
		case "showBookmark" : showBookmark(request, response); break;
		case "addBookmark" : addBookmark(request, response); break;	
		case "delBookmark" : delBookmark(request, response); break;		
		}
	}

	private void delBookmark(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("delete bookmark");
		
	}

	private void addBookmark(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("add bookmark");
		//int userNum = request.getParameter("userNum");
		//int contentId = request.getParameter("contentId");
	}

	private void showBookmark(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("show bookmark");
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
