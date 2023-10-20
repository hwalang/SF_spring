package com.mycom.myapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import com.mycom.myapp.dto.CarDto;

@Controller
public class ParamController {

	// 1. 직접 request 객체를 사용
	
	@GetMapping("/param1")		// http://localhost:8080/myapp/param1?seq=안녕
	public void m1(HttpServletRequest request) { 
		String seq = request.getParameter("seq");
		System.out.println(seq);
	}
	
	@PostMapping("/param1")
	public void m2(HttpServletRequest request) { 
		String seq = request.getParameter("seq");
		System.out.println(seq);
	}
	
	
	// 2. method의 param과 request의 param의 name이 같아야 한다.
	
	@GetMapping("/param2")		
	public void m3(String seq) { 
		System.out.println(seq);
	}
	@GetMapping("/param2_2")		
	public void m4(String seq, String msg) { 
		System.out.println(seq);
		System.out.println(msg);
	}
	
	
	
	
	// 3. annotation param
	
	@PostMapping("/login")
	public void login(String userEmail, String userPassword) {	// Ref Type: 같은 param name 값이 넘어오지 않으면 null로 초기화
		System.out.println(userEmail);
		System.out.println(userPassword);
	}
	@GetMapping("/param2_3")		
	public void m4(String seq, Integer num) {	// primitive Type: 0이 아니라 런타임 에러가 발생한다.
												// primitive Type -> Wrapper Object: RefType으로 바꿔서 null
		System.out.println(seq);
		System.out.println(num);
	}
	
	@GetMapping("/param3")
	public void m4(@RequestParam(name="seq") String seq) {	// 반드시 요구되는 param 값으로 설정한다.
															// 따라서 "seq" 값이 넘어오지 않으면 런타임 에러가 발생한다.
															// @RequestParam(name="seq", required=false) -> 값이 넘어오지 않으면 null로 초기화 된다.
		System.out.println(seq);
	}
	@GetMapping("/param3_2")
	public void m5(@RequestParam(name="seq", required=false) String newSeq) {	// param 값과 변수 값의 이름을 다르게 사용할 수 있다.
		System.out.println(newSeq);
	}
	
	// 4. Dto 객체
	
	@GetMapping("/car1")
	public void car1(String name, int price) {
		CarDto dto = new CarDto();
		dto.setName(name);
		dto.setPrice(price);
		System.out.println(dto);
	}
	
	@GetMapping("/car2")
	public void car2(@ModelAttribute CarDto dto) {	// primitive type( int )의 값이 넘어오지 않으면 0으로 초기화
									// http://localhost:8080/myapp/car2?name=소나타&price=100
										// property로 setName/getName를 인식하기 때문에, name 값을 name2에 저장할 수 있다.
										// setName2()라면 name=소나타: 로 값을 받을 수 없다.
		System.out.println(dto);
	}
	
	// 5. map
	
	@GetMapping("/map")
	public void map(@RequestParam Map<String, String> params) {
		System.out.println(params.get("name"));
		System.out.println(params.get("price"));
		System.out.println(params.get("owner"));
		// System.out.println(params.get("nickNames"));
	}
	
	
	// 6. header 정보 가져오기
	// f12 -> network -> Headers -> RequestHeader
	@GetMapping("/header")
	public void m7(
			@RequestHeader("Accept") String accept, 
			@RequestHeader("Host") String host) {
		System.out.println(accept);
		System.out.println(host);
	}
	
	// 7. session
	@GetMapping("/logout")
	public void logout(HttpSession session) {
		System.out.println("/logout");
		session.invalidate();
	}
	
	@GetMapping("/login")
	public String login(String msg, HttpSession session) {
		System.out.println("/login");
		session.setAttribute("msg", msg); 	// session에 "msg"라는 이름으로 저장
		return "loginResult";
	}
}
