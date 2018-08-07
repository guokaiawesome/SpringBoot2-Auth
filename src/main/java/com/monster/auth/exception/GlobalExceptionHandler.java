package com.monster.auth.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.monster.auth.exception.custom.ResourceNotFoundException;
import com.monster.auth.response.CommonResponseResult;
import com.monster.auth.response.FailureResponseResult;

/**
 * 
 * @description 全局异常捕获
 * 这里采用@RestControllerAdvice，也可以采用@ControllerAdvice
 * SpringBoot默认异常处理机制详情见BasicErrorController类
 * @author guokai
 * @date 2018年8月6日
 * @version v1.0
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	private static final Logger logger=LoggerFactory.getLogger(GlobalExceptionHandler.class);
	
	/**
	 * 
	 * @description 对controller的入参进行绑定的一些特殊处理
	 * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder) {
		//对controller的绑定的入参进行trim处理
		binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
	}
	
	
	/**
	 * 
	 * @description 处理特定类型异常
	 * 用于处理Service层抛出的资源未找到异常（此类异常controller中不捕获）
	 * 这个处理方法的入参里面还可以带上HTTPServletRequest
	 * @return
	 */
	@ExceptionHandler(ResourceNotFoundException.class)
	public FailureResponseResult  handleResourceNotFoundException(ResourceNotFoundException exception,HttpServletRequest request) {
		FailureResponseResult result =new FailureResponseResult();
		
		return result;
	} 
	
	/**
	 * 
	 * @description 异常处理
	 * 如果上面的所有异常捕获器都没有处理，则由此处理器统一处理
	 * @param exception
	 * @param request
	 * @return
	 */
	@ExceptionHandler(Exception.class)
	public FailureResponseResult  handleOtherException(Exception exception,HttpServletRequest request) {
		FailureResponseResult result =new FailureResponseResult();
		
		return result;
	} 
	
}
