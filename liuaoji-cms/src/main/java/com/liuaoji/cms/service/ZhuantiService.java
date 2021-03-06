package com.liuaoji.cms.service;

import java.util.List;

import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.Zhuanti;

public interface ZhuantiService {
	//列表
	public List<Zhuanti>getList();
	//添加
	public void save(Zhuanti zhuanti);
	//删除
	public void del(int id);
	//修改之前先查询
	public Zhuanti selectById(int id);
	//修改
	public void update(Zhuanti zhuanti);
	
	//专题文章
	public List<Integer> zhuantiListById(int id);
	
	public List<Article> articleList();
	public void rechoose(int id, String[] ids);
}
