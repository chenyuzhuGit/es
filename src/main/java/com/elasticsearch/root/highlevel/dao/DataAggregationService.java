package com.elasticsearch.root.highlevel.dao;

import org.elasticsearch.search.aggregations.AggregationBuilder;

/**
 * 数据聚合查询接口
 * 
 * @author Administrator
 *
 */
public interface DataAggregationService extends BaseDaoService {
	/**
	 * 统计某个字段的数量
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getCount(String field) throws Exception;

	/**
	 * 求最大值
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getMax(String field) throws Exception;

	/**
	 * 求最小值
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getMin(String field) throws Exception;

	/**
	 * 求平均
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getAvg(String field) throws Exception;

	/**
	 * 求和
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getSum(String field) throws Exception;

	/**
	 * 统计
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getStats(String field) throws Exception;

	/**
	 * 去重统计某个字段的数量（有少量误差）
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getCardinality(String field) throws Exception;

	/**
	 * 按某个字段分组
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder terms(String field) throws Exception;

	/**
	 * 按日期间隔分组
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder getDateHistogram(String field) throws Exception;

	/**
	 * 获取聚合里面的结果
	 * 
	 * @param field
	 * @return
	 * @throws Exception
	 */
	AggregationBuilder topHits(String field) throws Exception;
}
