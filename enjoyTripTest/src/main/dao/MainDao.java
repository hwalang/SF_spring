package main.dao;

import java.util.List;

import dto.SidoDto;

public interface MainDao {

	List<SidoDto> sidoList();	// 시도 (sidoCode, sidoName ) 리스트
}
