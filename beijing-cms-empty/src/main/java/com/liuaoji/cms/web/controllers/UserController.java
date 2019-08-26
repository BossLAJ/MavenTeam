/**
 * 
 */
package com.liuaoji.cms.web.controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.OptionX;
import com.liuaoji.cms.domain.Picture;
import com.liuaoji.cms.domain.User;
import com.liuaoji.cms.service.ArticleService;
import com.liuaoji.cms.service.UserService;
import com.liuaoji.cms.service.VoteService;
import com.liuaoji.cms.utils.FileUploadUtil;
import com.liuaoji.cms.utils.PageHelpUtil;
import com.liuaoji.cms.web.Constant;

/**
 * 说明:
 * 
 * @author howsun ->[howsun.zhang@gmail.com]
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {

	@Autowired
	ArticleService articleService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	VoteService voteService;
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}
	//去投票页面
	@RequestMapping({"vote/edit"})
	public String voteEdit(){
		return "user-space/vote_edit";
	}
	
	
	@RequestMapping("/vote/save")
	public String voteSave(Article article,String[] optiones,HttpServletRequest request) {
		//设置文章发布默认的状态
		article.setHot(true);
		article.setHits(1);
		article.setStatus(1);
		article.setDeleted(false);
		article.setCreated(new Date());
		article.setUpdated(new Date());
		article.setArticletype(2);
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		//创建数组存储
		ArrayList<OptionX> optionList = new ArrayList<OptionX>();
		
		if(optiones.length !=0) {
			for (int i = 0; i < optiones.length; i++) {
				optionList.add(new OptionX(optiones[i], null));
			}
		}
		article.setContent(JSON.toJSONString(optionList));
		articleService.save(article);
		return "redirect:/my/blogs";
	}
	
	
	//列表
	@RequestMapping("/blogs")
	public String blogs(HttpServletRequest request,@RequestParam(value="page",defaultValue="1")Integer page,Model model) {
		Article article = new Article();
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		//分页
		PageHelper.startPage(page,3);
		//调用方法
		List<Article> queryAll = articleService.queryAll(article);
		//设置页数
		PageInfo<Article> pageInfo = new PageInfo<Article>(queryAll);
		//调用分页工具类
		String pageList = PageHelpUtil.page("/my/blogs", pageInfo, null);
		model.addAttribute("blogs", queryAll);
		model.addAttribute("pageList", pageList);
		return "user-space/blog_list";
	}
	
	//文章修改查询
	@RequestMapping("/blog/edit")
	public String blogEdit(Integer id,Model model ) {
		Article selectByPrimaryKey = articleService.selectByPrimaryKey(id);
		model.addAttribute("blog", selectByPrimaryKey);
		return "user-space/blog_edit";
	}
	
	//文章发布和更新
	@RequestMapping("/blog/save")
	public String blogSave(Article article,MultipartFile file,HttpServletRequest request) {
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")) {
			article.setPicture(upload);
		}
		if(article.getId()!=null) {
			//修改
			article.setUpdated(new Date());
			articleService.updateByKey(article);
		}else {
			//设置文章的属性
			article.setHits(1);
			article.setHot(true);
			article.setStatus(1);
			article.setDeleted(false);
			article.setCreated(new Date());
			article.setUpdated(new Date());
			article.setArticletype(0);//0代表文字文章
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			article.setAuthor(user);
			articleService.save(article);
		}
		return "redirect:/my/blogs";
	}
	
	//删除
	@RequestMapping("/blog/remove")
	public String remove(Integer id) {
		articleService.remove(id);
		return "redirect:/my/blogs";
	}
	
	//去上传头像
	@RequestMapping("/profile/avatar")
	public String profileAvatar() {
		return "/user-space/avatar";
	}
	
	//实现上传头像的方法,设置用户的头像，必然要获取用户名，根据用户名进行查询用户信息
	@RequestMapping("/avatar/save")
	public String avatarSave(HttpServletRequest request,MultipartFile file,Model model){		
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		String upload = FileUploadUtil.upload(request, file);
		
		if(!upload.equals("")){
			user.setAvatarpath(upload);
		}
		userService.updateById(user);
		request.getServletContext().setAttribute("avatarpath", upload);
		return "redirect:/my/profile/avatar";
		
	}
	
	//去个人设置页面
	@RequestMapping("/profile/Info")
	public String profileInfo(HttpServletRequest request,Model model) {
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		User selectById = userService.selectById(user.getId());
		model.addAttribute("profile", selectById);
		return "/user-space/profile";
	}
	
	//个人设置 
	@RequestMapping("/profile/save")
	public String profileSave(User profile,Model model) {
		userService.updateById(profile);
		return "redirect:/my/profile/Info";
	}
	//去发布文章图片
	@RequestMapping("/picture/edit")
	public String pictureEdit() {
		return "/user-space/pic_edit";
	}
	//发布图片文章
	@RequestMapping("/picture/save")
	public String pictureSave(HttpServletRequest request, Article article,MultipartFile[] pictures,String[] desces) {
		//设置文章默认的属性
		article.setHot(true);
		article.setHits(1);
		article.setStatus(1);
		article.setDeleted(false);
		article.setCreated(new Date());
		article.setUpdated(new Date());
		article.setArticletype(1);//设置为1 是图片文章
		//获取当前登录的用户
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		//设置当前登录的用户为作者
		article.setAuthor(user);
		
		//创建存放图片的集合
		ArrayList<Picture> picList = new ArrayList<Picture>();
		if(pictures.length!=0) {
			for (int i = 0; i < desces.length; i++) {
				//创建新的图片对象
				Picture picture = new Picture();
				//上传图片
				String upload = FileUploadUtil.upload(request, pictures[i]);
				if(!upload.equals("")) {
					picture.setPhoto(upload);
				}
				if(desces[i]!=null && desces[i] !="") {
					picture.setDesc(desces[i]);
				}
				//设置首张图片显示
				if(i==0) {
					article.setPicture(upload);
				}
				picList.add(picture);
			}
		}
		//json转换
		article.setContent(JSON.toJSONString(picList));
		//调用方法
		articleService.save(article);
		return "redirect:/my/blogs";
	}
}
