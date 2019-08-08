/**
 * 
 */
package com.liuaoji.cms.web.controllers;

import static org.hamcrest.CoreMatchers.nullValue;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSON;
import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.Picture;
import com.liuaoji.cms.domain.User;
import com.liuaoji.cms.service.ArticleService;
import com.liuaoji.cms.service.TermService;
import com.liuaoji.cms.service.UserService;
import com.liuaoji.cms.utils.FileUploadUtil;
import com.liuaoji.cms.web.Constant;

import javassist.expr.NewArray;


/**
 * 说明:
 * 
 * @version 1.0
 *
 * 2018年1月10日 下午2:40:38
 */
@Controller
@RequestMapping("/my")
public class UserController {
	@Resource
	private ArticleService articleService;
	
	@Resource
	private TermService termService;
	@Resource(name = "userService")
	private UserService userService;
	
	@RequestMapping({"/", "/index", "/home"})
	public String home(Model model,HttpSession session){
		return "user-space/home";
	}
	
	@RequestMapping({"/profile"})
	public String profile(HttpSession httpSession,Model model){
		return "user-space/profile";
	}
	
	@RequestMapping("/blogs")
	public String blogs(HttpSession session,Model model) {
		Article article = new Article();
		User user = (User) session.getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		List<Article> queryAll = articleService.queryAll(article);
		model.addAttribute("blogs", queryAll);
		return "user-space/blog_list";
	}
	
	//去编辑页面
	@RequestMapping("/blog/edit")
	public String edit(Integer id,Model model) {
		Article selectByPrimaryKey = articleService.selectByPrimaryKey(id);
		model.addAttribute("blog", selectByPrimaryKey);
		return "user-space/blog_edit";
	}
	//发布文章
	@RequestMapping("/blog/save")
	public String save(Article article,MultipartFile file,HttpServletRequest request,MultipartFile[] photo,String[]desc) {
		//上传图片
		String upload = FileUploadUtil.upload(request, file);
		if(!upload.equals("")) {
			article.setPicture(upload);
		}
		
		//判断是修改还是添加文章
		if(article.getId()!=null) {
			//修改
			articleService.update(article);
		}else {
			article.setCreated(new Date());
			article.setDeleted(false);
			article.setHits(0);
			article.setHot(true);
			article.setStatus(0);
			article.setArticletype(0);//0是文字文章，1是图片文章
			//获取当前登录的用户
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			//设置作者
			article.setAuthor(user);
			List<Picture> pictures = new ArrayList<Picture>();
			//判断是文字文章还是图片文章
			if(photo.length!=0) {
				for (int i = 0; i < desc.length; i++) {
					//设置文章的类型为1
					article.setArticletype(1);
					Picture picture = new Picture();
					String upload2 = FileUploadUtil.upload(request, photo[i]);
					
					//判断
					if(!upload2.equals("")) {
						picture.setPhoto(upload2);
					}
					if(!desc.equals("")) {
						picture.setDesc(desc[i]);
					}
					//设置第一张图片显示
					if(i==0) {
						article.setPicture(upload2);
					}
					pictures.add(picture);
				}
				//转为json
				article.setContent(JSON.toJSONString(pictures));
			}
			//调用方法
			articleService.saveBlog(article);
		}
		return "user-space/blog_list";
	}
	//删除
	@RequestMapping("/blog/remove")
	public String remove(Integer id) {
		articleService.removes(id);
		return "redirect:user-space/blog_list";
	}
	//完善用户信息
	@RequestMapping("/user/save,l")
	public String save(Integer id,Model model) {
		User selectById = userService.selectById(id);
		model.addAttribute("user", selectById);
		return "user-space/useredit";
	}
	//查询单个用户信息
	@RequestMapping("/user/edit")
	public String edit(HttpServletRequest request,Model model) {
		Article article = new Article();
		//获取当前登录的用户
		User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
		article.setAuthor(user);
		User selectById = userService.selectById(article.getId());
		model.addAttribute("user", selectById);
		return "redirect:/userInfo";
	}
}
