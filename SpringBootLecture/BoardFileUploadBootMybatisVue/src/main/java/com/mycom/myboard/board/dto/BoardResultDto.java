package com.mycom.myboard.board.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// 등록 수정 삭제 -> result 값만 확인
// 상세 -> dto 확인
// 목록 -> list 확인
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class BoardResultDto {
	private int result;
	private BoardDto dto;			// 상세 1건
	private List<BoardDto> list;	// 목록 여러 건
	private int count;				// 총 건수
}
