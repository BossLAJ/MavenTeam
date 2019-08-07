package com.liuaoji.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuaoji.dao.MovieDao;

@Service
public class movieServiceImpl implements movieService{
	
	@Autowired
	private MovieDao movieDao;
	@Override
	public List<Map<String, Object>> getList(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return movieDao.getList(map);
	}

}
