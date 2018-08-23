package com.monster.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * 
 * @description 写法参考SpringBoot官方文档
 * 也可以参考Spring Data Redis
 * 可以使用Jedis也可以使用Lettuce
 * @author guokai
 * @date 2018年8月20日
 * @version v1.0
 */
@Component
public class RedisConfigBak {
	
	private StringRedisTemplate  stringRedisTemplate;
	
	//private RedisTemplate<String,Object> redisTemplate;
	
	
	@Autowired
	public RedisConfigBak(StringRedisTemplate  stringRedisTemplate) {
		this.stringRedisTemplate=stringRedisTemplate;
	}
	

}
