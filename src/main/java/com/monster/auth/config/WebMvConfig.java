package com.monster.auth.config;

import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 
 * @description web mvc的一些基本配置，比如跨域访问，filter，拦截器等
 * 新版本中将WebMvcConfigurerAdapter移除了
 * WebMvcConfigurer这个接口中所有的方法都提供了默认实现
 * @author guokai
 * @date 2018年8月2日
 * @version v1.0
 */
public class WebMvConfig implements WebMvcConfigurer{

	/**
	 * 添加自定义拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addInterceptors(registry);
	}

	/**
	 * 添加自定义资源映射，比如静态资源映射等
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		//debug一下，看看这个方法和前面一个方法的执行顺序
		//这里还需要实验一下，看看合理添加了之后前面的拦截器是否需要排除掉这两个pattern
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
		registry.addResourceHandler("/templates/**").addResourceLocations("classpath:/templates/");
		WebMvcConfigurer.super.addResourceHandlers(registry);
	}

	/**
	 * 添加自定义Cors策略，关于Cors也通过通过注解
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		// TODO Auto-generated method stub
		WebMvcConfigurer.super.addCorsMappings(registry);
	}

	
	
	
}
