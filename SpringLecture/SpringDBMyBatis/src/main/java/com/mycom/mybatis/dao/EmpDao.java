package com.mycom.mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.mycom.mybatis.dto.EmpDto;

@Mapper
public interface EmpDao {

	EmpDto empDetail(int employeeId);		// 사원 상세
	List<EmpDto> empList();					// 사원 목록
	int empInsert(EmpDto dto);				// 사원 등록
	int empUpdate(EmpDto dto);				// 사원 수정
	int empDelete(int employeeId);			// 사원 삭제
	
	
	List<EmpDto> empListLike(String searchWord);		// 사원 목록 - like 검색
	List<EmpDto> empListResultMap(String searchWord);	// 사원 목록 - ResultMap
	
	// 복수개의 파라미터 처리
	List<EmpDto> empListParameterMap(Map<String, String> map);	// 사원 목록 - Param: Map  
	List<EmpDto> empListParameterMap2(@Param("firstName") String firstName, @Param("lastName") String lastName);	// 사원 목록 - @Param
	List<EmpDto> empListParameterMap3(EmpDto dto);				// 사원 목록 - Param: Dto
	
	// Dynamic SQL
	List<EmpDto> empListWhereIf(
			@Param("firstName") String firstName, 
			@Param("lastName") String lastName, 
			@Param("email") String email
			);
}
