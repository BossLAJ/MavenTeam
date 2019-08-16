/**
 * 
 */
package com.liuaoji.cms.web.controllers;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.liuaoji.cms.core.Page;
import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.Category;
import com.liuaoji.cms.domain.Channel;
import com.liuaoji.cms.domain.Picture;
import com.liuaoji.cms.domain.Slide;
import com.liuaoji.cms.service.ArticleService;
import com.liuaoji.cms.service.SlideService;

import javassist.expr.NewArray;

/**
 * 说明:首页
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午8:19:15
 */
@Controller
public class HomeController {

	@Resource
	private ArticleService articleService;
	
	@Resource
	private SlideService slideService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		//------------------------------------
		Page _page = new Page(page, 30);
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);
		
					Thread thread1 = new Thread(new Runnable() {
						
						@Override
						public void run() {
							//默认首页显示热门文章
							if(category == null && channel == null){
								conditions.setHot(true);
								
								//热门文章时显示幻灯片
								List<Slide> slides = slideService.getTops(5);
								model.addAttribute("slides", slides);
							}
							
						}
					});
					thread1.start();
				
			
					Thread thread2 = new Thread(new Runnable() {
						
						@Override
						public void run() {
							//如果频道或分类不为空，则显示分类或频道数据
							if(category != null){
								conditions.setCategory(new Category(category));
							}else if(channel != null){
								conditions.setChannel(new Channel(channel));
							}
							
							List<Article> articles = articleService.gets(conditions, _page, null);
							model.addAttribute("articles", articles);
						}
					});
					thread2.start();
		
				
				
					Thread thread3 = new Thread(new Runnable() {
						
						@Override
						public void run() {
							//---------------右侧放10条最新文章---------------------
							Article lastArticlesConditions = new Article();
							lastArticlesConditions.setDeleted(false);
							lastArticlesConditions.setStatus(1);
							
							Page lastArticlesPage = new Page(1, 10);
							lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
							
							List<Article> lastArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
							model.addAttribute("lastArticles", lastArticles);
						}
					});
					thread3.start();
				
				
		
				
					Thread thread4 = new Thread(new Runnable() {
						
						@Override
						public void run() {
							if(channel != null){
								model.addAttribute("channel", new Channel(channel));
							}
							model.addAttribute("category", category);				
						}
					});
					thread4.start();
					
					Thread thread5 = new Thread(new Runnable() {
						
						@Override
						public void run() {
							Article picArticle = new Article();
							picArticle.setStatus(1);
							picArticle.setHot(true);
							picArticle.setArticletype(1);
							
							Page picLastPage = new Page(1,5);
							picLastPage.setTotalCount(50);//总记录数
							List<Article> picArticlesList = articleService.gets(picArticle, picLastPage, null);
							model.addAttribute("picArticlesList", picArticlesList);
						}
					});
					thread5.start();
					
					try {
						thread1.join();
						thread2.join();
						thread3.join();
						thread4.join();
						thread5.join();
					} catch (Exception e) {
						e.printStackTrace();
					}
		return "home";
	}
	
	//显示最新的10篇文章
	@RequestMapping("/article")
	public String article(int id,HttpServletRequest request,Model model) {
		articleService.increaseHit(id);
		Article article = articleService.selectByPrimaryKey(id);
		
		Article hotArticle = new Article();
		hotArticle.setHot(true);
		hotArticle.setStatus(1);
		hotArticle.setDeleted(false);
		Page lastArticlesList = new Page(1,5);
		lastArticlesList.setTotalCount(100);
		
		
		List<Article> hotArticlesLists = articleService.gets(hotArticle, lastArticlesList, null);
		model.addAttribute("hotArticlesList", hotArticlesLists);
		
		//转json
		List<Picture> parseArray = JSONArray.parseArray(article.getContent(),Picture.class);
		model.addAttribute("pictures", parseArray);
		
		
		model.addAttribute("blogs", article);
		
		return "blog";
	}
}
