package com.mycom.mybatis.service;

import java.util.List;

import com.mycom.mybatis.dto.EmpDto;

public interface EmpService {
    EmpDto empDetail(int employeeId); // 사원 상세 조회
    
    List<EmpDto> empList(); // 사원 전체 조회
    
    int empInsert(EmpDto empDto); // 사원 등록
    
    int empUpdate(EmpDto empDto); // 사원 수정
    
    int empDelete(int employeeId); // 사원 삭제
}