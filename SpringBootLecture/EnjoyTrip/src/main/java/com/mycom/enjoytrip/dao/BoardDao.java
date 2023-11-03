package com.mycom.enjoytrip.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.mycom.enjoytrip.dto.BoardDto;

@Mapper
public interface BoardDao {

	List<BoardDto> boardList();					// 게시글 목록
	BoardDto boardDetail(int boardId);			// 게시글 상세 정보
	int boardWrite(BoardDto dto);				// 게시글 작성
	int boardEdit(BoardDto dto);				// 게시글 수정
	int boardDelete(int boardId);				// 게시글 삭제
	
}
