package map.service;

import user.dto.UserDto;

import java.util.List;

import main.dto.*;

public interface MapService {
	List<GugunDto> getGugunList(int sidoCode);
}
