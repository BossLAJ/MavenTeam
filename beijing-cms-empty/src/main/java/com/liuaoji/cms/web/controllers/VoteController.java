package com.liuaoji.cms.web.controllers;


import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuaoji.cms.domain.Article;
import com.liuaoji.cms.domain.User;
import com.liuaoji.cms.domain.Vote;
import com.liuaoji.cms.service.VoteService;
import com.liuaoji.cms.web.Constant;

@Controller
@RequestMapping("/vote")
public class VoteController {

	@Resource
	private VoteService voteService;
	
	
	@RequestMapping("/optionSave")
	@ResponseBody
	public Boolean optionSave(HttpServletRequest request,String option,Integer blogid) {
		return null;
	}
}
