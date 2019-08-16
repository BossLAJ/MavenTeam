package com.liuaoji.cms.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuaoji.cms.dao.ZhuantiMapper;
import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.Zhuanti;
import com.liuaoji.cms.service.ZhuantiService;

@Service
public class ZhuantiSeriviceImpl implements ZhuantiService{
		
	@Resource
	private ZhuantiMapper zhuantiMapper;

	@Override
	public List<Zhuanti> getList() {
		// TODO Auto-generated method stub
		return zhuantiMapper.getList();
	}

	@Override
	public void save(Zhuanti zhuanti) {
		// TODO Auto-generated method stub
		zhuantiMapper.save(zhuanti);
	}

	@Override
	public void del(int id) {
		// TODO Auto-generated method stub
		zhuantiMapper.del(id);
	}

	@Override
	public Zhuanti selectById(int id) {
		// TODO Auto-generated method stub
		return zhuantiMapper.selectById(id);
	}

	@Override
	public void update(Zhuanti zhuanti) {
		// TODO Auto-generated method stub
		zhuantiMapper.update(zhuanti);
	}

	@Override
	public List<Integer> zhuantiListById(int id) {
		// TODO Auto-generated method stub
		return zhuantiMapper.zhuantiListById(id);
	}

	@Override
	public List<Article> articleList() {
		// TODO Auto-generated method stub
		return zhuantiMapper.articleList();
	}

	@Override
	public void rechoose(int id, String[] ids) {
		// TODO Auto-generated method stub
		zhuantiMapper.delArticle(id);
		if(ids != null) {
			for (@SuppressWarnings("unused") String article_id : ids) {
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("id", id);
				map.put("ids", ids);
				zhuantiMapper.addArt(map);
			}
		}
	}
	
	
}
