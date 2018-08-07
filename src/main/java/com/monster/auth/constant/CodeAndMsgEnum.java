package com.monster.auth.constant;

import com.fasterxml.jackson.annotation.JsonFormat;

/**
 * 
 * @description code和msg成对出现的枚举
 * 所有的code也可以全部写成200开头后面接上HttpStatus对应的状态，比如200401、200404、200500这种
 * @author guokai
 * @date 2018年7月8日
 * @version v1.0
 */
@JsonFormat(shape=JsonFormat.Shape.OBJECT)
public enum CodeAndMsgEnum {
	
	/**
	 * 用在用户请求数据CRUD成功时候返回
	 */
	OK(20000,"请求成功"),
	/**
	 * 用在controller里面参数校验（不涉及数据库交互的校验）时候返回
	 */
	CLIENT_PARAMETER_ERROR(40000,"客户端参数错误"),
	/**
	 * 用在全局异常捕获和非运行时异常捕获时候返回
	 */
	SERVER_INTERNAL_ERROR(50000,"服务端程序错误"),
	/**
	 * 用在全局异常捕获时候返回，数据库是否存在这条记录的校验一律不准放在controller里面，放在service里面扔出自定义异常
	 */
	RESOUCE_NOT_FOUND(60000,"未查询到对应结果"),
	/**
	 * 用在filter里面认证和授权时候返回，或者用于api网关层返回
	 */
	AUTH_ERROR(70000,"授权错误"),
	/**
	 * 用在filter里面认证和授权时候返回，或者用于api网关层返回
	 */
	INVOKE_FREQUENCY_ULTRALIMIT(80000,"接口调用频率超限");
	
	
	/**
	 * 表明本次请求结果状态码，参照HTTP状态码设计
	 */
	private int code;
	
	/**
	 * 表明本次请求结果概要信息
	 */
	private String msg;

	private CodeAndMsgEnum( int code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public int getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
	

}
