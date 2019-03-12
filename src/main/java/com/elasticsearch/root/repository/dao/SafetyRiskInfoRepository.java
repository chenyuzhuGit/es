package com.elasticsearch.root.repository.dao;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.elasticsearch.root.repository.entity.SafetyRiskInfo;

//@NoRepositoryBean
@Repository
public interface SafetyRiskInfoRepository extends PagingAndSortingRepository<SafetyRiskInfo, Long> {

}
