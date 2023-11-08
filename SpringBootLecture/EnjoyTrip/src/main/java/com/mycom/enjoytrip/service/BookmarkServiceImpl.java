package com.mycom.enjoytrip.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mycom.enjoytrip.dao.BookmarkDao;
import com.mycom.enjoytrip.dto.BookmarkDto;

@Service
public class BookmarkServiceImpl implements BookmarkService {

	@Autowired
	BookmarkDao dao;
	
	@Override
	public int bookmarkInsert(int userId, int contentId) {
		return dao.bookmarkInsert(userId, contentId);
	}

	@Override
	public int bookmarkDelete(int userId, int contentId) {
		return dao.bookmarkDelete(userId, contentId);
	}

	@Override
	public List<BookmarkDto> bookmarkList(int userId) {
		return dao.bookmarkList(userId);
	}

}
