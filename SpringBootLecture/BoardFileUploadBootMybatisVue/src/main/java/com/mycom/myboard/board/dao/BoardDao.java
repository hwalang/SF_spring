package com.mycom.myboard.board.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardFileDto;
import com.mycom.myboard.board.dto.BoardParamDto;

@Mapper
public interface BoardDao {
	// 게시글 하나 + 해당 게시글에 저장된 파일들
    BoardDto boardDetail(BoardParamDto boardParamDto);
    List<BoardFileDto> boardDetailFileList(int boardId);
   
    // map - Dto
    // 해당 유저가 게시글을 처음 보는가? -> 처음보면 조회수가 증가, 아니면 유지 
    int boardUserReadCount(BoardParamDto boardParamDto); 
   
    // map - @param
    // 해당 유저가 해당 게시글을 봤다는 표시를 남김
    int boardUserReadInsert(
           @Param("boardId") int boardId, 
           @Param("userSeq") int userSeq ); 
   
    // 처음보면 조회수가 증가
    int boardReadCountUpdate(int boardId);
   
   
    // 게시글이 삭제되면 파일 및 조회수도 삭제된다.
    int boardDelete(int boardId);    
    int boardFileDelete(int boardId);
    List<String> boardFileUrlDeleteList(int boardId);
    int boardReadCountDelete(int boardId);
   
    // 게시글 작성
    int boardInsert(BoardDto dto);
    int boardFileInsert(BoardFileDto dto);
   
    // 게시글 목록
    List<BoardDto> boardList(BoardParamDto boardParamDto);
    int boardListTotalCount();
   
    // 검색
    List<BoardDto> boardListSearchWord(BoardParamDto boardParamDto);
    int boardListSearchWordTotalCount(BoardParamDto boardParamDto);
   
    // 게시글 수정
    // 실제로는 delete, insert가 수행된다.
    int boardUpdate(BoardDto dto);
}
