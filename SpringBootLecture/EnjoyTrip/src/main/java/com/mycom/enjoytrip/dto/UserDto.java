package com.mycom.enjoytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class UserDto {

	private int userId;
	private String userEmail;
	private String userPwd;
	private String userNm;
	private String userPhone;
	private String userProfile;
	
}
