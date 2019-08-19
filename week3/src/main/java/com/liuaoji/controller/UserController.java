package com.liuaoji.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuaoji.bean.User;
import com.liuaoji.service.UserService;

@Controller
public class UserController {

	@Resource
	private UserService userService;
	
	@RequestMapping("list.do")
	public String getList(Model model,@RequestParam(value="page",defaultValue="1") Integer page) {
		Map<String, Object> map = new HashMap<String, Object>();
		PageHelper.startPage(page,3);
		List<Map<String, Object>> list = userService.getList(map);
		PageInfo<Map<String, Object>> plist = new PageInfo<Map<String, Object>>(list);
		model.addAttribute("list", list);
		model.addAttribute("plist", plist);
		return "list";
	}
	@RequestMapping("delete.do")
	public String delete(int id) {
		userService.delete(id);
		return "redirect:list.do";
	}
	//去修改页面
	@RequestMapping("update.do")
	public String update(int id,Model model) {
		List<User> userlist = userService.selectById(id);
		model.addAttribute("userlist", userlist);
		return "update";
	}
	//搜索
	@RequestMapping("search.do")
	public String search(String name,Model model) {
		List<User> list = userService.search(name);
		model.addAttribute("list", list);
		return "redirect:list.do";
	}
}
