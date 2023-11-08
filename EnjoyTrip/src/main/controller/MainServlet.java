package main.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import main.dto.SidoDto;
import main.service.MainService;
import main.service.MainServiceImpl;

@WebServlet("/main")
public class MainServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private MainService mainService = new MainServiceImpl();
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        System.out.println("/ request");

        // DB ACCESS
        // 뿌려줄 데이터를 추출
		List<SidoDto> sidoList = mainService.getSidoList();
		
		request.setAttribute("sidoList", sidoList);
		System.out.println(sidoList);
		// forward
		request.getRequestDispatcher("/main.jsp").forward(request, response);
	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
        
    }

}