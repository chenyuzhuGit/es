package com.elasticsearch.root;

import java.util.List;

import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import com.elasticsearch.root.entity.SafetyRiskInfo;
import com.elasticsearch.root.service.SafetyRiskInfoService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
	@Autowired
	private SafetyRiskInfoService service;
	@Autowired
	private ElasticsearchTemplate services;

	@Test
	public void contextLoads() {
		try {
			createIndexMethods();
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
