package main.service;

import java.util.List;

import main.dto.SidoDto;
import main.dao.MainDao;
import main.dao.MainDaoImpl;

public class MainServiceImpl implements MainService {
	
	private MainDao mainDao = new MainDaoImpl();
	
	@Override
	public List<SidoDto> getSidoList() {
		
		return mainDao.sidoList();
	}
}
