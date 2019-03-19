package com.elasticsearch.root;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.elasticsearch.root.config.DataBaseIndex;
import com.elasticsearch.root.config.DataBaseType;
import com.elasticsearch.root.entity.SafetyRiskInfo;
import com.elasticsearch.root.highlevel.dao.DataAggregationService;
import com.elasticsearch.root.highlevel.dao.DataSearchCombinerService;
import com.elasticsearch.root.highlevel.dao.IndexOperationService;
import com.elasticsearch.root.repository.dao.SafetyRiskInfo1Repository;
import com.elasticsearch.root.repository.dao.SafetyRiskInfo2Repository;
import com.elasticsearch.root.repository.dao.SafetyRiskInfo3Repository;
import com.elasticsearch.root.repository.dao.custom.impl.SafetyRiskInfoRepositoryImpl;
import com.elasticsearch.root.service.SafetyRiskInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
	@Autowired
	private SafetyRiskInfoService service;
	@Autowired
	private ElasticsearchTemplate services;
//	@Autowired
	@Resource(name = "dataSearchCombinerServiceImpl")
	private DataSearchCombinerService dataSearchService;

	@Autowired
	private SafetyRiskInfoRepositoryImpl safetyRiskInfoRepository;
	@Autowired
	private SafetyRiskInfo1Repository safetyRiskInfoRepository1;
	@Autowired
	private SafetyRiskInfo2Repository safetyRiskInfoRepository2;
//	@Resource(name = "SafetyRiskInfo3RepositoryImpl")
	@Autowired
	private SafetyRiskInfo3Repository safetyRiskInfoRepository3;
	@Autowired
	private IndexOperationService indexOperationService;

	@Autowired
	private DataAggregationService dataAggregationService;

	@Test
	public void contextLoads() {
		try {
//			System.out.println();
//			dataSearchTest();
//			createIndexMethods();
//			dataSearchService.termsQuery("xxxx", BoolQueryType.MUST,"ad","sdf","sdf");
//			dataSearchCombinerService2.matchAllQuery();
			safetyRiskInfoRepository.findBySafetyRiskInfos();
			safetyRiskInfoRepository1.findBySafetyRiskInfos();
			safetyRiskInfoRepository2.findBySafetyRiskInfos();
			safetyRiskInfoRepository3.findBySafetyRiskInfos();
//			dataSearchService.getBoolQueryBuilder();
//			dataSearchService.setAggregation(dataAggregationService.getCount("unitName"));
//			SearchResponse result = dataSearchService.search(DataBaseIndex.SAFETY_RISK_INFO_INDEX,
//					DataBaseType.DOC_TYPE);
//			indexOperationService.getIndex(new String[] { "safety_risk_info", "xinweike", "accident_case" });
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void dataSearchTest() {
		try {
//			dataSearchService.matchQuery("asdj", "sdsdf", BoolQueryType.MUST);
			dataSearchService.search(DataBaseIndex.SAFETY_RISK_INFO_INDEX, DataBaseType.DOC_TYPE);
			List<Map<String, Object>> ss = (List<Map<String, Object>>) dataSearchService.getResults(Map.class);
			List<SafetyRiskInfo> sss = (List<SafetyRiskInfo>) dataSearchService.getResults(SafetyRiskInfo.class);
			System.out.println();
//			dataSearchService.search();
//			dataSearchService.search();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 创建索引；创建完成后，表中会生成一条记录
	 * 
	 * @throws Exception
	 */
	public void createIndexMethods() throws Exception {
		System.out.println();
		List<SafetyRiskInfo> ss = service.searchSafetyRiskInfo(0, 10, "安全");
		System.out.println(ss);
		XContentBuilder builder = XContentFactory.jsonBuilder();
		// TODO Auto-generated method stub
		builder.startObject();
		{
			{
				builder.startObject("doc");
				{
					{
						builder.startObject("properties");
						{
							{
								builder.startObject("user");
								{
									{
										builder.field("type", "text");
									}
								}
								builder.endObject();
							}
							{
								builder.startObject("postDate");
								{
									{
										builder.field("type", "date");
									}
								}
								builder.endObject();
							}
							{
								builder.startObject("message");
								{
									{
										builder.field("type", "text");
									}
								}
								builder.endObject();
							}
						}
						builder.endObject();
					}
				}
				builder.endObject();
			}
		}
		builder.endObject();
	}

}
