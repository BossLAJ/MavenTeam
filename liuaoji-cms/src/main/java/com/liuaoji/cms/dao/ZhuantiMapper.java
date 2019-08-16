package com.liuaoji.cms.dao;

import java.util.List;
import java.util.Map;

import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.Zhuanti;

public interface ZhuantiMapper {
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
	public void delArticle(int id);
	public void addArt(Map<String, Object> map);
	
}
