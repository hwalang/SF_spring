package com.mycom.more.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycom.more.dao.StudentDao;
import com.mycom.more.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	StudentDao studentDao;
	
	@Override
	public List<StudentDto> list() {
		return studentDao.list();
	}

	@Override
	public StudentDto detail(int studentId) {
		return studentDao.detail(studentId);
	}

	@Override
	@Transactional
	public int insert(StudentDto dto) {
		return studentDao.insert(dto);
	}

	@Override
	public int update(StudentDto dto) {
		return studentDao.update(dto);
	}

	@Override
	public int delete(int studentId) {
		return studentDao.delete(studentId);
	}

}
