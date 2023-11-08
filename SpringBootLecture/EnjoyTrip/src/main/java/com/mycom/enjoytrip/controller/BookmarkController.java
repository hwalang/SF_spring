package com.mycom.enjoytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.enjoytrip.dto.BookmarkDto;
import com.mycom.enjoytrip.service.BookmarkService;

@RestController
public class BookmarkController {
	@Autowired
	BookmarkService service;
	
	// 북마크 등록
	@PostMapping("/bookmarks")
	public int bookmarkInsert(int userId, int contentId) {
		return service.bookmarkInsert(userId, contentId);
	}
	
	// 북마크 삭제
	@DeleteMapping("/bookmarks/{userId}/{contentId}")
	public int bookmarkDelete(@PathVariable("userId") int userId, @PathVariable("contentId") int contentId) {
		return service.bookmarkDelete(userId, contentId);
	}
	
	@GetMapping("/bookmarks/{userId}")
	public List<BookmarkDto> bookmarkList(@PathVariable("userId") int userId) {	// 북마크 목록
		return service.bookmarkList(userId);
	}
}
