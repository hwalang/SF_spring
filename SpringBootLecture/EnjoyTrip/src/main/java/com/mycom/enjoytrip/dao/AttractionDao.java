package com.mycom.enjoytrip.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.enjoytrip.dto.AttractionDto;

@Mapper
public interface AttractionDao {
	
	// 시도 정보 ( sido table )
	List<AttractionDto> sidoList(); 
	
	// 구군 정보 ( gugun table )
	List<AttractionDto> gugunList(int sidoCode); 
	
	// 검색한 관광지에 필요한 정보 ( attraction_info table )
	// 핀에 대한 위도, 경도 + 각 관광지마다 간략히 보여줄 정보
	// @Param() 으로 두 개의 인자를 구분해야 한다.
	List<AttractionDto> pinList(@Param("sidoCode") int sidoCode, @Param("gugunCode") int gugunCode);
	
	// 관광지 상세 정보 ( attraction_description and attraction_info table )
	AttractionDto detail(int contentId);

}
