package com.liuaoji.service;

import java.util.List;

import com.liuaoji.bean.Link;

public interface LinkService {

	List<Link> list();

	void add(Link links);

	void down(Integer id);

	void Up(Integer id);

	void delete(Integer id);

	List<Link> search(String name);

}
