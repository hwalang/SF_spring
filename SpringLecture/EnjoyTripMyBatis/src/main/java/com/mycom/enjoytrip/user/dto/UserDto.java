package com.mycom.enjoytrip.user.dto;

public class UserDto {
	
	private int userId;
    private String userEmail;    	// 회원가입
    private String userPwd;       	// 회원가입
    private String userNm;        	// 회원가입
    private String userPhone;
    private String userProfile;
    
    public UserDto() {}
	public UserDto(int userId, String userEmail, String userPwd, String userNm, String userPhone, String userProfile) {
		super();
		this.userId = userId;
		this.userEmail = userEmail;
		this.userPwd = userPwd;
		this.userNm = userNm;
		this.userPhone = userPhone;
		this.userProfile = userProfile;
	}
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	
	@Override
	public String toString() {
		return "UserDto [userId=" + userId + ", userEmail=" + userEmail + ", userPwd=" + userPwd + ", userNm=" + userNm
				+ ", userPhone=" + userPhone + ", userProfile=" + userProfile + "]";
	}
    
}
