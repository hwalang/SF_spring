package com.mycom.enjoytrip.service;

import java.util.List;

import com.mycom.enjoytrip.dto.BoardDto;


public interface BoardService {

	List<BoardDto> boardList();					// 게시글 목록
	BoardDto boardDetail(int boardId);			// 게시글 상세 정보
	int boardWrite(BoardDto dto);				// 게시글 작성
	int boardEdit(BoardDto dto);				// 게시글 수정
	int boardDelete(int boardId);				// 게시글 삭제
	
}
