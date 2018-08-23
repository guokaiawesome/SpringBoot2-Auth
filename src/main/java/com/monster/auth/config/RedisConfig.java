package com.monster.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisSentinelConfiguration;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettucePoolingClientConfiguration;
import org.springframework.data.redis.core.RedisKeyValueTemplate;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@AutoConfigureAfter(RedisAutoConfiguration.class)
public class RedisConfig {
	
	
	@Autowired
	LettuceRedisConfig lettuceRedisConfig;
	
/*	@Bean(name="connectionFactory")
	public LettuceConnectionFactory lettuceConnectionFactory() {
		
		//standlone
		//return new LettuceConnectionFactory(new RedisStandaloneConfiguration("", 6379));
		
		RedisStandaloneConfiguration standloneConfig=new RedisStandaloneConfiguration();
		
		//LettucePoolingClientConfiguration poolConfig=new DefaultLettucePoolingClientConfiguration();
		 
		 //注意这里LettucePoolingClientConfiguration这个接口继承了LettuceClientConfiguration这个接口，老的LettucePool被废弃了
		 //所以如果要用pooling的话，可以使用包含LettuceClientConfiguration这个的构造器
		  * 
		  //关于这个lettuce 连接工厂这个一定要多看源码，看清里面的依赖装配关系
		
		//sentinel高可用
		RedisSentinelConfiguration sentinelConfig = new RedisSentinelConfiguration();
		sentinelConfig.master("mymaster")
		.sentinel("127.0.0.1", 26379)
		.sentinel("127.0.0.1", 26380);
		
		return new LettuceConnectionFactory(sentinelConfig);
	}*/

	@Bean(name="stringRedisTemplate")
	public StringRedisTemplate getStringRedisTemplate(LettuceConnectionFactory connectionFactory) {
		
		StringRedisTemplate template =new StringRedisTemplate();
		//这里debug一下connectionFactory里面的值，看看是否从配置文件中自动装配了
		//看看不指定sentinel情况下connectionFactory究竟是自动装配了RedisStandaloneConfiguration这个还是LettucePoolingClientConfiguration
		
		//这里如果自动从配置文件中装配失败的话，写一个LettuceConnectionFactory的bean从配置文件中读入参数配置
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	@Bean(name="objectRedisTemplate")
	public RedisTemplate<String, Object> getObjectRedisTemplate(LettuceConnectionFactory connectionFactory){
		RedisTemplate<String, Object> template = new RedisTemplate<>();
		template.setConnectionFactory(connectionFactory);
		return template;
	}
	
	
	
	
}
