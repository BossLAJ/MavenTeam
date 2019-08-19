package com.liuaoji.dao;

import java.util.List;
import java.util.Map;

import com.liuaoji.bean.User;

public interface UserDao {
	List<Map<String, Object>>getList(Map<String, Object> map);

	void delete(int id);

	List<User> selectById(int id);

	List<User> search(String name);
}
