package com.monster.auth.exception.custom;

import java.util.Map;

/**
 * 
 * @description 人为抛出的参数错误异常，可以继承Throwable，也可以继承RuntimeException
 * @author guokai
 * @date 2018年8月29日
 * @version v1.0
 */
public class ClientParameterErrorException extends RuntimeException{

	private static final long serialVersionUID = 8558391475292431796L;
	
	private Map<String,Object> error;

	public ClientParameterErrorException(String message, Throwable cause,Map<String,Object> error) {
		super(message, cause);
		this.error=error;
	}
	
	public ClientParameterErrorException(String message, Throwable cause) {
		super(message, cause);
	}

	public ClientParameterErrorException(String message) {
		super(message);
	}
	
	public ClientParameterErrorException(String message,Map<String,Object> error) {
		super(message);
		this.error=error;
	}

/*	public Map<String, Object> getError() {
		return error;
	}*/


	
	
	
	
	

}
