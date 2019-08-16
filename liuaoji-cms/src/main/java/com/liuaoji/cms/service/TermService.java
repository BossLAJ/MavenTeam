package com.liuaoji.cms.service;

import java.util.List;

import com.liuaoji.cms.domain.Term;

public interface TermService {

	void addBatch(List<Term> terms);

	void saveWithTerm(int article_id, int id);

}
