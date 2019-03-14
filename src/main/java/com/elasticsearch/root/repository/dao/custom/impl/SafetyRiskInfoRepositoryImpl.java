package com.elasticsearch.root.repository.dao.custom.impl;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Component;

import com.elasticsearch.root.config.DataBaseIndex;
import com.elasticsearch.root.config.DataBaseType;
import com.elasticsearch.root.enums.BoolQueryType;
import com.elasticsearch.root.highlevel.dao.DataSearchService;
import com.elasticsearch.root.repository.dao.custom.Test;

//extends AbstractElasticsearchRepository<SafetyRiskInfo, String>
@Component
public class SafetyRiskInfoRepositoryImpl implements Test {
	@Autowired
	private DataSearchService service;

	@Override
	public void test() {
		// TODO Auto-generated method stub
		try {
			System.out.println("查询开始");
			service.setBoolQueryBuilder(QueryBuilders.boolQuery());
			service.matchAllQuery(BoolQueryType.MUST);
			service.getBoolQueryBuilder();
			SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
			SearchRequest searchRequest = new SearchRequest();
			searchRequest.indices(DataBaseIndex.ACCIDENT_CASE_INDEX);
			searchRequest.source(sourceBuilder);
			searchRequest.types(DataBaseType.DOC_TYPE);

			SearchResponse searchResponse =service.getClient().search(searchRequest, RequestOptions.DEFAULT);
			System.out.println("查询结束");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("222222222");
	}

}
