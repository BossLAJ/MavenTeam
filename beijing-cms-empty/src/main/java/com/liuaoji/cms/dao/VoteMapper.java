package com.liuaoji.cms.dao;

import java.util.List;
import java.util.Map;

import com.liuaoji.cms.domain.Vote;

public interface VoteMapper {

	int saveOption(Vote vote);

	int selectByBUid(Vote vote);

	List<Map<String, Long>> countByOption(Integer id);
}
