package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.StudentDto;

public interface StudentService {

	StudentDto studentDetail(int studentId);		// 학생 상세
	List<StudentDto> studentList();					// 학생 목록
	int studentInsert(StudentDto dto);				// 학생 등록
	int studentUpdate(StudentDto dto);				// 학생 수정
	int studentDelete(int studentId);				// 학생 삭제
	
}
