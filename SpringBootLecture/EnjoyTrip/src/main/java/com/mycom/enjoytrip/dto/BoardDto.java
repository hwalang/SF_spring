package com.mycom.enjoytrip.dto;

import java.time.LocalDateTime;

public class BoardDto {
	
	private int boardId;
	private String boardTitle;
	private String boardContent;
	private LocalDateTime boardRegDate;
	private int boardLike;
	private int boardViewCnt;
	private int userId;
	private String userEmail;
	private String userNm;
	private String userProfile;
	
	public BoardDto() {}
	public BoardDto(int boardId, String boardTitle, String boardContent, LocalDateTime boardRegDate, int boardLike,
			int boardViewCnt, int userId, String userEmail, String userNm, String userProfile) {
		super();
		this.boardId = boardId;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.boardRegDate = boardRegDate;
		this.boardLike = boardLike;
		this.boardViewCnt = boardViewCnt;
		this.userId = userId;
		this.userEmail = userEmail;
		this.userNm = userNm;
		this.userProfile = userProfile;
	}
	
	public int getBoardId() {
		return boardId;
	}
	public void setBoardId(int boardId) {
		this.boardId = boardId;
	}
	public String getBoardTitle() {
		return boardTitle;
	}
	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}
	public String getBoardContent() {
		return boardContent;
	}
	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}
	public LocalDateTime getBoardRegDate() {
		return boardRegDate;
	}
	public void setBoardRegDate(LocalDateTime boardRegDate) {
		this.boardRegDate = boardRegDate;
	}
	public int getBoardLike() {
		return boardLike;
	}
	public void setBoardLike(int boardLike) {
		this.boardLike = boardLike;
	}
	public int getBoardViewCnt() {
		return boardViewCnt;
	}
	public void setBoardViewCnt(int boardViewCnt) {
		this.boardViewCnt = boardViewCnt;
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
	public String getUserNm() {
		return userNm;
	}
	public void setUserNm(String userNm) {
		this.userNm = userNm;
	}
	public String getUserProfile() {
		return userProfile;
	}
	public void setUserProfile(String userProfile) {
		this.userProfile = userProfile;
	}
	
	@Override
	public String toString() {
		return "BoardDto [boardId=" + boardId + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", boardRegDate=" + boardRegDate + ", boardLike=" + boardLike + ", boardViewCnt=" + boardViewCnt
				+ ", userId=" + userId + ", userEmail=" + userEmail + ", userNm=" + userNm + ", userProfile="
				+ userProfile + "]";
	}
	

}
