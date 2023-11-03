package com.mycom.enjoytrip.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

// 페이지 이동, 비동기 통신 controller를 각각 만들어야 한다.
// @Controller는 페이지 이동
// @RestController는 비동기 통신
@Controller
public class PageController {

	// 메인 화면
	@GetMapping("/")
	public String index() {
		return "/index.html";
	}
	
	// 로그인, 회원가입, 마이( 내정보, 수정, 탈퇴, 북마크 )
	@GetMapping("/goRegist")
	public String regist() {
		return "/regist.html";
	}
	@GetMapping("/goLogin")
	public String login() {
		
		return "/login.html";
	}
	@GetMapping("/goLogout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "/index.html";
	}
	
	
	@GetMapping("/goMypage")
	public String mypage() {
		return "/mypage.html";
	}
	
	
	// 게시판 목록, 글 작성( + 수정 ), 글 상세
	@GetMapping("/goBoardMain")
	public String boardMain() {
		return "/board/boardMain.html";
	}
	@GetMapping("/goBoardWrite")
	public String boardWrite() {
		return "/board/boardWrite.html";
	}
	@GetMapping("/goBoardDetail")
	public String boardDetail() {
		return "/board/boardDetail.html";
	}
	
	// 지도 페이지
	@GetMapping("/goMap")
	public String map() {
		return "/map/map.html";
	}

	
}
