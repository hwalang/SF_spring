package com.mycom.myboard.board.dto;

import java.time.LocalDateTime;

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
public class BoardFileDto {
	
	private int fileId;
	private int boardId;
	private String fileNaem;
	private long fileSize;
	private String fileContentType;
	private String fileUrl;
	private LocalDateTime regDt;
}