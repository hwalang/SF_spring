package com.mycom.mydb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.mydb.dao.StudentDao;
import com.mycom.mydb.dto.StudentDto;

@Service
public class StudentServiceImpl implements StudentService {
	
	private final StudentDao studentDao;
	public StudentServiceImpl(StudentDao studentDao) {
		this.studentDao = studentDao;
	}


    @Override
    public StudentDto studentDetail(int studentId) {
        return studentDao.studentDetail(studentId);
    }

    @Override
    public List<StudentDto> studentList() {
        return studentDao.studentList();
    }

	@Override
	public int studentInsert(StudentDto dto) {
		return studentDao.studentInsert(dto);
	}

	@Override
	public int studentDelete(int studentId) {
		return studentDao.studentDelete(studentId);
	}
	
    @Override
    public int studentUpdate(StudentDto dto) {
        return studentDao.studentUpdate(dto);
    }


}
