/**
 * 
 */
package com.liuaoji.cms.web.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.alibaba.fastjson.JSONArray;
import com.liuaoji.cms.core.Page;
import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.Category;
import com.liuaoji.cms.domain.Channel;
import com.liuaoji.cms.domain.OptionX;
import com.liuaoji.cms.domain.Picture;
import com.liuaoji.cms.domain.Slide;
import com.liuaoji.cms.domain.User;
import com.liuaoji.cms.domain.Vote;
import com.liuaoji.cms.service.ArticleService;
import com.liuaoji.cms.service.SlideService;
import com.liuaoji.cms.service.VoteService;
import com.liuaoji.cms.web.Constant;

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
	
	@Resource
	private VoteService voteService;
	
	private HashSet<String> hashset = new HashSet<String>();
	
	
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(
			@RequestParam(required = false) Integer channel, //频道
			@RequestParam(required = false) Integer category,//分类
			@RequestParam(defaultValue = "1") Integer page,//分类
			Model model){
		
		//------------------------------------
		Page _page = new Page(page, 30);
		List<Article> articles = null;
		
		//拼条件
		Article conditions = new Article();
		conditions.setDeleted(false);
		conditions.setStatus(1);

		//默认首页显示热门文章
		Thread t1 = new Thread(new Runnable() {
			
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
		t1.start();
		
		//如果频道或分类不为空，则显示分类或频道数据
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//如果频道或分类不为空，则显示分类或频道数据
				List<Article> articles = null;
				if(category != null){
					conditions.setCategory(new Category(category));
				}else if(channel != null){
					conditions.setChannel(new Channel(channel));
				}
				
				articles = articleService.gets(conditions, _page, null);
				model.addAttribute("articles", articles);
				
			}
		});
		t2.start();
		

		//---------------右侧放10条最新文章---------------------
		Thread t3 = new Thread(new Runnable() {
			
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
		t3.start();
		Thread t4 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				if(channel != null){
					model.addAttribute("channel", new Channel(channel));
				}
				model.addAttribute("category", category);		
			}
		});
		t4.start();
		Thread t5 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//---------------右侧放10条图片文章---------------------
				Article lastArticlesConditions = new Article();
				lastArticlesConditions.setDeleted(false);
				lastArticlesConditions.setStatus(1);
				lastArticlesConditions.setArticletype(1);
				
				Page lastArticlesPage = new Page(1, 10);
				lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> picArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
				model.addAttribute("picArticles", picArticles);			
			}
		});
		t5.start();
		
		Thread t6 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				//---------------右侧放10条最新投票信息---------------------
				Article lastArticlesConditions = new Article();
				lastArticlesConditions.setDeleted(false);
				lastArticlesConditions.setStatus(1);
				lastArticlesConditions.setArticletype(2);
				
				Page lastArticlesPage = new Page(1, 10);
				lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
				
				List<Article> voteArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
				model.addAttribute("voteArticles", voteArticles);			
			}
		});
		t6.start();
		
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
			t6.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "home";
		
	}
	
	//点击增加访问量，以及查询文章
	@RequestMapping("/article")
	public String article(Integer id ,Model model,
			HttpServletRequest request) {
		
		//---------------右侧放10条热门文章---------------------
		Article lastArticlesConditions = new Article();
		lastArticlesConditions.setDeleted(false);
		lastArticlesConditions.setStatus(1);
		lastArticlesConditions.setHot(true);		
		Page lastArticlesPage = new Page(1, 10);
		lastArticlesPage.setTotalCount(100);//设置了总记录数，可以节省统计查询，提高性能。
		
		List<Article> hotArticles = articleService.gets(lastArticlesConditions, lastArticlesPage, null);
		model.addAttribute("hotArticles", hotArticles);
		
		//---------------登录用户访问文章，阅读量只会添加一次---------------------
		//调用cookie.每一个用户访问只能增加一次访问量
		Cookie[] cookies = request.getCookies();
		//判断对象是否在集合中
		//第一个cookies对象
		if(!hashset.contains(cookies[0].getValue())) {
			hashset.add(cookies[0].getValue());
			articleService.increasehit(id);
		}
		
		
		//根据ID进行文章查询
		Article article = articleService.selectByPrimaryKey(id);
		model.addAttribute("blog", article);
		//---------------图片类型的文章---------------------
		if(article.getArticletype() == 1){
			List<Picture> parseArray = JSONArray.parseArray(article.getContent(), Picture.class);
			System.out.println(parseArray.get(0).toString());
			model.addAttribute("pictures", parseArray);
		}
		//---------------投票类型的文章---------------------
		if(article.getArticletype() == 2) {
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);			
			Vote vote = new Vote();
			vote.setArticle(new Article(id));
			//设置当前用户
			vote.setUser(user);
			//判断
			int count = voteService.selectByBUId(vote);
			//判断count
			if(count !=0) {
				//已经判断过了
				Vote vote2 = new Vote();
				vote2.setArticle(new Article(id));
				int sum = voteService.selectByBUId(vote2);
				//放入作用域
				model.addAttribute("sum", sum);
				
				//集合
				List<Map<String, Long>> resultList = voteService.countByOption(id);
				ArrayList<OptionX> optionXList = new ArrayList<OptionX>();
				//遍历
				for(Map<String, Long> map :resultList) {
					Set<String> keySet = map.keySet();
					OptionX optionX = new OptionX();
					//遍历
					for(String key : keySet) {
						//判断键值对
						if(key.equals("optResult")) {
							optionX.setOption(String.valueOf(map.get(key)));
						}
						if(key.equals("count(id)")) {
							optionX.setCount(map.get(key));
						}
					}
					//加入选项集合
					optionXList.add(optionX);
				}
				//加入作用域
				model.addAttribute("optionXList", optionXList);
				return "voteResult";
			}else {
				List<OptionX> parseArray = JSONArray.parseArray(article.getContent(),OptionX.class);
				model.addAttribute("parseArray", parseArray);
				return "vote";
			}
		}
		return "blog";
	}
}
