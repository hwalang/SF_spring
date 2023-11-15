package com.mycom.myboard.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;
import com.mycom.myboard.board.service.BoardService;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping(value="boards")
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = boardService.boardList(boardParamDto);
		return boardResultDto;
	}
}
