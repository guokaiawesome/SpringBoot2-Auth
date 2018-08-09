package com.monster.auth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import com.monster.auth.interceptor.AccessTokenInterceptor;

/**
 * 
 * @description web mvc的一些基本配置，比如跨域访问，filter，拦截器等
 * 新版本中将WebMvcConfigurerAdapter移除了
 * WebMvcConfigurer这个接口中所有的方法都提供了默认实现
 * @author guokai
 * @date 2018年8月2日
 * @version v1.0
 */
@Configuration
@EnableWebMvc
public class WebMvConfig implements WebMvcConfigurer{

	/**
	 * 添加自定义拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		//另外一种WebRequestInterceptor
		//registry.addWebRequestInterceptor(interceptor);
		//可以添加多个拦截器
		registry.addInterceptor(new AccessTokenInterceptor()).addPathPatterns("/**").excludePathPatterns("/admin/**");
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
	 * 添加自定义Cors策略，关于Cors也通过通过注解，还可以通过内置CorsFilter
	 * 以下写法参照Spring FrameWork5.1.0写法
	 */
	@Override
	public void addCorsMappings(CorsRegistry registry) {
		
		//这里如果有必要可以读数据库，从数据库中读出允许访问的域名
		String[] allow= {"http://172.0.0.1","developer.monster.com"};
		
		//以下来自官方写法
/*		registry.addMapping("/api/**")
		.allowedOrigins(allow)
		.allowedMethods("PUT","DELETE")
		.allowedHeaders("a","b")
		.exposedHeaders("d")
		.allowCredentials(true)
		.maxAge(3600);*/
		
		//关于时间，官方英文意思是客户端可以缓存的上一次响应的时间
		//关于Credential，官方英文意思是是否支持用户证书，还是不是很理解
		registry.addMapping("/api/**")
		.allowedOrigins(allow)
		.allowedMethods("*")
		.allowedHeaders("*")
		.allowCredentials(true)
		.maxAge(3600);
		
		// Add more mappings...
		
		WebMvcConfigurer.super.addCorsMappings(registry);
	}

	
	
	
}
