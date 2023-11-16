package com.mycom.myboard.board.service;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.mycom.myboard.board.dao.BoardDao;
import com.mycom.myboard.board.dto.BoardDto;
import com.mycom.myboard.board.dto.BoardFileDto;
import com.mycom.myboard.board.dto.BoardParamDto;
import com.mycom.myboard.board.dto.BoardResultDto;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	@Value("${app.fileupload.uploadPath}")
	String uploadPath;
	
	@Value("${app.fileupload.uploadFolder}")
	String uploadFolder;
	
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

	@Override
	@Transactional
	public BoardResultDto boardInsert(BoardDto dto, MultipartHttpServletRequest request) {
		BoardResultDto boardResultDto = new BoardResultDto();
		
		try {
			boardDao.boardInsert(dto);	// AI key 자동 처리: 직접 입력하지 않는다.
			List<MultipartFile> fileList = request.getFiles("file");	// front와 이름을 맞춘다.
			
			File uploadDir = new File(uploadPath + File.separator + uploadFolder);
			if (!uploadDir.exists())
				uploadDir.mkdir();
			
			// 물리적인 파일 저장
			for (MultipartFile part : fileList) {
				int boardId = dto.getBoardId();
				String fileName = part.getOriginalFilename();	// 사용자가 첨부한 실제 파일 이름
				String extension = FilenameUtils.getExtension(fileName);	// .jpg, .png 등
				UUID uuid = UUID.randomUUID();					// DB에 저장할 파일 이름( 원본 파일 이름이 중복될 수 있기 때문 )
				String savingFileName = uuid + "." + extension;
				
				File destFile = new File(uploadPath + File.separator + uploadFolder + File.separator + savingFileName);
				part.transferTo(destFile);
				
				// DB에 파일 정보 저장
				BoardFileDto boardFileDto = new BoardFileDto();
				boardFileDto.setBoardId(boardId);
				boardFileDto.setFileName(fileName);
				boardFileDto.setFileSize(part.getSize());
				boardFileDto.setFileContentType(part.getContentType());
				boardFileDto.setFileUrl(uploadFolder + "/" + savingFileName);
				System.out.println(uploadFolder + "/" + savingFileName);
				
				boardDao.boardFileInsert(boardFileDto);
			}
			
			boardResultDto.setResult(SUCCESS);
			
		} catch (Exception e) {
			e.printStackTrace();
			boardResultDto.setResult(FAIL);
		}
		
		return boardResultDto;
	}

}
