package com.ssafy.hello.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/basic/")
public class HelloController {

	// hello/basic/hello1 은 어떻게?
	
//	@RequestMapping("/hello1")
//	public String hello1() {
//		return "result/view";  // views/result/view.jsp
//	}
	
	// 4가지 방식
	
//	@GetMapping("/hello1")
//	public String hello1(HttpServletRequest request) {
//		request.setAttribute("msg", "spring!!!");
//		return "result/view";  // views/result/view.jsp
//	}
	
//	@GetMapping("/hello1")
//	public String hello1(Model model) {
//		model.addAttribute("msg", "spring!!!");
//		return "result/view";  // views/result/view.jsp
//	}
	
	@GetMapping("/hello1")
	public String hello1(Map model) {
		model.put("msg", "map spring!!!");
		return "result/view";  // views/result/view.jsp
	}
	
	@GetMapping("/hello2")
	public ModelAndView hello2() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "MAV !!");
		mav.setViewName("result/view");
		return mav;
	}
}
