/**
 * 
 */
package com.liuaoji.cms.web.controllers.admin;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.liuaoji.cms.core.Page;
import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.User;
import com.liuaoji.cms.domain.Zhuanti;
import com.liuaoji.cms.service.ArticleService;
import com.liuaoji.cms.service.ZhuantiService;
import com.liuaoji.cms.web.Constant;
import com.liuaoji.cms.web.controllers.PassportController;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2019年3月29日 下午6:54:11
 */
@Controller
@RequestMapping("/admin")
public class AdminHomeController {
	@Autowired
	private ArticleService articleService;
	@Autowired
	private ZhuantiService zhuantiService;
	
	@Autowired
	public static Logger log = LoggerFactory.getLogger(PassportController.class);
	
	@RequestMapping({"/", "/index"})
	public String home(){
		return "admin/home";
	}
	//专题列表
	@RequestMapping({"/zhuantis"})
	public String getList(Model model ) {
		List<Zhuanti> list = zhuantiService.getList();
		model.addAttribute("list",list);
		return "/admin/zhuantis";
	}
	//去添加页面
	@RequestMapping({"/zhuantis/add"})
	public String addZhuantis(Zhuanti zhuanti) {
		return "/admin/zhuantis_add";
	}
	//添加
	@RequestMapping({"/zhuantis/doAdd"})
	public String toAddzhuantis(Zhuanti zhuanti) {
		zhuantiService.save(zhuanti);
		return "redirect:/admin/zhuantis";
	}
	//去修改页面
	@RequestMapping({"/zhauntis/edit"})
	public String editZhuantis(int id,Model model) {
		Zhuanti zhuanti = zhuantiService.selectById(id);
		model.addAttribute("zhuanti",zhuanti);
		return "/admin/zhuantis_edit";
	}
	//修改
	@RequestMapping({"/zhuantis/doEdit"})
	public String doEditZhuanti(Zhuanti zhuanti) {
		zhuantiService.update(zhuanti);
		return "redirect:/admin/zhuantis";
	}
	//删除
	@RequestMapping({"/zhauntis/del"})
	public String delZhuanti(int id) {
		zhuantiService.del(id);
		return "redirect:/admin/zhuantis";
	}
	
	//去添加文章专题
	@RequestMapping({"/zhuantis/addZhuantiArticle"})
	public String toAddZhuantiArticle(int id,Model model) {
		//查出所有专题的id
		Zhuanti zhuanti = zhuantiService.selectById(id);
		
		//根据专题id查看这个id下面所有的文章id
		List<Integer>articleListById = zhuantiService.zhuantiListById(id);
		//查出对应的文章id
		List<Article> articleList = zhuantiService.articleList();
		model.addAttribute("zhuanti",zhuanti);
		model.addAttribute("articleListById", articleListById);
		model.addAttribute("articleList", articleList);
		return "/admin/zhuantis_article";
	}
	
	//添加文章专题
	@RequestMapping({"/zhuantis/doAddZhuantiArticle"})
	public String toAddZhuantiArticle(int id,String[]ids) {
		zhuantiService.rechoose(id,ids);
		return "redirect:/admin/zhuantis";
	}
}
