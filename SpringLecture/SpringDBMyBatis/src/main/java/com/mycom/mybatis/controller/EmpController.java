package com.mycom.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.EmpService;

@Controller
public class EmpController {

	// DI
	private final EmpService service;

	public EmpController(EmpService service) {
		this.service = service;
	}

	// 사원 상세
	@GetMapping(value = "/empDetail/{employeeId}")
	@ResponseBody // json 데이터를 넘겨주기 위함
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		return empDto;
	}

	// 사원 목록
	@GetMapping(value = "/empList")
	@ResponseBody
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}

	// 사원 등록
	@PostMapping(value = "/empInsert")
	@ResponseBody
	public int empInsert(EmpDto empDto) {
		return service.empInsert(empDto);
	}

	// 사원 수정
	@PostMapping(value = "/empUpdate")
	@ResponseBody
	public int empUpdate(EmpDto empDto) {
		return service.empUpdate(empDto);
	}

	// 사원 삭제
	@GetMapping(value = "/empDelete/{employeeId}")
	@ResponseBody
	public int empDelete(@PathVariable int employeeId) {
		return service.empDelete(employeeId);
	}

	// 사원 등록 JSON
	@PostMapping(value = "/empInsertJSON")
	@ResponseBody
	public int empInsertJSON(@RequestBody EmpDto empDto) {
		return service.empInsert(empDto);
	}

	// 사원 상세 jsp 페이지
	@GetMapping(value = "/empDetailJsp/{employeeId}")
	public String empDetailJsp(@PathVariable int employeeId, Model model) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		model.addAttribute("empDto", empDto);
		return "empDetail";
	}

	// 사원 목록 jsp 페이지
	@GetMapping(value = "/empListJsp")
	public ModelAndView empListJsp() {
		List<EmpDto> empList = service.empList();
		ModelAndView mav = new ModelAndView("empList"); // empList.jsp
		mav.addObject("empList", empList);

		return mav;
	}

	// 사원 목록 - like
	@GetMapping(value = "/empListLike")
	@ResponseBody
	public List<EmpDto> empListLike(String searchWord) {
		List<EmpDto> list = service.empListLike(searchWord);
		return list;
	}

	// 사원 목록 - ResultMap
	@GetMapping(value = "/empListResultMap")
	@ResponseBody
	public List<EmpDto> empListResultMap(String searchWord) {
		List<EmpDto> list = service.empListResultMap(searchWord);
		return list;
	}

	// 사원 목록 - param: Map
	@GetMapping(value = "/empListParameterMap")
	@ResponseBody
	public List<EmpDto> empListParameterMap(String firstName, String lastName) {
		Map<String, String> map = new HashMap<>();
		map.put("firstName", firstName);
		map.put("lastName", lastName);
		List<EmpDto> list = service.empListParameterMap(map);
		return list;
	}

	// 사원 목록 - @param
	@GetMapping(value = "/empListParameterMap2")
	@ResponseBody
	public List<EmpDto> empListParameterMap2(String firstName, String lastName) {
		List<EmpDto> list = service.empListParameterMap2(firstName, lastName);
		return list;
	}

	// 사원 목록 - param: Dto
	@GetMapping(value = "/empListParameterMap3")
	@ResponseBody
	public List<EmpDto> empListParameterMap3(EmpDto dto) {
		List<EmpDto> list = service.empListParameterMap3(dto);
		return list;
	}
	
	
	@GetMapping(value = "/empListWhereIf")
	@ResponseBody
	public List<EmpDto> empListWhereIf(String firstName, String lastName, String email) {
		List<EmpDto> list = service.empListWhereIf(firstName, lastName, email);
		return list;
	}

}
