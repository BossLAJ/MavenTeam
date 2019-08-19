package com.liuaoji.controller;

import java.io.File;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bawei.common.utils.DateUtil;
import com.bawei.common.utils.StreamUtil;
import com.bawei.common.utils.StringUtil;
import com.github.pagehelper.PageHelper;
import com.liuaoji.bean.Link;
import com.liuaoji.service.LinkService;

@Controller
public class LinkController {

	@Resource
	private LinkService linkService;
	
	@RequestMapping("list.do")
	public String getList(Model model) {
		List<Link> links = linkService.list();
		model.addAttribute("link", links);
		return "list";
	}
	@RequestMapping("addlink.do")
	public String add(Model model) {
		File file = new File("f:\\data.txt");
		List<String> readLineFile = StreamUtil.readLineFile(file);
		for (String string : readLineFile) {
			Link links = new Link();
			String[] split = string.split(" ");
			links.setId(Integer.parseInt(split[0]));
			links.setName(split[1]);
			links.setLink(split[2]);
			if(split[3].isEmpty()) {
				links.setCreate(new Date());
			}else {
				links.setCreate(DateUtil.strToDate(split[3]));
			}
			links.setScore(Integer.parseInt(split[4]));
			String regex ="[^0-9]";
			links.setSubstr(StringUtil.regexNum(split[2], regex));
			linkService.add(links);
		}
		return "redirect:list.do";
	}
	
	@RequestMapping("updateDown.do")
	public String down(Integer id) {
		linkService.down(id);
		return "redirect:list.do";
	}
	@RequestMapping("updateUp.do")
	public String Up(Integer id) {
		linkService.Up(id);
		return "redirect:list.do";
	}
	@RequestMapping("delete.do")
	public String delete(Integer id) {
		linkService.delete(id);
		return "redirect:list.do";
	}
	@RequestMapping("search.do")
	public String search(String name,Model model) {
		List<Link> links = linkService.search(name);
		model.addAttribute("link", links);
		return "list";
	}
}
