package com.monster.auth.remote;


import java.time.Duration;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * 
 * @description 单元测试
 * @author guokai
 * @date 2018年7月23日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RemoteDemoServiceTest {

	@Autowired
	private TestRestTemplate restTemplate;
	
/*	@TestConfiguration
	static class Config {

		@Bean
		public RestTemplateBuilder restTemplateBuilder() {
			return new RestTemplateBuilder().setConnectTimeout(Duration.ofSeconds(1))
					.setReadTimeout(Duration.ofSeconds(1));
		}

	}*/
	
	@Test
	public void test() {
		
	}
}
