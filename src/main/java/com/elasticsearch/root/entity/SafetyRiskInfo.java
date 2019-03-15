package com.elasticsearch.root.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * 实体类 1.隐患表 2.需要实现序列化接口 3.已定义好分页计算 4.作用：主要用于查询结果映射 Document注解解释： a.indexName
 * 数据库索引 b.type 索引中的类型
 * 
 * @author Administrator
 *
 */
@JsonIgnoreProperties(ignoreUnknown = true)
@SuppressWarnings("serial")
@Getter
@Setter
@Document(indexName = "safety_risk_info", type = "doc", indexStoreType = "fs", shards = 5, replicas = 1, refreshInterval = "-1")
public class SafetyRiskInfo implements Serializable {
	private String possibleAccidents;
	private String riskLevel;
	private String dutyUnit;
	private Map<String, Object> codeRule;
	private String content;
	private String post;
	private Map<String, Object> riskSource;
	private String id;
	private Map<String, Object> checkLocation;
	private String period;
	private Map<String, Object> checkPerson;
	private String unitName;
	private String suggest;
	private String basis;
	private Map<String, Object> checkUnit;
	private String site;
	private Map<String, Object> riskCategory;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date checkTime;
	private String riskPicture;
	private String riskDesc;
	private String organizationLevel;
	private String projectName;
	private Map<String, Object> dataSource;
	private Integer pageSize = 10;
	private Integer pageIndex = 1;

	public Integer getStartIndex() {
		return (pageIndex - 1) * pageSize;
	}

}