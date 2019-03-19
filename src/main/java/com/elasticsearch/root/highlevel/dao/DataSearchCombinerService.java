package com.elasticsearch.root.highlevel.dao;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.apache.lucene.search.join.ScoreMode;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.AbstractQueryBuilder;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.SimpleQueryStringFlag;
import org.elasticsearch.search.aggregations.AggregationBuilder;
import org.elasticsearch.search.aggregations.PipelineAggregationBuilder;
import org.elasticsearch.search.sort.SortOrder;

import com.elasticsearch.root.enums.BoolQueryType;

/**
 * 数据查询接口
 * 
 * @author Administrator
 *
 */
public interface DataSearchCombinerService extends BaseDaoService {

	// --------------------Match All Queries---start------------
	/**
	 * 搜索全部文档
	 * 
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> matchAllQuery() throws Exception;
	// --------------------Match All Queries---End------------

	// --------------------Full Text Queries---start------------
	/**
	 * 匹配查询：用于执行全文查询的标准查询，包括模糊匹配和短语或邻近查询。 查询出包含 value 的数据 或者包含不连续的字符 带分词器查询
	 * 
	 * @param field 字段
	 * @param value 字段值
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> matchQuery(String field, String value, BoolQueryType type) throws Exception;

	/**
	 * 短语匹配查询。 首先解析查询字符串value，产生一个词条列表。然后根据词条列表的所有词条，查询出包含所有词条并且符合词条列表顺序的文档
	 * 以短语形式查询，查询时字段类型为keyword时不会被分词，而是直接以一个字符串的形式查询
	 * 
	 * @param field 字段
	 * @param value 字段值
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> matchPhraseQuery(String field, String value, BoolQueryType type) throws Exception;

	/**
	 * 短语匹配查询。 首先解析查询字符串value，产生一个词条列表。然后根据词条列表的所有词条，查询出包含所有词条并且符合词条列表顺序的文档
	 * 以短语形式查询，查询时字段类型为keyword时不会被分词；而是直接以一个字符串的形式查询 和phraseQuery
	 * 用法是一样的，区别就在于它允许对最后一个词条前缀匹配
	 * 
	 * @param field 字段
	 * @param value 字段值
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> matchPhrasePrefixQuery(String field, String value, BoolQueryType type) throws Exception;

	/**
	 * 多字段匹配查询。 多个字段匹配一个值（为全匹配查询）
	 * 
	 * @param text       字段值
	 * @param fieldNames 字段数组
	 * @param type       条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> multiMatchQuery(Object text, String[] fieldNames, BoolQueryType type) throws Exception;

	/**
	 * 常用词查询
	 * 
	 * @param field 字段
	 * @param value 字段值
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> commonTermsQuery(String field, String value, BoolQueryType type) throws Exception;

	/**
	 * 查询解析查询字符串 如下查询 hotelName 字段 查询 QueryString 为 "四 AND 酒 AND 店 " 查询结果是 hotelName
	 * 同时包含 "四" "酒" "店" 如果不明确 AND 则是OR的关系，包含任意一个term即被命中
	 * 
	 * @param field 字段
	 * @param value 字段值
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> queryStringQuery(String field, String value, BoolQueryType type) throws Exception;

	/**
	 * 简单查询解析查询字符串 如下查询 hotelName 字段 查询 QueryString 为 "四 AND 酒 AND 店 " 查询结果是
	 * hotelName 同时包含 "四" "酒" "店" 如果不明确 AND 则是OR的关系，包含任意一个term即被命中
	 * 
	 * @param field 字段
	 * @param flag  字段匹配类型
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> simpleQueryStringQuery(String field, SimpleQueryStringFlag flag, BoolQueryType type)
			throws Exception;
	// --------------------Full Text Queries---End------------

	// --------------------Term level Queries---start------------

	/**
	 * 全匹配查询。 不会对搜索词进行分词处理，而是作为一个整体与目标字段进行匹配，若完全匹配，则可查询到 【相当于sql：field = 1】 ；不带分词器
	 * 如果数据库字段类型为text，也可以分词查询
	 * 
	 * @param field 字段
	 * @param value 字段值
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> termQuery(String field, String value, BoolQueryType type) throws Exception;

	/**
	 * in查询。 一个字段匹配多个值（为全匹配查询） termsQuery【相当于sql：field in (1,2,3)】； 不带分词器
	 * 如果数据库字段类型为text，也可以分词查询
	 * 
	 * @param field  字段
	 * @param values 字段值集合或数组
	 * @param type   条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> termsQuery(String field, BoolQueryType type, Collection<?> values) throws Exception;

	AbstractQueryBuilder<?> termsQuery(String field, BoolQueryType type, double... value) throws Exception;

	AbstractQueryBuilder<?> termsQuery(String field, BoolQueryType type, float... value) throws Exception;

	AbstractQueryBuilder<?> termsQuery(String field, BoolQueryType type, int... value) throws Exception;

	AbstractQueryBuilder<?> termsQuery(String field, BoolQueryType type, Object... value) throws Exception;

	AbstractQueryBuilder<?> termsQuery(String field, BoolQueryType type, long... value) throws Exception;

	AbstractQueryBuilder<?> termsQuery(String field, BoolQueryType type, String... value) throws Exception;

	/**
	 * 范围查询。 rangeQuery【相当于sql：field > 1 and field<30】
	 * 
	 * @param field        字段
	 * @param from         开始位置
	 * @param to           结束位置
	 * @param includeLower 是否包含下限
	 * @param includeUpper 是否包含上限
	 * @param type         条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> rangeQuery(String field, Object from, Object to, boolean includeLower, boolean includeUpper,
			BoolQueryType type) throws Exception;

	/**
	 * 字段非空查询。 查询某个字段值非空的记录 existsQuery【相当于sql：field is not null】
	 * 
	 * @param field 字段
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> existsQuery(String field, BoolQueryType type) throws Exception;

	/**
	 * 字段前缀查询。 查询某个字段值非空的记录 prefixQuery【相当于sql：field like '张*'】
	 * 
	 * @param field  字段
	 * @param prefix 前缀
	 * @param type   条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> prefixQuery(String field, String prefix, BoolQueryType type) throws Exception;

	/**
	 * 通配符查询。 查询某个字段值非空的记录 wildcardQuery【相当于sql：field like '*张_三*'】
	 * 查找指定字段包含与指定模式匹配的术语的文档，其中模式支持单字符通配符（？）和多字符通配符（*）
	 * 
	 * @param field  字段
	 * @param prefix 前缀
	 * @param type   条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> wildcardQuery(String field, String prefix, BoolQueryType type) throws Exception;

	/**
	 * 正则表达式查询。 查找指定字段包含与指定的正则表达式匹配的术语的文档。
	 * 
	 * @param field  字段
	 * @param regexp 正则表达式
	 * @param type   条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> regexpQuery(String field, String regexp, BoolQueryType type) throws Exception;

	/**
	 * 模糊度查询。 通过fuzziness设置可以错几个
	 * 查找指定字段包含与指定术语模糊相似的术语的文档。模糊度是以Levenshtein编辑距离1或2来衡量的。
	 * 
	 * @param field 字段
	 * @param value 字段值
	 * @param type  条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> fuzzyQuery(String field, String value, BoolQueryType type) throws Exception;

	/**
	 * 类型查询。 相当于sql：select * from table 查找指定类型的文档。
	 * 
	 * @param indextype 索引类型
	 * @param type      条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> typeQuery(String indextype, BoolQueryType type) throws Exception;

	/**
	 * 类型主键查询。 相当于sql：select * from table where id in (1,2) 查找具有指定类型和ID的文档。
	 * 
	 * @param type 条件拼接类型s 索引下的doc类型
	 * @param ids  id数组
	 * @param type 条件拼接类型 条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> idsQuery(String[] types, String[] ids, BoolQueryType type) throws Exception;

	// --------------------Term level Queries---End---------

	// --------------------Compound Queries---start---------
	// 复合查询包装其他复合或叶子查询，以组合其结果和分数，更改其行为，或从查询切换到筛选器上下文。
	/**
	 * 包装另一个查询并仅返回与查询中每个文档的查询升压相等的常量分数的查询。 参数:queryBuilder—将查询包装在一个常量分数查询中
	 * 
	 * @param queryBuilder builder
	 * @param type         条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> constantScoreQuery(QueryBuilder queryBuilder, BoolQueryType type) throws Exception;

	/**
	 * 用于组合多个叶子或复合查询子句的默认查询，包含must, should, must_not, or filter
	 * 。must和should子句将它们的分数组合在一起 - 匹配子句越多越好 - 而must_not和filter子句在过滤器上下文中执行。
	 * must：返回的文档必须满足must子句的条件，并且参与计算分值 filter：返回的文档必须满足filter子句的条件。不参与计算分值
	 * must_not：返回的文档必须不满足must_not定义的条件。不参与评分。
	 * should：返回的文档可能满足should子句的条件。在一个Bool查询中，如果没有must或者filter，有一个或者多个should子句，那么只要满足一个就可以返回。minimum_should_match参数定义了至少满足几个子句。
	 * shold理解【匹配的相关度】
	 * 
	 * @param queryBuilder builder
	 * @param type         条件拼接类型
	 * @throws Exception
	 */
	void boolQuery(AbstractQueryBuilder<?> queryBuilder, BoolQueryType type) throws Exception;

