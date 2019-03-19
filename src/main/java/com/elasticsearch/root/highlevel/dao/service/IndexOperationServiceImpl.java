package com.elasticsearch.root.highlevel.dao.service;

import java.util.List;
import java.util.Map;

import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.delete.DeleteIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.action.admin.indices.get.GetIndexResponse;
import org.elasticsearch.action.support.IndicesOptions;
import org.elasticsearch.action.support.master.AcknowledgedResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.cluster.metadata.AliasMetaData;
import org.elasticsearch.cluster.metadata.MappingMetaData;
import org.elasticsearch.common.collect.ImmutableOpenMap;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import com.carrotsearch.hppc.cursors.ObjectObjectCursor;
import com.elasticsearch.root.highlevel.dao.IndexOperationService;

/**
 * 索引操作接口
 * 
 * @author Administrator
 *
 */
@Component
public class IndexOperationServiceImpl extends BaseDaoServiceImpl implements IndexOperationService {

	@Override
	public CreateIndexResponse createIndex(String indexName, String type, XContentBuilder builder, String alias)
			throws Exception {
		// TODO Auto-generated method stub
		// 源码地址：https://www.elastic.co/guide/en/elasticsearch/client/java-rest/6.6/java-rest-high-create-index.html
		// 创建索引的请求
		CreateIndexRequest request = new CreateIndexRequest(indexName);
		request.settings(Settings.builder().put("index.number_of_shards", 3).put("index.number_of_replicas", 2));
		request.timeout(TimeValue.timeValueMinutes(2));
		request.timeout("2m");
		request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
		request.masterNodeTimeout("1m");
		request.mapping(type, builder);
		// 设置索引别名
		if (!StringUtils.isEmpty(alias)) {
			request.alias(new Alias(alias));
		}
		System.out.println(request.mappings().toString());
		CreateIndexResponse response = getClient().indices().create(request, RequestOptions.DEFAULT);
		return response;

	}

	@Override
	public boolean existsIndex(String indexName) throws Exception {
		// TODO Auto-generated method stub
		GetIndexRequest request = new GetIndexRequest();
		request.indices(indexName);
		request.local(false);
		request.humanReadable(true);
		request.includeDefaults(false);
		boolean exists = getClient().indices().exists(request, RequestOptions.DEFAULT);
		return exists;
	}

	@Override
	public AcknowledgedResponse deleteIndex(String indexName) throws Exception {
		// TODO Auto-generated method stub
		DeleteIndexRequest request = new DeleteIndexRequest(indexName);
		request.timeout(TimeValue.timeValueMinutes(2));
		request.timeout("2m");
		request.masterNodeTimeout(TimeValue.timeValueMinutes(1));
		request.masterNodeTimeout("1m");
		request.indicesOptions(IndicesOptions.lenientExpandOpen());
		AcknowledgedResponse deleteIndexResponse = null;
//		deleteIndexResponse = getClient().indices().delete(request, RequestOptions.DEFAULT);
		deleteIndexResponse = null;
		return deleteIndexResponse;
	}

	@SuppressWarnings("unused")
	@Override
	public GetIndexResponse getIndex(String[] indexNames) throws Exception {
		// TODO Auto-generated method stub
		GetIndexRequest request = new GetIndexRequest().indices(indexNames);
		request.includeDefaults(true);
		request.indicesOptions(IndicesOptions.lenientExpandOpen());
		// 从数据库获取索引信息
		GetIndexResponse getIndexResponse = getClient().indices().get(request, RequestOptions.DEFAULT);
		// 解析索引信息
		for (int i = 0; i < indexNames.length; i++) {
			String indexName = indexNames[i];
			System.out.println("索引信息:" + indexName);
			ImmutableOpenMap<String, MappingMetaData> indexMappings = getIndexResponse.getMappings().get(indexName);
			for (ObjectObjectCursor<String, MappingMetaData> objectObjectCursor : indexMappings) {
				System.out.println("类型:" + objectObjectCursor.key);
				Map<String, Object> indexTypeMappings = indexMappings.get(objectObjectCursor.key).getSourceAsMap();
				List<AliasMetaData> indexAliases = getIndexResponse.getAliases().get(indexName);
				String numberOfShardsString = getIndexResponse.getSetting(indexName, "index.number_of_shards");
				Settings indexSettings = getIndexResponse.getSettings().get(indexName);
				Integer numberOfShards = indexSettings.getAsInt("index.number_of_shards", null);
				TimeValue time = getIndexResponse.defaultSettings().get(indexName).getAsTime("index.refresh_interval",
						null);
			}

		}
		return getIndexResponse;
	}
}
