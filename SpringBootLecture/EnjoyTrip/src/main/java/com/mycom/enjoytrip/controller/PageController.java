package com.mycom.enjoytrip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

// 페이지 이동, 비동기 통신 controller를 각각 만들어야 한다.
// @Controller는 페이지 이동
// @RestController는 비동기 통신
@Controller
public class PageController {

	// 메인 화면
	@RequestMapping("/")
	public String index() {
		return "/index.html";
	}
	
	// 로그인, 회원가입, 마이( 내정보, 수정, 탈퇴, 북마크 )
	@RequestMapping("/regist")
	public String regist() {
		return "/regist.html";
	}
	@RequestMapping("/login")
	public String login() {
		return "/login.html";
	}
	@RequestMapping("/mypage")
	public String mypage() {
		return "/mypage.html";
	}
	
	
	// 게시판 목록, 글 작성( + 수정 ), 글 상세
	@RequestMapping("/boardMain")
	public String boardMain() {
		return "/board/boardMain.html";
	}
	@RequestMapping("/boardWrite")
	public String boardWrite() {
		return "/board/boardWrite.html";
	}
	@RequestMapping("/boardDetail")
	public String boardDetail() {
		return "/board/boardDetail.html";
	}
	
	// 지도 페이지
	@RequestMapping("/map")
	public String map() {
		return "/map/map.html";
	}

	
}
