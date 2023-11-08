package com.mycom.enjoytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.enjoytrip.dto.BoardDto;
import com.mycom.enjoytrip.service.BoardService;

@RestController
//@CrossOrigin(origins="*", allowedHeaders="*")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	// 게시판 글 목록
	@GetMapping("/boards")
	public List<BoardDto> boardList() {
		List<BoardDto> list = service.boardList();
		System.out.println(list);
		return list;
	}
	
	// 글 상세보기
	@GetMapping("/boards/{boardId}")
	public BoardDto boardDetail(@PathVariable int boardId) {
		BoardDto dto = service.boardDetail(boardId);
		System.out.println(dto);
		return dto;
	}
	
	// 글 작성
	@PostMapping("/boards")
	public int boardWrite(BoardDto dto) {
		return service.boardWrite(dto);
	}
	
	// 글 수정
	@PutMapping("/boards/{boardId}")
	public int boardEdit(@PathVariable int boardId, BoardDto dto) {
		return service.boardEdit(dto);
	}

	// 글 삭제
	@DeleteMapping("/boards/{boardId}")
	public int boardDelete(@PathVariable int boardId) {
		return service.boardDelete(boardId);
	}
}
