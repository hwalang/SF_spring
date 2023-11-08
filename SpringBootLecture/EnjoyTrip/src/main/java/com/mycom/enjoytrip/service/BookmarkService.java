package com.mycom.enjoytrip.service;

import java.util.List;

import com.mycom.enjoytrip.dto.BookmarkDto;

public interface BookmarkService {
	int bookmarkInsert(int userId, int contentId);		// 북마크 추가
	int bookmarkDelete(int userId, int contentId);		// 북마크 제거
	List<BookmarkDto> bookmarkList(int userId);	// 북마크 목록
}
