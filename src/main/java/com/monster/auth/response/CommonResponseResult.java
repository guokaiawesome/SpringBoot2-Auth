package com.monster.auth.response;

import java.time.LocalDateTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;

/**
 * 
 * @description 用于统一定义返回给客户端的公共响应结果
 * @author guokai
 * @date 2018年7月8日
 * @version v1.0
 */
public class CommonResponseResult {
	

	/**
	 * 本次请求的结果，只能有两个值，success或者failure，见常量{@link CommonConstant}}
	 */
	private String result;
	
	/**
	 * 请求响应码,{@link CodeAndMsgEnum}
	 */
	private Integer code;
	
	/**
	 * 请求响应概要信息，{@link CodeAndMsgEnum}
	 */
	private String msg;
	
	/**
	 * 表明本次请求结果详细信息
	 */
	@JsonProperty("sub_msg")
	private String subMsg;
	
	/**
	 * 服务器响应的时间戳
	 *  JsonFormat一般用于出参绑定
	 * 看下jdk8，如果有更好的日期类型的话替换掉
	 */
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private  LocalDateTime timestamp;

	
	public CommonResponseResult() {
		super();
	}


	public CommonResponseResult(String result, Integer code, String msg, String subMsg, LocalDateTime timestamp) {
		super();
		this.result = result;
		this.code = code;
		this.msg = msg;
		this.subMsg = subMsg;
		this.timestamp = timestamp;
	}


	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getMsg() {
		return msg;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}


	public String getSubMsg() {
		return subMsg;
	}


	public void setSubMsg(String subMsg) {
		this.subMsg = subMsg;
	}




	public LocalDateTime getTimestamp() {
		return timestamp;
	}


	public void setTimestamp(LocalDateTime timestamp) {
		this.timestamp = timestamp;
	}


	@Override
	public String toString() {
		return "CommonResponseResult [result=" + result + ", code=" + code + ", msg=" + msg + ", subMsg=" + subMsg
				+ ", timestamp=" + timestamp + "]";
	}

	

	
	


	

	

}
