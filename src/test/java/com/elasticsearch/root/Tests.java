package com.elasticsearch.root;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.elasticsearch.root.repository.entity.SafetyRiskInfo;
import com.elasticsearch.root.repository.service.SafetyRiskInfosService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {
	@Autowired
	private SafetyRiskInfosService service;

	@Test
	public void contextLoads()  {
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
		List<SafetyRiskInfo> ss=service.searchSafetyRiskInfo(0, 10, "安全");
		System.out.println(ss);
	}

}
