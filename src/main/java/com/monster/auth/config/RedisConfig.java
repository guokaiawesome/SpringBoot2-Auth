package com.monster.auth.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class RedisConfig {
	
	
	@Bean(name="stringRedisTemplate")
	public StringRedisTemplate getStringRedisTemplate() {
		
		return null;
	}
	
	@Bean(name="objectRedisTemplate")
	public RedisTemplate<String,Object> getObjectRedisTemplate(){
		
		return null;
	}

}
