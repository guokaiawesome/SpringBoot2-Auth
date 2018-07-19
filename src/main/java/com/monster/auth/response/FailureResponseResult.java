package com.monster.auth.response;

import java.time.LocalDateTime;
import java.util.Map;


/**
 * 
 * @description 用于统一定义返回给客户端的失败响应结果
 * @author guokai
 * @date 2018年7月8日
 * @version v1.0
 */
public class FailureResponseResult extends CommonResponseResult{

	/**
	 * 用户请求不成功时候返回的错误信息,用map定义数据结构方便转成json
	 */
	private Map<String,Object> error;
	

	public FailureResponseResult() {
		super();
	}

	public FailureResponseResult(String result, Integer code, String msg, String subMsg, LocalDateTime timestamp) {
		super(result, code, msg, subMsg, timestamp);
	}

	public FailureResponseResult(String result, Integer code, String msg, String subMsg, LocalDateTime timestamp,Map<String, Object> error) {
		super(result, code, msg, subMsg, timestamp);
		this.error = error;
	}


	public Map<String, Object> getError() {
		return error;
	}


	public void setError(Map<String, Object> error) {
		this.error = error;
	}


	@Override
	public String toString() {
		return "FailureResponseResult [error=" + error + ", toString()=" + super.toString() + "]";
	}



}
