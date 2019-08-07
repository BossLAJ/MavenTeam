package com.liuaoji.dao;

import java.util.List;
import java.util.Map;

public interface MovieDao {
	
	List<Map<String,Object>> getList(Map<String, Object>map);
}
