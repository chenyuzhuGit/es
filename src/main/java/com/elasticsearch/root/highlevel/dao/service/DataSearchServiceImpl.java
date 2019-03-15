package com.elasticsearch.root.highlevel.dao.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.CommonTermsQueryBuilder;
import org.elasticsearch.index.query.ConstantScoreQueryBuilder;
import org.elasticsearch.index.query.ExistsQueryBuilder;
import org.elasticsearch.index.query.FuzzyQueryBuilder;
import org.elasticsearch.index.query.IdsQueryBuilder;
import org.elasticsearch.index.query.MatchAllQueryBuilder;
import org.elasticsearch.index.query.MatchPhraseQueryBuilder;
import org.elasticsearch.index.query.MatchQueryBuilder;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.PrefixQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.index.query.QueryStringQueryBuilder;
import org.elasticsearch.index.query.RangeQueryBuilder;
import org.elasticsearch.index.query.RegexpQueryBuilder;
import org.elasticsearch.index.query.SimpleQueryStringBuilder;
import org.elasticsearch.index.query.SimpleQueryStringFlag;
import org.elasticsearch.index.query.TermQueryBuilder;
import org.elasticsearch.index.query.TermsQueryBuilder;
import org.elasticsearch.index.query.TypeQueryBuilder;
import org.elasticsearch.index.query.WildcardQueryBuilder;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.search.sort.SortOrder;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.context.WebApplicationContext;

import com.elasticsearch.root.enums.BoolQueryType;
import com.elasticsearch.root.highlevel.dao.DataSearchService;

/**
 * 数据查询接口
 * 
 * @author Administrator
 *
 */
//设置每次请求都注入一个新的对象
@Scope(value = WebApplicationContext.SCOPE_REQUEST, proxyMode = ScopedProxyMode.INTERFACES)
@Component
public class DataSearchServiceImpl extends BaseDaoServiceImpl implements DataSearchService {
	private BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
	private Map<String, SortOrder> sortOrder = new LinkedHashMap<String, SortOrder>();
	private Integer numberPage;
	private Integer startIndex;
	private List<Object> results;
	private SearchResponse searchResponse;

