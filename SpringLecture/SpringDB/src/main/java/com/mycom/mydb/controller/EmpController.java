package com.mycom.mydb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mycom.mydb.dto.EmpDto;
import com.mycom.mydb.service.EmpService;

@Controller
public class EmpController {

	// DI
	private final EmpService service;
	public EmpController(EmpService service) {
		this.service = service;
	}
	
	// 사원 상세
	@GetMapping(value="/empDetail/{employeeId}")
	@ResponseBody									// json 데이터를 넘겨주기 위함
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		return empDto;
	}
	
	// 사원 목록
	@GetMapping(value="/empList")
	@ResponseBody									
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}
	
	// 사원 등록
	@PostMapping(value="/empInsert")
	@ResponseBody									
	public int empInsert(EmpDto empDto) {
		return service.empInsert(empDto);
	}
	
	// 사원 수정
	@PostMapping(value="/empUpdate")
	@ResponseBody									
	public int empUpdate(EmpDto empDto) {
		return service.empUpdate(empDto);
	}

	// 사원 삭제
	@GetMapping(value="/empDelete/{employeeId}")
	@ResponseBody									
	public int empDelete(@PathVariable int employeeId) {
		return service.empDelete(employeeId);
	}
}
