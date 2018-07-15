package com.monster.auth;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.monster.auth.dao")
public class SpringBoot2AuthApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBoot2AuthApplication.class, args);
	}
}
