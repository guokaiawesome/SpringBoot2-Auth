package com.monster.auth.exception.custom;
/**
 * 
 * @description 自定义异常
 * 用于Service层中*.Mapper找不到对应资源抛出此类型异常
 * @author guokai
 * @date 2018年8月6日
 * @version v1.0
 */
public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 8229314092927678560L;

	public ResourceNotFoundException() {
		super();
	}
	
	public ResourceNotFoundException(String message) {
		super(message);
	}
	
	public ResourceNotFoundException(String message, Throwable cause) {
		 super(message, cause);
	}
	
}
