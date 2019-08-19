package com.liuaoji.service;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuaoji.bean.User;
import com.liuaoji.dao.UserDao;

@Service
public class UserServiceImpl implements UserService{

	@Resource
	private UserDao userDao;

	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return userDao.getList(map);
	}

	@Override
	public void delete(int id) {
		userDao.delete(id);
	}

	@Override
	public List<User> selectById(int id) {
		// TODO Auto-generated method stub
		return userDao.selectById(id);
	}

	@Override
	public List<User> search(String name) {
		// TODO Auto-generated method stub
		return userDao.search(name);
	}
}
