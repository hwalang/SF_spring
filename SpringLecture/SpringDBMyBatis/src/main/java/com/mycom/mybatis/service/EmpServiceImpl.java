package com.mycom.mybatis.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.mycom.mybatis.dao.EmpDao;
import com.mycom.mybatis.dto.EmpDto;

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

	@Override
	public List<EmpDto> empListLike(String searchWord) {
		return dao.empListLike(searchWord);
	}

	@Override
	public List<EmpDto> empListResultMap(String searchWord) {
		return dao.empListResultMap(searchWord);
	}

	@Override
	public List<EmpDto> empListParameterMap(Map<String, String> map) {
		return dao.empListParameterMap(map);
	}

	@Override
	public List<EmpDto> empListParameterMap2(String firstName, String lastName) {
		return dao.empListParameterMap2(firstName, lastName);
	}

	@Override
	public List<EmpDto> empListParameterMap3(EmpDto dto) {
		return dao.empListParameterMap3(dto);
	}

	@Override
	public List<EmpDto> empListWhereIf(String firstName, String lastName, String email) {
		return dao.empListWhereIf(firstName, lastName, email);
	}

}
