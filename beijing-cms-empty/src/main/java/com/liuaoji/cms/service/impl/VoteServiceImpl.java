package com.liuaoji.cms.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.liuaoji.cms.dao.VoteMapper;
import com.liuaoji.cms.domain.Vote;
import com.liuaoji.cms.service.VoteService;

@Service
public class VoteServiceImpl implements VoteService{

	@Resource
	private VoteMapper voteMapper;

	@Override
	public int saveOption(Vote vote) {
		// TODO Auto-generated method stub
		return voteMapper.saveOption(vote);
	}

	@Override
	public int selectByBUId(Vote vote) {
		// TODO Auto-generated method stub
		return voteMapper.selectByBUid(vote);
	}

	@Override
	public List<Map<String, Long>> countByOption(Integer id) {
		// TODO Auto-generated method stub
		return voteMapper.countByOption(id);
	}
}
