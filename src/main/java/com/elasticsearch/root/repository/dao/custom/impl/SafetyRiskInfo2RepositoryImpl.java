package com.elasticsearch.root.repository.dao.custom.impl;

import org.elasticsearch.action.search.SearchResponse;
import org.springframework.stereotype.Component;

import com.elasticsearch.root.repository.dao.custom.Test2Repository;
import com.elasticsearch.root.repository.dao.custom.TestRepository;

@Component
public class SafetyRiskInfo2RepositoryImpl implements TestRepository, Test2Repository {

	@Override
	public SearchResponse findBySafetyRiskInfos() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SafetyRiskInfo2RepositoryImpl实现");
		return null;
	}

}
