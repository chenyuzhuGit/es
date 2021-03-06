package com.elasticsearch.root.repository.dao;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.data.repository.NoRepositoryBean;

import com.elasticsearch.root.entity.SafetyRiskInfo;
import com.elasticsearch.root.repository.dao.custom.TestRepository;

/**
 * 隐患表的DSL接口
 * 注：无需对该接口实现
 * @author Administrator
 *
 */
@NoRepositoryBean
public interface SafetyRiskInfoRepository extends ElasticsearchRepository<SafetyRiskInfo, String>, TestRepository{

}
