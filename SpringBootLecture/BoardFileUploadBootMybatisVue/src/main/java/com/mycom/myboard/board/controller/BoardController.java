package com.mycom.myboard.board.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	BoardService service;
	
    @GetMapping(value="/boards")
    public BoardResultDto boardList(BoardParamDto boardParamDto){
        
        BoardResultDto boardResultDto;

        // 검색어 여부로 특정 서비스를 수행
        if( boardParamDto.getSearchWord().isEmpty() ) {
            boardResultDto = service.boardList(boardParamDto);
        }else {
            boardResultDto = service.boardListSearchWord(boardParamDto);
        }
        
        return boardResultDto;
    }

    
    @GetMapping(value="/boards/{boardId}")
    public BoardResultDto boardDetail(@PathVariable int boardId, HttpSession session){

    	// 해당 유저가 게시글을 읽은 전적이 있는지 확인
        BoardParamDto boardParamDto = new BoardParamDto();
        boardParamDto.setUserSeq( ((UserDto) session.getAttribute("userDto")).getUserSeq());
        boardParamDto.setBoardId(boardId);

        BoardResultDto boardResultDto = service.boardDetail(boardParamDto);
        // 게시글 작성자와 현 사용자가 동일
        if( ((UserDto) session.getAttribute("userDto")).getUserSeq() == boardResultDto.getDto().getUserSeq() ) {
            boardResultDto.getDto().setSameUser(true);
        }                
                
        return boardResultDto;     
    }
    
    @PostMapping(value="/boards")
    public BoardResultDto boardInsert(
            BoardDto boardDto, 
            MultipartHttpServletRequest request) {
        
        boardDto.setUserSeq( ((UserDto) request.getSession().getAttribute("userDto")).getUserSeq());
        BoardResultDto boardResultDto = service.boardInsert(boardDto, request);
        
        return boardResultDto;     
    }
    
    // PUT + multipart/form-data (X)
    // In RESTful,
    // PUT & DELETE methods are defined to be idempotent
    
    @PostMapping(value="/boards/{boardId}") 
    public BoardResultDto boardUpdate(
            BoardDto boardDto, 
            MultipartHttpServletRequest request){
        boardDto.setUserSeq( ((UserDto) request.getSession().getAttribute("userDto")).getUserSeq());
        BoardResultDto boardResultDto = service.boardUpdate(boardDto, request);

        return boardResultDto;        
    }
    
    @DeleteMapping(value="/boards/{boardId}") 
    public BoardResultDto boardDelete(@PathVariable(value="boardId") int boardId){
        BoardResultDto boardResultDto = service.boardDelete(boardId);
        
        return boardResultDto;         
    }
}
