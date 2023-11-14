package map.dao;

import java.util.List;

import main.dto.*;
import map.dto.*;

public interface MapDao {
	List<GugunDto> gugunList(int sidoCode);
}