	/**
	 * 嵌套查询, 内嵌文档查询
	 * 
	 * @param path         嵌套字段的路径如：person.name
	 * @param queryBuilder 查询builber
	 * @param scoreMode    得分模式
	 * @param type         条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> nestedQueryBuilder(String path, AbstractQueryBuilder<?> queryBuilder, ScoreMode scoreMode,
			BoolQueryType type) throws Exception;

	/**
	 * 父子关联查询--通过 child找到 parents 但是这个映射也对父-子文档关系有个限制条件：父文档和其所有子文档，都必须要存储在同一个分片中。
	 * 
	 * @param childType    子文档集的类型
	 * @param queryBuilder 查询builber
	 * @param scoreMode    得分模式
	 * @param type         条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> hasChildQueryBuilder(String childType, AbstractQueryBuilder<?> queryBuilder,
			ScoreMode scoreMode, BoolQueryType type) throws Exception;

	/**
	 * 父子关联查询--通过 parents找到 child 但是这个映射也对父-子文档关系有个限制条件：父文档和其所有子文档，都必须要存储在同一个分片中。
	 * 
	 * @param parentType   父文档集的类型
	 * @param queryBuilder 查询builber
	 * @param scoreMode    得分是否从父命中传播到子命中
	 * @param type         条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> hasParentQueryBuilder(String parentType, AbstractQueryBuilder<?> queryBuilder,
			boolean scoreMode, BoolQueryType type) throws Exception;

	/**
	 * 
	 * @param parentType 父文档类型
	 * @param id         父id
	 * @param type       条件拼接类型
	 * @return
	 * @throws Exception
	 */
	AbstractQueryBuilder<?> parentIdQueryBuilder(String parentType, String id, BoolQueryType type) throws Exception;

