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
		Vote vote = new Vote();
		vote.setArticle(new Article(blogid));
		//设置字符格式
		try {
			String answer = new String(request.getParameter("option").getBytes("ISO-8859-1"), "utf-8");
			//设置答案
			vote.setOptResult(answer);
			User user = (User) request.getSession().getAttribute(Constant.LOGIN_USER);
			//设置作者
			vote.setUser(user);
			//设置投票时间
			vote.setVoteTime(new Date());
			int result = voteService.saveOption(vote);
			//判断
			if(result !=0) {
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
}
