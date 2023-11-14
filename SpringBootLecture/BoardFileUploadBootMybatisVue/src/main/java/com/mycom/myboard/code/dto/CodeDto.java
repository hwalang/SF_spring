package com.mycom.myboard.code.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// 공통 코드 처리
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class CodeDto {
	private String code;
	private String codeName;
}
