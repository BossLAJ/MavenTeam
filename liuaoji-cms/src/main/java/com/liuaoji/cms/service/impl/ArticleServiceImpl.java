/**
 * 
 */
package com.liuaoji.cms.service.impl;


import java.util.LinkedHashMap;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.liuaoji.cms.core.Page;
import com.liuaoji.cms.dao.ArticleMapper;
import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.service.ArticleService;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年4月21日 下午9:06:07
 */
@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Resource
	ArticleMapper articleMapper;

	@Override
	@Transactional(propagation = Propagation.NOT_SUPPORTED, readOnly = true)
	public List<Article> gets(Article conditions, Page page, LinkedHashMap<String, Boolean> orders) {
		List<Article> articles = articleMapper.selects(conditions, orders, page);
		if(page != null && page.getPageCount() == 0){
			int totalCount = articleMapper.count(conditions);
			page.setTotalCount(totalCount);
		}
		return articles;
	}
	
	@Override
	public int count(Article article) {
		return articleMapper.count(article);
	}
	
	public List<Article> selects( Article article, LinkedHashMap<String, Boolean> orders,Page page){
			
			return articleMapper.selects(article, orders, page);
			
	}
	
		//根据id 查询文章
		@Override
		public Article selectByPrimaryKey(Integer id) {
			
			return articleMapper.selectByPrimaryKey(id);
		}
		
		//根据id 更新文章
		@Override
		public int updateByKey(Article article) {
			// TODO Auto-generated method stub
			return articleMapper.updateByKey(article);
		}
		
		@Override
		public void saveBlog(Article article) {
			articleMapper.save(article);;
		}
		
		@Override
		public void increaseHit(Integer id) {
			articleMapper.increaseHit(id);
		}


		@Override
		public Article queryWithTerm(Integer id) {
			return articleMapper.queryWithTerm(id);
		}
		
		@Override
		public int audit(int id) {
			return articleMapper.audit(id);
		}

		@Override
		public List<Article> queryAll(Article article) {
			// TODO Auto-generated method stub
			return articleMapper.queryAll(article);
		}

		@Override
		public void update(Article article) {
			articleMapper.update(article);
		}

		@Override
		public void remove(int id) {
			articleMapper.remove(id);
		}

		@Override
		public void removes(Integer id) {
			articleMapper.remove(id);
		}
}