	@Override
	public AbstractQueryBuilder<?> matchAllQuery(BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		MatchAllQueryBuilder query = QueryBuilders.matchAllQuery();
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> matchQuery(String field, String value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		MatchQueryBuilder query = QueryBuilders.matchQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> matchPhraseQuery(String field, String value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		MatchPhraseQueryBuilder query = QueryBuilders.matchPhraseQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> matchPhrasePrefixQuery(String field, String value, BoolQueryType type)
			throws Exception {
		// TODO Auto-generated method stub
		MatchQueryBuilder query = QueryBuilders.matchQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> multiMatchQuery(Object text, String[] fieldNames, BoolQueryType type)
			throws Exception {
		// TODO Auto-generated method stub
		MultiMatchQueryBuilder query = QueryBuilders.multiMatchQuery(text, fieldNames);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> queryStringQuery(String field, String value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		QueryStringQueryBuilder query = QueryBuilders.queryStringQuery(field).defaultField(value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> simpleQueryStringQuery(String field, String value, SimpleQueryStringFlag flag,
			BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		SimpleQueryStringBuilder query = QueryBuilders.simpleQueryStringQuery(field).flags(flag);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> commonTermsQuery(String field, String value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		CommonTermsQueryBuilder query = QueryBuilders.commonTermsQuery(field, value);
		boolQuery(query, type);

		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termQuery(String field, String value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermQueryBuilder query = QueryBuilders.termQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termsQuery(String field, Collection<?> values, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermsQueryBuilder query = QueryBuilders.termsQuery(field, values);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termsQuery(String field, double[] value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermsQueryBuilder query = QueryBuilders.termsQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termsQuery(String field, float[] value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermsQueryBuilder query = QueryBuilders.termsQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termsQuery(String field, int[] value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermsQueryBuilder query = QueryBuilders.termsQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termsQuery(String field, Object[] value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermsQueryBuilder query = QueryBuilders.termsQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termsQuery(String field, long[] value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermsQueryBuilder query = QueryBuilders.termsQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> termsQuery(String field, String[] value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TermsQueryBuilder query = QueryBuilders.termsQuery(field, value);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> rangeQuery(String field, Object from, Object to, boolean includeLower,
			boolean includeUpper, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		RangeQueryBuilder query = QueryBuilders.rangeQuery(field).from(from).to(to).includeLower(includeLower)
				.includeUpper(includeUpper);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> existsQuery(String field, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		ExistsQueryBuilder query = QueryBuilders.existsQuery(field);
		boolQuery(query, type);

		return query;
	}

	@Override
	public AbstractQueryBuilder<?> prefixQuery(String field, String prefix, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		PrefixQueryBuilder query = QueryBuilders.prefixQuery(field, prefix);
		boolQuery(query, type);

		return query;
	}

	@Override
	public AbstractQueryBuilder<?> wildcardQuery(String field, String prefix, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		WildcardQueryBuilder query = QueryBuilders.wildcardQuery(field, prefix);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> regexpQuery(String field, String regexp, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		RegexpQueryBuilder query = QueryBuilders.regexpQuery(field, regexp);
		boolQuery(query, type);

		return query;
	}

	@Override
	public AbstractQueryBuilder<?> fuzzyQuery(String field, String value, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		FuzzyQueryBuilder query = QueryBuilders.fuzzyQuery(field, value);
		boolQuery(query, type);

		return query;
	}

	@Override
	public AbstractQueryBuilder<?> typeQuery(String indextype, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		TypeQueryBuilder query = QueryBuilders.typeQuery(indextype);
		boolQuery(query, type);
		return query;
	}

	@Override
	public AbstractQueryBuilder<?> idsQuery(String[] types, String[] ids, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		if (ids == null || ids.length == 0) {
			return null;
		}
		IdsQueryBuilder query = null;
		if (types == null || types.length == 0) {
			query = QueryBuilders.idsQuery();
		} else {
			query = QueryBuilders.idsQuery(types);
		}
		query.addIds(ids);
		boolQuery(query, type);

		return query;
	}

	@Override
	public AbstractQueryBuilder<?> constantScoreQuery(QueryBuilder queryBuilder, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		ConstantScoreQueryBuilder query = QueryBuilders.constantScoreQuery(queryBuilder);
		boolQuery(query, type);
		return query;
	}

	@Override
	public void boolQuery(AbstractQueryBuilder<?> queryBuilder, BoolQueryType type) throws Exception {
		// TODO Auto-generated method stub
		switch (type) {
		case MUST:
			boolQueryBuilder.must(queryBuilder);
			break;
		case MUST_NOT:
			boolQueryBuilder.mustNot(queryBuilder);
			break;
		case SHOULD:
			boolQueryBuilder.should(queryBuilder);
			break;
		case FILTER:
			boolQueryBuilder.filter(queryBuilder);
			break;
		default:
			break;
		}
	}

	public void setBoolQueryBuilder(BoolQueryBuilder boolQueryBuilder) {
		this.boolQueryBuilder = boolQueryBuilder;
	}

	@Override
	public SearchResponse search(String index, String doc) throws Exception {
		// TODO Auto-generated method stub
		SearchSourceBuilder sourceBuilder = assemblySearchBuilder(false);
		SearchRequest searchRequest = assemblySearchRequest(index, doc, sourceBuilder);
		searchResponse = getClient().search(searchRequest, RequestOptions.DEFAULT);
		return searchResponse;
	}

	@Override
	public SearchResponse search(String index, String doc, Integer startIndex, Integer numberPage) throws Exception {
		this.startIndex = startIndex != null && startIndex >= 0 ? startIndex : 0;
		this.numberPage = numberPage != null && numberPage >= 0 ? numberPage : 1;

		SearchSourceBuilder sourceBuilder = assemblySearchBuilder(true);
		SearchRequest searchRequest = assemblySearchRequest(index, doc, sourceBuilder);
		searchResponse = getClient().search(searchRequest, RequestOptions.DEFAULT);
		return searchResponse;
	}

	@Override
	public List<?> getResults(Class<?> classType) throws Exception {
		// TODO Auto-generated method stub
		results = new ArrayList<Object>();
		SearchHits searchHits = searchResponse.getHits();
		for (SearchHit hit : searchHits) {
			if (classType.equals(Map.class)) {
				Map<String, Object> source = hit.getSourceAsMap();
				results.add(source);
			} else {
				String source = hit.getSourceAsString();
				results.add(mapper.readValue(source, classType));
			}

		}
		return results;
	}

	private SearchSourceBuilder assemblySearchBuilder(boolean isPage) {
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		// 设置分页
		if (isPage) {
			sourceBuilder.from(startIndex);// 起始位置
			sourceBuilder.size(numberPage);// 查询数量
		}
		// 设置排序
		for (String key : sortOrder.keySet()) {
			sourceBuilder.sort(key, sortOrder.get(key));
		}
		sourceBuilder.query(boolQueryBuilder);
		return sourceBuilder;
	}

	private SearchRequest assemblySearchRequest(String index, String doc, SearchSourceBuilder sourceBuilder) {
		SearchRequest searchRequest = new SearchRequest();
		searchRequest.indices(index);
		searchRequest.source(sourceBuilder);
		searchRequest.types(doc);
		return searchRequest;
	}

	@Override
	public void setOrderBy(String field, SortOrder sort) {
		// TODO Auto-generated method stub
		if (!StringUtils.isEmpty(field) && !StringUtils.isEmpty(sort)) {
			sortOrder.put(field, sort);
		}
	}

	@Override
	public void setOrderBy(Map<String, SortOrder> sortOrder) {
		// TODO Auto-generated method stub
		if (sortOrder != null) {
			this.sortOrder = sortOrder;
		}
	}

}
