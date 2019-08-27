package com.liuaoji.cms.service;

import java.util.List;
import java.util.Map;

import com.liuaoji.cms.domain.Vote;

public interface VoteService {

	int saveOption(Vote vote);

	int selectByBUId(Vote vote);

	List<Map<String, Long>> countByOption(Integer id);
}
