package com.mycom.enjoytrip.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class AttractionDto {
	
	private int contentId;			// main key
	private String overview;		// attraction_description
	
	// attraction_info
	private String title;
	private String addr1;
	private String addr2;
	private String firstImage;
	private int sidoCode;			// sido  key
	private int gugunCode;			// gugun key
	private int latitude;
	private int longitude;
	
	private String sidoName;
	private String gugunName;

}