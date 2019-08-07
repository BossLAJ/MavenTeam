package com.liuaoji.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.liuaoji.service.movieService;

@Controller
public class MovieController {
	@Autowired
	private movieService movieService;
	
	@RequestMapping("list.do")
	public String getList(Model model) {
		Map<String, Object> map = new HashMap<>();
		List<Map<String, Object>> list = movieService.getList(map);
		model.addAttribute("movie",list);
		return "list";
	}
	
	
}
