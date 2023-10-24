package com.mycom.mydb;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

// 페이지 이동 처리
@Controller
public class HomeController {

	// 페이지 이동만 페이지 요청을 한다.
	// 데이터는 비동기로 처리한다.

	// 메인 페이지로 이동
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {

		return "home";
	}

	// 사원 관리 페이지로 이동
	@GetMapping(value = "/empMain")
	public String empMain() {

		return "empMain";
	}

	// 학생 관리 페이지로 이동
	@GetMapping(value = "/studentMain")
	public String studentMain() {

		return "studentMain";
	}

}
