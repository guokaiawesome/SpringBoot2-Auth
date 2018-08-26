package com.monster.auth.elasticsearch.service;

import static org.elasticsearch.index.query.QueryBuilders.*;

import org.apache.lucene.queryparser.xml.builders.BooleanQueryBuilder;
import org.apache.lucene.search.BooleanQuery;
import org.elasticsearch.action.termvectors.TermVectorsFilter;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.geo.GeoPoint;
import org.springframework.data.elasticsearch.core.query.Criteria;
import org.springframework.data.elasticsearch.core.query.CriteriaQuery;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Component;

/**
 * 
 * @description Es
 * component注解，也可以考虑service注解
 * @author guokai
 * @date 2018年8月26日
 * @version v1.0
 */
@Component
public class EsMyServiceImpl implements EsMyService{

	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;

	@Override
	public void test() {
		
		
		
		new NativeSearchQueryBuilder().withQuery(matchAllQuery()).withFilter(boolQuery()).build();
		
		//elasticsearchTemplate.queryForPage(criteriaQuery, clazz);
		
		CriteriaQuery geoLocationCriteriaQuery = new CriteriaQuery(
                new Criteria("location").within(new GeoPoint(45.7806d, 3.0875d), "20km"));
		//List<AuthorMarkerEntity> geoAuthorsForGeoCriteria = elasticsearchTemplate.queryForList(geoLocationCriteriaQuery, AuthorMarkerEntity.class);
		
		
	}

	@Override
	public void scan() {
		//为什么官网上有这个方法，本地api没有找到，回头把pom换下看看
	}
	
	
	
	
	
	
}
