package com.elasticsearch.root.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.elasticsearch.root.entity.SafetyRiskInfo;

/**
 * 隐患查询接口
 * 
 * @author Administrator
 *
 */
public interface SafetyRiskInfoService {

	String safetyRiskInfoList(HttpServletRequest request);

	String idsQuery(String index, String type, String ids);

	List<SafetyRiskInfo> searchSafetyRiskInfo(Integer pageNumber, Integer pageSize, String searchContent);
}
