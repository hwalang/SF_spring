package com.mycom.enjoytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.enjoytrip.dto.BoardDto;
import com.mycom.enjoytrip.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@GetMapping("/boardList")
	public List<BoardDto> boardList() {
		List<BoardDto> list = service.boardList();
		System.out.println(list);
		return list;
	}
	
	@GetMapping("/boardDetail/{boardId}")
	public BoardDto boardDetail(@PathVariable int boardId) {
		BoardDto dto = service.boardDetail(boardId);
		System.out.println(dto);
		return dto;
	}
	

}
