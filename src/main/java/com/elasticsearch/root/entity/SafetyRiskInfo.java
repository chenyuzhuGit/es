package com.elasticsearch.root.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 实体类
 * 1.隐患表 
 * 2.需要实现序列化接口
 * 3.已定义好分页计算
 * 4.作用：主要用于查询结果映射
 * Document注解解释： 
 *   a.indexName 数据库索引 
 *   b.type 索引中的类型
 * @author Administrator
 *
 */
@SuppressWarnings("serial")
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

	public String getPossibleAccidents() {
		return possibleAccidents;
	}

	public void setPossibleAccidents(String possibleAccidents) {
		this.possibleAccidents = possibleAccidents;
	}

	public String getRiskLevel() {
		return riskLevel;
	}

	public void setRiskLevel(String riskLevel) {
		this.riskLevel = riskLevel;
	}

	public String getDutyUnit() {
		return dutyUnit;
	}

	public void setDutyUnit(String dutyUnit) {
		this.dutyUnit = dutyUnit;
	}

	public Map<String, Object> getCodeRule() {
		return codeRule;
	}

	public void setCodeRule(Map<String, Object> codeRule) {
		this.codeRule = codeRule;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPost() {
		return post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public Map<String, Object> getRiskSource() {
		return riskSource;
	}

	public void setRiskSource(Map<String, Object> riskSource) {
		this.riskSource = riskSource;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Map<String, Object> getCheckLocation() {
		return checkLocation;
	}

	public void setCheckLocation(Map<String, Object> checkLocation) {
		this.checkLocation = checkLocation;
	}

	public String getPeriod() {
		return period;
	}

	public void setPeriod(String period) {
		this.period = period;
	}

	public Map<String, Object> getCheckPerson() {
		return checkPerson;
	}

	public void setCheckPerson(Map<String, Object> checkPerson) {
		this.checkPerson = checkPerson;
	}

	public String getUnitName() {
		return unitName;
	}

	public void setUnitName(String unitName) {
		this.unitName = unitName;
	}

	public String getSuggest() {
		return suggest;
	}

	public void setSuggest(String suggest) {
		this.suggest = suggest;
	}

	public String getBasis() {
		return basis;
	}

	public void setBasis(String basis) {
		this.basis = basis;
	}

	public Map<String, Object> getCheckUnit() {
		return checkUnit;
	}

	public void setCheckUnit(Map<String, Object> checkUnit) {
		this.checkUnit = checkUnit;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public Map<String, Object> getRiskCategory() {
		return riskCategory;
	}

	public void setRiskCategory(Map<String, Object> riskCategory) {
		this.riskCategory = riskCategory;
	}

	public Date getCheckTime() {
		return checkTime;
	}

	public void setCheckTime(Date checkTime) {
		this.checkTime = checkTime;
	}

	public String getRiskPicture() {
		return riskPicture;
	}

	public void setRiskPicture(String riskPicture) {
		this.riskPicture = riskPicture;
	}

	public String getRiskDesc() {
		return riskDesc;
	}

	public void setRiskDesc(String riskDesc) {
		this.riskDesc = riskDesc;
	}

	public String getOrganizationLevel() {
		return organizationLevel;
	}

	public void setOrganizationLevel(String organizationLevel) {
		this.organizationLevel = organizationLevel;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public Map<String, Object> getDataSource() {
		return dataSource;
	}

	public void setDataSource(Map<String, Object> dataSource) {
		this.dataSource = dataSource;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	public Integer getStartIndex() {
		return (pageIndex - 1) * pageSize;
	}

}