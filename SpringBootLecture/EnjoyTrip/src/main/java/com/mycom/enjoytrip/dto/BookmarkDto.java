package com.mycom.enjoytrip.dto;

public class BookmarkDto {
	private int bookmarkId;
	private int userId;
	private int contentId;
	
	public BookmarkDto() {};
	public BookmarkDto(int bookmarkId, int userId, int contentId) {
		super();
		this.bookmarkId = bookmarkId;
		this.userId = userId;
		this.contentId = contentId;
	}
	
	public int getBookmarkId() {
		return bookmarkId;
	}
	public void setBookmarkId(int bookmarkId) {
		this.bookmarkId = bookmarkId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public int getContentId() {
		return contentId;
	}
	public void setContentId(int contentId) {
		this.contentId = contentId;
	}
	
	@Override
	public String toString() {
		return "BookmarkDto [bookmarkId=" + bookmarkId + ", userId=" + userId + ", contentId=" + contentId + "]";
	}
	
	
}
