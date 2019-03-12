package com.elasticsearch.root.repository.service;

import java.util.List;

import com.elasticsearch.root.repository.entity.SafetyRiskInfo;

public interface SafetyRiskInfosService {
	List<SafetyRiskInfo> searchSafetyRiskInfo(Integer pageNumber, Integer pageSize, String searchContent);
}
