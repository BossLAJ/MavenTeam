package com.liuaoji.cms.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuaoji.cms.domain.Category;
import com.liuaoji.cms.domain.Channel;
import com.liuaoji.cms.service.ChannelCategoryService;

@Controller
public class ChannelCategoryController {

	@Autowired
	private ChannelCategoryService channelCategoryService;
	
	//查出所有频道
	@RequestMapping("queryAllChannel")
	@ResponseBody
	public List<Channel> queryAllChannel(){
		return channelCategoryService.getChannels();
	}
	
	//根据所选频道查询该频道下的所有种类
	@RequestMapping("queryCategoryByChannelId")
	@ResponseBody
	public List<Category> queryCategoryByChannelId(Integer channel){
		return channelCategoryService.getCategories(channel);
	}
}
