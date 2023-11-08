package map.service;

import user.dto.UserDto;
import main.dto.*;
import map.dao.MapDao;
import map.dao.MapDaoImpl;

import java.util.List;

import loginout.dao.LoginoutDao;
import loginout.dao.LoginoutDaoImpl;

public class MapServiceImpl implements MapService {
	
	private MapDao mapDao = new MapDaoImpl();

	@Override
	public List<GugunDto> getGugunList(int sidoCode) {
		List<GugunDto> gugunList = mapDao.gugunList(sidoCode);
		
		if (gugunList != null) {
			return gugunList;
		}
		return gugunList;
	}
}
