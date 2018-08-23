package com.monster.auth.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("monster.redis")
public class LettuceRedisConfig {
	
	

}
