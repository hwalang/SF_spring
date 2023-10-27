package com.mycom.basic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller		
//@RestController // Controller + ResponseBody
public class HomeController {
	
	@RequestMapping("/")
	public String home() {
		return "home.html";
	}
	
	
}
