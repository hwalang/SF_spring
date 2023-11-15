package com.mycom.myboard.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.myboard.board.dao.BoardDao;
import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	private static final int SUCCESS = 1;
	private static final int FAIL = -1;

	@Override
	public BoardResultDto boardList(BoardParamDto dto) {
		BoardResultDto boardResultDto = new BoardResultDto();
		try {
			List<BoardDto> list = boardDao.boardList(dto);
			boardResultDto.setList(list);
			boardResultDto.setResult(SUCCESS);
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

}
