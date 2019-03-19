package com.elasticsearch.root.highlevel.dao;

import org.elasticsearch.client.RestHighLevelClient;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * dao基类
 * 
 * @author Administrator
 *
 */
public interface BaseDaoService {
	/**
	 * json字符串、对象转换工具
	 */
	ObjectMapper mapper = new ObjectMapper();

	/**
	 * 获取数据库操作对象
	 * 
	 * @return
	 */
	RestHighLevelClient getClient();
}
