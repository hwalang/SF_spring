package com.mycom.enjoytrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.enjoytrip.dao.BoardDao;
import com.mycom.enjoytrip.dto.BoardDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao dao;

	@Override
	public List<BoardDto> boardList() {
		return dao.boardList();
	}

	@Override
	public BoardDto boardDetail(int boardId) {
		return dao.boardDetail(boardId);
	}

	@Override
	public int boardWrite(BoardDto dto) {
		return dao.boardWrite(dto);
	}

	@Override
	public int boardEdit(BoardDto dto) {
		return dao.boardEdit(dto);
	}

	@Override
	public int boardDelete(int boardId) {
		return dao.boardDelete(boardId);
	}


}
