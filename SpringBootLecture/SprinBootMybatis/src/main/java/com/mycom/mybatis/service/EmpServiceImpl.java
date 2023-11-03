package com.mycom.mybatis.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mycom.mybatis.dao.EmpDao;
import com.mycom.mybatis.dto.EmpDto;

@Service
public class EmpServiceImpl implements EmpService {
    // #1
//    @Autowired
//    EmpDao empDao;
    
    // #2
    private final EmpDao empDao;
    
    public EmpServiceImpl(EmpDao empDao) {
        super();
        this.empDao = empDao;
    }

    @Override
    public EmpDto empDetail(int employeeId) {
        return empDao.empDetail(employeeId);
    }
    
    @Override
    public List<EmpDto> empList() {
        return empDao.empList();
    }
    
    @Override
    public int empInsert(EmpDto empDto) {
        return empDao.empInsert(empDto);
    }
    @Override
    public int empUpdate(EmpDto empDto) {
    	return empDao.empUpdate(empDto);
    }
    @Override
    public int empDelete(int employeeId) {
    	return empDao.empDelete(employeeId);
    }
}