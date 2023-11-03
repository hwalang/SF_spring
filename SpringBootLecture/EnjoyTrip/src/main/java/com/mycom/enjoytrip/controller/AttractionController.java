package com.mycom.enjoytrip.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.enjoytrip.dto.AttractionDto;
import com.mycom.enjoytrip.service.AttractionService;

@RestController
public class AttractionController {

	@Autowired
	AttractionService service;

	// 시도 정보 ( sido table ) - ajax
	@GetMapping("/attractions")
	public List<AttractionDto> sidoList() {
		List<AttractionDto> list = service.sidoList();

//		for (int i = 0; i < list.size(); ++i) {
//			System.out.println(list.get(i).getSidoCode());
//			System.out.println(list.get(i).getSidoName());
//		}
		
		return list;
	}

	// 구군 정보 ( gugun table ) - ajax
	@GetMapping("/attractions/gugunList/{sidoCode}")
	public List<AttractionDto> gugunList(@PathVariable int sidoCode) {
		List<AttractionDto> list = service.gugunList(sidoCode);
		return list;
	}

	// 검색한 관광지에 필요한 정보 ( attraction_info table )
	// 핀에 대한 위도, 경도 + 각 관광지마다 간략히 보여줄 정보
	@GetMapping("/attractions/{sidoCode}/{gugunCode}")
	public List<AttractionDto> pinList(@PathVariable("sidoCode") int sidoCode, @PathVariable("gugunCode") int gugunCode) {
		List<AttractionDto> list = service.pinList(sidoCode, gugunCode);
		return list;
	}

	// 관광지 상세 정보 ( attraction_description and attraction_info table )
	@GetMapping("/attractions/{contentId}")
	public AttractionDto detail(@PathVariable int contentId) {
		AttractionDto dto = service.detail(contentId);
		return dto;
	}

}
