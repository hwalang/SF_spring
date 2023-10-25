package com.mycom.mybatis.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.mycom.mybatis.dto.StudentDto;
import com.mycom.mybatis.service.StudentService;

@Controller
public class StudentController {
	
	private final StudentService service;
	public StudentController(StudentService service) {
		this.service = service;
	}
	

    // 학생 상세
    @GetMapping(value="/studentDetail/{studentId}")
    @ResponseBody
    public StudentDto studentDetail(@PathVariable int studentId) {
        StudentDto dto = service.studentDetail(studentId);
        return dto;
    }
    
    // 학생 목록
    @GetMapping(value="/studentList")
    @ResponseBody
    public List<StudentDto> studentList(){
        List<StudentDto> list = service.studentList();
        return list;
    }

	// 학생 등록
	@PostMapping("/studentInsert")
	@ResponseBody
	public int studentInsert(StudentDto dto) {
		return service.studentInsert(dto);
	}
	
	// 학생 삭제
	@GetMapping("/studentDelete/{studentId}")
	@ResponseBody
	public int studentDelete(@PathVariable int studentId) {
		return service.studentDelete(studentId);
	}
	

	// 학생 수정
    @PostMapping(value="/studentUpdate")
    @ResponseBody
    public int studentUpdate(StudentDto studentDto) {
        return service.studentUpdate(studentDto);
    }
    
    @GetMapping(value="/studentDetailJsp/{studentId}")
    public String studentDetailJsp(@PathVariable int studentId, Model model) {
        StudentDto studentDto = service.studentDetail(studentId);
        model.addAttribute("studentDto", studentDto);
        return "studentDetail";
    }

    // 학생 목록 jsp 페이지
    @GetMapping(value = "/studentListJsp")
    public ModelAndView studentListJsp() {
        List<StudentDto> studentList = service.studentList();
        ModelAndView mav = new ModelAndView("studentList");
        mav.addObject("studentList", studentList);
        return mav;
    }
	
	
}
