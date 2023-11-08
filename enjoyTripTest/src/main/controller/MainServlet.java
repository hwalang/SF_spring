package main.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import common.DBManager;
import dto.SidoDto;
import main.service.MainService;
import main.service.MainServiceImpl;
import map.GugunDto;

// main: 관광지를 처리하는 servlet

//enjoyTripTest
@WebServlet("/map")
public class MainServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private MainService mainService = new MainServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("MainServlet");

		// servlet 하나로 회원 업무를 처리하는 방법
		// parameter를 하나 더 받는다 -> modify, insert, delete 같은 구분할 수 있는 변수
		// 회원 | 게시글 | 관광지
		// 각 페이지마다 발생하는 데이터 작업을 하나의 servlet으로 관리한다?

		// DB 처리
		List<SidoDto> sidoList = mainService.sidoList();
		System.out.println("DB처리 이후의 MainServlet");

		// null 처리?
		request.setAttribute("sidoList", sidoList);

		// find.jsp로 forward
		request.getRequestDispatcher("/find.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
