package com.mycom.myapp;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.myapp.dto.EmpDto;

@Controller
public class ViewController {
	
	@GetMapping("/viewTest1")
	public String ViewTest1() {
		return "viewTest1";		// prefix + viewTest1 + surfix
	}
	
	@GetMapping("/viewTest2")
	public String ViewTest2() {
		return "sub/viewTest2";		// prefix + sub/viewTest2 + surfix
	}
	
	@GetMapping("/viewTest3")
	public String ViewTest3(Model model) {
		
		model.addAttribute("seq", "12345");
		model.addAttribute("empDto", new EmpDto(2, "dh2", "k", "kdh2@n.com", "2023-02-02"));
		
		return "viewTest3";
	}
	
	@GetMapping("/viewTest4")
	public ModelAndView ViewTest4() {
		// data와 view를 한 번에 처리
		ModelAndView mav = new ModelAndView();
	
		// data model
		mav.addObject("seq", "123");
		mav.addObject("empDto", new EmpDto(3, "dh3", "k", "kdh3@n.com", "2023-03-03"));
		// view(jsp) 이름
		mav.setViewName("viewTest4");	
		
		return mav;
	}
	
	// redirect
	
	@GetMapping("/redirect")
	public String redirect() {
		
		System.out.println("/redirect");
		
		// viewTest1.jsp로 가기 위해서 ViewTest1()로 이동
		return "redirect:/viewTest1";
	}
}
