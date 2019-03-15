package com.elasticsearch.root.highlevel.dao.service;

import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import com.elasticsearch.root.highlevel.dao.DataAggregationService;

/**
 * 数据聚合查询接口
 * 
 * @author Administrator
 *
 */
@Component
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
public class DataAggregationServiceImpl extends BaseDaoServiceImpl implements DataAggregationService {

	@Override
	public void getCount(String field) {
		// TODO Auto-generated method stub
		AggregationBuilders.avg(field);
	}

	@Override
	public void getMax(String field) {
		// TODO Auto-generated method stub
		AggregationBuilders.max(field);
	}

	@Override
	public void getMin(String field) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getAvg(String field) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getSum(String field) {
		// TODO Auto-generated method stub

	}

	@Override
	public void getStats(String field) {
		// TODO Auto-generated method stub

	}

}
