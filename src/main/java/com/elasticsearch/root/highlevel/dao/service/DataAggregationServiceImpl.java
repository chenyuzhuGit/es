package com.elasticsearch.root.highlevel.dao.service;

import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.AggregationBuilders;
import org.springframework.stereotype.Component;

import com.elasticsearch.root.highlevel.dao.DataAggregationService;

/**
 * 数据聚合查询接口
 * 
 * @author Administrator
 *
 */
@Component
public class DataAggregationServiceImpl extends BaseDaoServiceImpl implements DataAggregationService {
	private final String avgPrefix = "avg_";
	private final String minPrefix = "min_";
	private final String maxPrefix = "max_";
	private final String countPrefix = "count_";
	private final String sumPrefix = "sum_";
	private final String statsPrefix = "stats_";
	private final String cardinalityPrefix = "cardinality_";
	private final String termsPrefix = "terms_";
	private final String dateHistogramPrefix = "dateHistogram_";
	private final String topHitsPrefix = "topHits_";

	@Override
	public AggregationBuilder getCount(String field) {
		// TODO Auto-generated method stub
		return AggregationBuilders.count(countPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder getMax(String field) {
		// TODO Auto-generated method stub
		return AggregationBuilders.max(maxPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder getMin(String field) {
		// TODO Auto-generated method stub
		return AggregationBuilders.min(minPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder getAvg(String field) {
		// TODO Auto-generated method stub
		return AggregationBuilders.avg(avgPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder getSum(String field) {
		// TODO Auto-generated method stub
		return AggregationBuilders.sum(sumPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder getStats(String field) {
		// TODO Auto-generated method stub
		return AggregationBuilders.stats(statsPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder getCardinality(String field) throws Exception {
		// TODO Auto-generated method stub
		return AggregationBuilders.cardinality(cardinalityPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder terms(String field) throws Exception {
		// TODO Auto-generated method stub
		return AggregationBuilders.terms(termsPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder getDateHistogram(String field) throws Exception {
		// TODO Auto-generated method stub
		return AggregationBuilders.dateHistogram(dateHistogramPrefix + field).field(field);
	}

	@Override
	public AggregationBuilder topHits(String field) throws Exception {
		// TODO Auto-generated method stub
		return AggregationBuilders.topHits(topHitsPrefix + field);
	}

}
