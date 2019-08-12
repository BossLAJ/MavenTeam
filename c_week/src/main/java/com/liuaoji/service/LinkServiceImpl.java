package com.liuaoji.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuaoji.bean.Link;
import com.liuaoji.dao.LinkDao;

@Service
public class LinkServiceImpl implements LinkService{
	
	@Resource
	private LinkDao linkDao;

	@Override
	public List<Link> list() {
		// TODO Auto-generated method stub
		return linkDao.list();
	}

	@Override
	public void add(Link links) {
		// TODO Auto-generated method stub
		linkDao.add(links);
	}

	@Override
	public void down(Integer id) {
		// TODO Auto-generated method stub
		linkDao.down(id);
	}

	@Override
	public void Up(Integer id) {
		// TODO Auto-generated method stub
		linkDao.Up(id);
	}

	@Override
	public void delete(Integer id) {
		// TODO Auto-generated method stub
		linkDao.delete(id);
	}

	@Override
	public List<Link> search(String name) {
		// TODO Auto-generated method stub
		return linkDao.search(name);
	}
}
