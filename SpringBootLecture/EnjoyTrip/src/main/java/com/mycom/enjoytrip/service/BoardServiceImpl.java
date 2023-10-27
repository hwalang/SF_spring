package com.mycom.enjoytrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.enjoytrip.dao.BoardDao;
import com.mycom.enjoytrip.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;

	@Override
	public List<BoardDto> boardList() {
		return boardDao.boardList();
	}

	@Override
	public BoardDto boardDetail(int boardId) {
		BoardDto dto = boardDao.boardDetail(boardId);
		return dto;
	}

	@Override
	public int boardWrite(BoardDto dto) {
		return 0;
	}

	@Override
	public int boardDelete(int boardId) {
		// TODO Auto-generated method stub
		return 0;
	}

}
