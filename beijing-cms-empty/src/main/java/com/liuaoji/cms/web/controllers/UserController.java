/**
 * 
 */
package com.liuaoji.cms.web.controllers;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.print.DocFlavor.STRING;
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
import com.liuaoji.cms.domain.Picture;
import com.liuaoji.cms.domain.User;
import com.liuaoji.cms.service.ArticleService;
import com.liuaoji.cms.service.UserService;
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
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(){
		return "user-space/profile";
	}
	//列表
	public String blogs(HttpServletRequest request,@RequestParam(value="page",defaultValue="1")Integer page,Model model) {
		Article article = new Article();
		//获取当前登录的对象
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		//设置作者
		article.setAuthor(user);
		//分页
		PageHelper.startPage(page,3);
		//调用方法
		List<Article> queryAll = articleService.queryAll(article);
		//设置页数
		PageInfo<Article> pageInfo = new PageInfo<Article>(queryAll,3);
		//分页工具
		String pageList = PageHelpUtil.page("/my/blogs", pageInfo, null);
		//放入作用域
		model.addAttribute("blogs", queryAll);
		model.addAttribute("pageList", pageList);
		return "user-space/blog_list";
	}
	
	//文章修改---先查询回显
	@RequestMapping("/blog/edit")
	public String blogEdit(Integer id,Model model) {
		Article article = articleService.selectByPrimaryKey(id);
		model.addAttribute("blog", article);
		return "user-space/blog_edit";
	}
	
	//文章发布和更新
	@RequestMapping("/blog/save")
	public String blogSave(Article article,MultipartFile file,HttpServletRequest request) {
		//上传图片
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")) {
			article.setPicture(upload);
		}
		//发布文章判断文章id是否存在
		if(article.getId() !=null) {
			article.setUpdated(new Date());
			articleService.updateByKey(article);
		}else {
			//设置文章发布默认的状态
			article.setHot(true);
			article.setHits(1);
			article.setStatus(1);
			article.setDeleted(false);
			article.setCreated(new Date());//发布时间
			article.setUpdated(new Date());//更新时间
			article.setArticletype(0);
			//设置当前登录的用户
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			//将当前登录的用户设置为文章作者
			article.setAuthor(user);
			//调用方法
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
	public String avatar() {
		return "user-space/avatar";
	}
	//实现上传头像的方法,设置用户的头像，必然要获取用户名，根据用户名进行查询用户信息
	@RequestMapping("/avatar/save")
	public String avatarSave(HttpServletRequest request,MultipartFile file,Model model) {
		//获取当前登录的用户
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		//上传图片
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")) {
			user.setAvatarpath(upload);
		}
		userService.updateById(user);	
		//上下文获取
		request.getServletContext().setAttribute("avatarpath", upload);
		return "redirect:/my/profile/avatar";
	}
	//个人设置 
	@RequestMapping("/profile/save")
	public String profileSave(User profile,Model model) {
		userService.updateById(profile);
		return "redirect:/my/profile/Info";
	}
	
	@RequestMapping("/profile/Info")
	public String profileInfo(HttpServletRequest request,
			Model model) {
		User Loginuser = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		User user = userService.selectById(Loginuser.getId());
		model.addAttribute("profile", user);
		return "user-space/profile";
	}
	//去发布文章图片
	@RequestMapping("/picture/edit")
	public String pictureEdit() {
		return "/user-space/pic_edit";
	}
	//发布图片文章
	@RequestMapping("/picture/save")
	public String pictureSave(Article article,MultipartFile[] pictures,HttpServletRequest request,String[] desces) {
			//设置文章发布默认的状态
			article.setHot(true);
			article.setHits(1);
			article.setStatus(1);
			article.setDeleted(false);
			article.setCreated(new Date());//发布时间
			article.setUpdated(new Date());//更新时间
			article.setArticletype(1);
			//设置当前登录的用户
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			//设置作者
			article.setAuthor(user);
			ArrayList<Picture> picList =  new ArrayList<Picture>();
			if(pictures.length !=0) {
				for (int i = 0; i < desces.length; i++) {
					Picture picture = new Picture();
					String upload = FileUploadUtil.upload(request, pictures[i]);
					if(!upload.equals("")) {
						picture.setPhoto(upload);
					}
					if(desces[i]!=null && desces[i]!="") {
						picture.setDesc(desces[i]);
					}
					if(i==0) {
						article.setPicture(upload);
					}
					picList.add(picture);
				}
			}
			article.setContent(JSON.toJSONString(picList));
			articleService.save(article);
		return "redirect:/my/blogs";
	}
}
