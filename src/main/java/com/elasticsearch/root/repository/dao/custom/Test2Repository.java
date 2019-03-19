package com.elasticsearch.root.repository.dao.custom;

import org.elasticsearch.action.search.SearchResponse;

public interface Test2Repository {
	SearchResponse findBySafetyRiskInfos() throws Exception;
}
