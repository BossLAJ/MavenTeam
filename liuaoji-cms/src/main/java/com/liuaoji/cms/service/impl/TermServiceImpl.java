package com.liuaoji.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.liuaoji.cms.dao.TermMapper;
import com.liuaoji.cms.domain.Term;
import com.liuaoji.cms.service.TermService;

@Service("termService")
public class TermServiceImpl implements TermService {

	@Autowired
	private TermMapper termMapper;
	
	@Override
	public void addBatch(List<Term> terms) {
		termMapper.addBatch(terms);
	}

	@Override
	public void saveWithTerm(int article_id, int term_id) {
		termMapper.saveWithTerm(article_id,term_id);
	}

}
