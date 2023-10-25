package com.mycom.enjoytrip;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.enjoytrip.user.dto.UserDto;
import com.mycom.enjoytrip.user.service.UserService;


// 페이지 이동 Controller
@Controller
public class HomeController {
	
	private final UserService userService;
	public HomeController(UserService userService) {
		this.userService = userService;
	}
	
    
	// 메인 페이지로 이동
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model) {
        
        return "home";
    }
    
    // 마이페이지로 이동
    @GetMapping("/detail")
	public String detailPage() {
		return "mypage";
	}
    
}