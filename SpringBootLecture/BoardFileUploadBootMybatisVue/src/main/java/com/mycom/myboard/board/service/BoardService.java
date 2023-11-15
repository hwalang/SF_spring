package com.mycom.myboard.board.service;

import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;

public interface BoardService {
	BoardResultDto boardList(BoardParamDto dto);
}
