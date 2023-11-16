package com.mycom.myboard.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;
import com.mycom.myboard.board.service.BoardService;
import com.mycom.myboard.user.dto.UserDto;

@RestController
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	@GetMapping(value="boards")
	public BoardResultDto boardList(BoardParamDto boardParamDto) {
		BoardResultDto boardResultDto = boardService.boardList(boardParamDto);
		return boardResultDto;
	}
	
	// session에서 로그인 정보를 받아온다. -> loginInterceptor가 필요
	// multipart/form-data를 받아온다.
	@PostMapping(value="/boards")
	public BoardResultDto boardInsert(BoardDto boardDto, MultipartHttpServletRequest request) {
		boardDto.setUserSeq(((UserDto)request.getSession().getAttribute("userDto")).getUserSeq());
		BoardResultDto boardResultDto = boardService.boardInsert(boardDto, request);
		return boardResultDto;
	}
}