	/**
	 * 设置boolQueryBuilder builder
	 * 
	 * @param boolQueryBuilder
	 */
	void setBoolQueryBuilder(BoolQueryBuilder boolQueryBuilder);

	/**
	 * 获取boolQueryBuilder builder
	 * 
	 * @param boolQueryBuilder
	 */
	BoolQueryBuilder getBoolQueryBuilder();

	/**
	 * 查询
	 * 
	 * @param index 索引
	 * @param doc   索引类型
	 * @return
	 * @throws Exception
	 */
	SearchResponse search(String index, String doc) throws Exception;

	/**
	 * 分页查询
	 * 
	 * @param startIndex 开始位置
	 * @param numberPage 每页的数量
	 * @param index      索引
	 * @param doc        索引类型
	 * @return
	 * @throws Exception
	 */
	SearchResponse search(String index, String doc, Integer startIndex, Integer numberPage) throws Exception;

	/**
	 * 设置聚合
	 * 
	 * @param AggregationBuilder 聚合对象
	 */
	void setAggregation(AggregationBuilder builder);

	/**
	 * 设置聚合
	 * 
	 * @param PipelineAggregationBuilder 聚合对象
	 */
	void setAggregation(PipelineAggregationBuilder builder);

	/**
	 * 设置排序字段
	 * 
	 * @param field 字段
	 * @param sort  排序类型(正序、倒序)
	 */
	void setOrderBy(String field, SortOrder sort);

	/**
	 * 设置排序字段
	 * 
	 * @param sortOrder key为字段，value为排序类型
	 */
	void setOrderBy(Map<String, SortOrder> sortOrder);

	/**
	 * 根据class类型将查询结果集转换为list集合
	 * 
	 * @param classType 主要为实体类型和Map类型
	 * @return
	 * @throws Exception
	 */
	List<?> getResults(Class<?> classType) throws Exception;
}
