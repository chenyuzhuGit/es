package com.elasticsearch.root.repository.dao.custom.impl;

import javax.annotation.Resource;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.stereotype.Component;

import com.elasticsearch.root.config.DataBaseIndex;
import com.elasticsearch.root.config.DataBaseType;
import com.elasticsearch.root.highlevel.dao.DataSearchCombinerService;
import com.elasticsearch.root.repository.dao.custom.TestRepository;

@Component
public class SafetyRiskInfoRepositoryImpl implements TestRepository {
	@Resource(name = "dataSearchCombinerServiceImpl")
	private DataSearchCombinerService service;

	@Override
	public SearchResponse findBySafetyRiskInfos() throws Exception {
		// TODO Auto-generated method stub
		SearchResponse searchResponse = null;
		try {
			System.out.println("查询开始");
			service.setBoolQueryBuilder(QueryBuilders.boolQuery());
			service.matchAllQuery();
			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
			SearchRequest searchRequest = new SearchRequest();
			searchRequest.indices(DataBaseIndex.ACCIDENT_CASE_INDEX);
			searchRequest.source(sourceBuilder);
			searchRequest.types(DataBaseType.DOC_TYPE);
			searchResponse = service.getClient().search(searchRequest, RequestOptions.DEFAULT);
			System.out.println("查询结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return searchResponse;
	}

}
