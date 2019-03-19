package com.elasticsearch.root.repository.dao.custom.impl;

import org.elasticsearch.action.search.SearchResponse;
import org.springframework.stereotype.Component;

import com.elasticsearch.root.repository.dao.custom.Test2Repository;

@Component
public class SafetyRiskInfo3RepositoryImpl implements Test2Repository{

	@Override
	public SearchResponse findBySafetyRiskInfos() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("SafetyRiskInfo3RepositoryImpl实现");
		return null;
	}

}
