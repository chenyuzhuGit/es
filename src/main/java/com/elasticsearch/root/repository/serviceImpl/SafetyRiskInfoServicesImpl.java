package com.elasticsearch.root.repository.serviceImpl;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.elasticsearch.common.logging.Loggers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.elasticsearch.root.repository.dao.SafetyRiskInfoRepository;
import com.elasticsearch.root.repository.entity.SafetyRiskInfo;
import com.elasticsearch.root.repository.service.SafetyRiskInfosService;

@Service
public class SafetyRiskInfoServicesImpl implements SafetyRiskInfosService {
	private static final Logger LOGGER = Loggers.getLogger(SafetyRiskInfoServicesImpl.class);

	/* 分页参数 */
	Integer PAGE_SIZE = 12; // 每页数量
	Integer DEFAULT_PAGE_NUMBER = 0; // 默认当前页码
	/* 搜索模式 */
	String SCORE_MODE_SUM = "sum"; // 权重分求和模式
	Float MIN_SCORE = 10.0F; // 由于无相关性的分值默认为 1 ，设置权重分最小值为 10
	@Autowired
	SafetyRiskInfoRepository safetyRiskInfoRepository; // ES 操作类

//	public Long saveSafetyRiskInfo(SafetyRiskInfo safetyRiskInfo) {
//		SafetyRiskInfo safetyRiskInfoResult = safetyRiskInfoRepository.save(safetyRiskInfo);
//		return safetyRiskInfoResult.getId();
//	}

	@Override
	public List<SafetyRiskInfo> searchSafetyRiskInfo(Integer pageNumber, Integer pageSize, String searchContent) {
		// 校验分页参数
		if (pageSize == null || pageSize <= 0) {
			pageSize = PAGE_SIZE;
		}
		if (pageNumber == null || pageNumber < DEFAULT_PAGE_NUMBER) {
			pageNumber = DEFAULT_PAGE_NUMBER;
		}
		Page<SafetyRiskInfo> safetyRiskInfoPage = safetyRiskInfoRepository.findAll(PageRequest.of(0, 10));
		return safetyRiskInfoPage.getContent();
	}

}
