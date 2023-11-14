package main.dao;

import java.util.List;

import main.dto.SidoDto;

public interface MainDao {
	
	List<SidoDto> sidoList();	// 시도 (시도코드, 이름)
}
