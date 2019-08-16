package com.liuaoji.cms.service;

import java.util.LinkedHashMap;
import java.util.List;


import com.liuaoji.cms.core.Page;
import com.liuaoji.cms.domain.Article;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月28日 下午4:48:47
 */
public interface ArticleService {

	/**
	 * 功能说明：<br>
	 * @param conditions
	 * @param page
	 * @param orders  排序，默认按创建时间倒排序
	 * @return
	 * List<Article>
	 */
	public abstract List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders);
	
	public List<Article> selects( Article article, LinkedHashMap<String, Boolean> orders,Page page);
	
	/**
	 * 功能说明：统计<br>
	 * @param article
	 * @return
	 * int
	 */
	 
	 public abstract int count(Article article);
	
	//根据主键查询
	public Article selectByPrimaryKey(Integer id);
	
	//根据id 更新
	public int updateByKey(Article article);
	
	void saveBlog(Article article);
	
	public abstract void increaseHit(Integer id);


	public abstract Article queryWithTerm(Integer id);
	
	public int audit(int id);

	public abstract List<Article> queryAll(Article article);
	//修改
	public abstract void update(Article article);

	public abstract void remove(int id);

	public abstract void removes(Integer id);

}