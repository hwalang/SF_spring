package com.mycom.mydb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.mydb.dao.EmpDao;
import com.mycom.mydb.dto.EmpDto;

@Service
public class EmpServiceImpl implements EmpService {

	// DI
	private final EmpDao dao;
	public EmpServiceImpl(EmpDao dao) {
		this.dao = dao;
	}

	@Override
	public EmpDto empDetail(int employeeId) {
		return dao.empDetail(employeeId);
	}

	@Override
	public List<EmpDto> empList() {
		return dao.empList();
	}

	@Override
	public int empInsert(EmpDto dto) {
		return dao.empInsert(dto);
	}

	@Override
	public int empUpdate(EmpDto dto) {
		return dao.empUpdate(dto);
	}

	@Override
	public int empDelete(int employeeId) {
		return dao.empDelete(employeeId);
	}

}
