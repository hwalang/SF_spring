package com.mycom.myboard.board.dto;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardDto {

	private int boardId;
	private int userSeq;
	private String userName;
	private String userProfileImageUrl;
	private String title;
	private String content;
	private LocalDateTime regDt;	// LocalDateTime: java-8 이상
	private int readCount;
	private boolean sameUser;
	
	// 첨부파일
	private List<BoardFileDto> fileList;
	
	// regDt setter
	// lombok + mybatis mapping 충돌 방지
	// mybatis는 DateTime만 가능하다.
	public void setRegDt(Date regDt) {
		this.regDt = LocalDateTime.ofInstant(regDt.toInstant(), ZoneId.systemDefault());
	}
}
