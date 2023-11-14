package main.service;

import java.util.List;

import main.dto.SidoDto;

public interface MainService {
	List<SidoDto> getSidoList(); // 시도 리스트를 리턴(코드, 이름)
}
