package com.ssafy.member.controller;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.member.model.MemberDto;
import com.ssafy.member.model.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {
	
	private final Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	private final MemberService memberService;

	public MemberController(MemberService memberService) {
		super();
		this.memberService = memberService;
	}
	
	@GetMapping("join")
	public String join() {
		return "user/join";
	}
	@PostMapping("join")
	public String join(MemberDto memberDto) throws Exception {
		// form tag의 name과 Dto의 멤버 변수의 이름이 같아야 한다.
		logger.debug("join memberDto: {}", memberDto);
		memberService.joinMember(memberDto);
		return "redirect:/user/login";	// login 페이지로 이동할 때는 forward가 아니라 redirect 이다.
	}
	
	@GetMapping("login")
	public String login() {
		return "user/login";
	}
	// form tag에서 name을 userid로 받아와서 userId에 저장
	@PostMapping("login")
	public String login(@RequestParam("userid") String userId, 
			@RequestParam("userpwd") String userPwd,
			HttpSession session) 
					throws Exception {
		MemberDto memberDto = memberService.loginMember(userId, userPwd);
		// session에 유저 정보 저장
		if (memberDto != null) {
			session.setAttribute("userinfo", memberDto);
			return "redirect:/";	// 메인 화면으로 이동
		}
		System.out.println("실패");
		return "user/login";
	}
}
