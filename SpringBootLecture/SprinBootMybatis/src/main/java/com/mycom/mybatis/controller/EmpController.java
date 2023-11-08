package com.mycom.mybatis.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.mybatis.dto.EmpDto;
import com.mycom.mybatis.service.EmpService;

@RestController
@RequestMapping("axios")
@CrossOrigin(origins="*", allowedHeaders="*")
public class EmpController {

//	@Autowired
//	EmpService service;
	
	private final EmpService service;

	public EmpController(EmpService service) {
		this.service = service;
	}
	
	// 사원 관리 (empMain.jsp)
	@GetMapping(value = "/empMain")
	public String empMain() {
		return "empMain";
	}
	
	
	// 사원 상세
	@GetMapping(value = "/emps/{employeeId}")
	public EmpDto empDetail(@PathVariable int employeeId) {
		System.out.println(employeeId);
		EmpDto empDto = service.empDetail(employeeId);
		return empDto;
	}

	// 사원 목록
	@GetMapping(value = "/emps")
	public List<EmpDto> empList() {
		List<EmpDto> list = service.empList();
		return list;
	}
	
	// 사원 등록
	@PostMapping(value = "/emps")
	public Map<String, String> empInsert(@RequestBody EmpDto empDto) {
		int ret = service.empInsert(empDto);
		Map<String, String> map = new HashMap<>();
		if (ret == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}
	
	// 사원 수정
	@PutMapping(value = "/emps/{employeeId}")
	public Map<String, String> empUpdate(@PathVariable int employeeId, @RequestBody EmpDto empDto) {
		int ret = service.empUpdate(empDto);
		Map<String, String> map = new HashMap<>();
		if (ret == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}
	
	// 사원 삭제
	@DeleteMapping(value = "/emps/{employeeId}")
	public Map<String, String> empDelete(@PathVariable int employeeId) {
		int ret = service.empDelete(employeeId);
		Map<String, String> map = new HashMap<>();
		if (ret == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}

	// 사원 등록 JSON
	@PostMapping(value = "/empInsertJSON")
	public Map<String, String> empInsertJSON(@RequestBody EmpDto empDto) {
		int ret = service.empInsert(empDto);
		Map<String, String> map = new HashMap<>();
		if (ret == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		return map;
	}
			
}
