package com.mycom.enjoytrip.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.enjoytrip.dto.BookmarkDto;

@Mapper
public interface BookmarkDao {
	
	int bookmarkInsert(@Param("userId") int userId, @Param("contentId") int contentId);		// 북마크 추가
	int bookmarkDelete(@Param("userId") int userId, @Param("contentId") int contentId);		// 북마크 제거
	List<BookmarkDto> bookmarkList(int userId);	// 북마크 목록
}
