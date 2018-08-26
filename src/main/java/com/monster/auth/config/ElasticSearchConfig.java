package com.monster.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;

/**
 * 
 * @description ElasticsearchTemplate
 * elasticsearch是一个单词，不要把它分开了
 * @author guokai
 * @date 2018年8月26日
 * @version v1.0
 */
@Configuration
@EnableElasticsearchRepositories(basePackages="com.monster.auth.elasticsearch")
public class ElasticSearchConfig {

	public ElasticsearchOperations elasticsearchTemplate() {
		
		//return new ElasticsearchTemplate(nodebuilder)
		return null;
	}
	
}
