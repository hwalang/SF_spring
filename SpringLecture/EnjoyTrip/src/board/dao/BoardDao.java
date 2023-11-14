package board.dao;

import java.util.List;

import board.dto.BoardDto;

public interface BoardDao {
     int boardInsert(BoardDto dto);
     int boardUpdate(BoardDto dto);
     int boardDelete(int boardId);
    
     BoardDto boardDetail(int boardId);
    
     List<BoardDto> boardList(int limit, int offset);
     int boardListTotalCnt(); // pagenation 총 건 수 없을 때 검사하는거
    
     List<BoardDto> boardListSearchWord(int limit, int offset, String searchWord);
     int boardListSearchWordTotalCnt(String searchWord);
}
