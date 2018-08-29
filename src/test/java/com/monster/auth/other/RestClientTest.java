package com.monster.auth.other;

import java.io.IOException;
import java.util.Collections;
import java.util.Map;

import org.apache.http.Header;
import org.apache.http.HttpHost;
import org.apache.http.client.config.RequestConfig.Builder;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.message.BasicHeader;
import org.apache.http.nio.entity.NStringEntity;
import org.elasticsearch.client.HttpAsyncResponseConsumerFactory;
import org.elasticsearch.client.Response;
import org.elasticsearch.client.ResponseListener;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.rest.action.RestResponseListener;

/**
 * 
 * @description Es底层JavaAPI
 * @author guokai
 * @date 2018年8月27日
 * @version v1.0
 */
public class RestClientTest {
	
	public static void main(String[] args) throws IOException {
		
		//学习一些别人的官方写法，这个底层用的也是httpclient4.5.5，学习一下连接池池写法
		//不需要显式执行close方法
		RestClient restClient1=RestClient.builder(new HttpHost("localhost",9200,"http"),new HttpHost("localhost",9201,"http")).build();
		
		
		RestClientBuilder builder=RestClient.builder(new HttpHost("localhost",9200,"http"));
		//公用的头
		Header[] defaultHeaders=new Header[]{new BasicHeader("header", "value")}; 
		builder.setDefaultHeaders(defaultHeaders);
		builder.setMaxRetryTimeoutMillis(10000);
		
		//节点故障时候的通知
		builder.setFailureListener(new RestClient.FailureListener() {

			@Override
			public void onFailure(HttpHost host) {
				// TODO 
				super.onFailure(host);
			}
			
		});
		
		builder.setRequestConfigCallback(new RestClientBuilder.RequestConfigCallback() {
			
			@Override
			public Builder customizeRequestConfig(Builder requestConfigBuilder) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		builder.setHttpClientConfigCallback(new RestClientBuilder.HttpClientConfigCallback() {
			
			@Override
			public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
				// TODO Auto-generated method stub
				return null;
			}
		});
		
		
		Response response=restClient1.performRequest("GET", "/");
		
		Map<String, String> params=Collections.singletonMap("key", "value");
		restClient1.performRequest("GET", "/", params);
		
		//application/json格式传递数据  也就是@RequestBody
		Map<String,String> params1=Collections.emptyMap();
		String jsonData="{\"user\":\"a\",\"message\":\"b\"}";
		NStringEntity entity=new NStringEntity(jsonData, ContentType.APPLICATION_JSON);
		restClient1.performRequest("GET", "/", params1, entity);
		
		restClient1.performRequest("GET", "/posts/doc/1", params1, entity);
		
		HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory factory=new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(30*1024*1024);
		restClient1.performRequest("GET", "/", params1, entity, factory);
		
		
		ResponseListener responseListener=new ResponseListener() {
			
			@Override
			public void onSuccess(Response response) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(Exception exception) {
				// TODO Auto-generated method stub
				
			}
		};
		
		
		//异步调用
		restClient1.performRequestAsync("GET", "/", responseListener);
		
		
		
	}

}
