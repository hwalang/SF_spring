package com.mycom.enjoytrip.service;

import java.util.List;

import com.mycom.enjoytrip.dto.AttractionDto;

public interface AttractionService {

	// 시도 정보 ( sido table )
	List<AttractionDto> sidoList();

	// 구군 정보 ( gugun table )
	List<AttractionDto> gugunList(int sidoCode);

	// 검색한 관광지에 필요한 정보 ( attraction_info table )
	// 핀에 대한 위도, 경도 + 각 관광지마다 간략히 보여줄 정보
	List<AttractionDto> pinList(int sidoCode, int gugunCode);

	// 관광지 상세 정보 ( attraction_description and attraction_info table )
	AttractionDto detail(int contentId);
}
