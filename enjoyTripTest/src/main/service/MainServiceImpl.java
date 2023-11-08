package main.service;

import java.util.List;

import dto.SidoDto;
import main.dao.MainDao;
import main.dao.MainDaoImpl;

public class MainServiceImpl implements MainService {
	
	private MainDao mainDao = new MainDaoImpl();

	@Override
	public List<SidoDto> sidoList() {
		System.out.println("MainServiceImpl: sidoList()");
		return mainDao.sidoList();
	}

}
