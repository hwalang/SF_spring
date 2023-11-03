package com.mycom.more.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mycom.more.dto.StudentDto;
import com.mycom.more.service.StudentService;

@RestController
// @CrossOrigin(origins="*", allowedHeaders="*")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@GetMapping("/students")
	public List<StudentDto> list() {
		List<StudentDto> list = studentService.list();
		return list;
	}
	
	@GetMapping("/students/{studentId}")
	public StudentDto detail(@PathVariable int studentId) {
		StudentDto dto = studentService.detail(studentId);
		return dto;
	}
	
	@PostMapping("/students")
	public int insert(StudentDto dto) {
		return studentService.insert(dto);
	}
	
	@PutMapping("/students/{studentId}")
	public int update(@PathVariable int studentId, StudentDto dto) {
		// studentId는 선택적으로 사용
		
		return studentService.update(dto);
	}
	
	@DeleteMapping("/students/{studentId}")
	public int delete(@PathVariable int studentId) {
		return studentService.delete(studentId);
	}
}
