package com.elasticsearch.root.repository.dao.custom;

import org.elasticsearch.action.search.SearchResponse;

public interface TestRepository {
	SearchResponse findBySafetyRiskInfos() throws Exception;
}
