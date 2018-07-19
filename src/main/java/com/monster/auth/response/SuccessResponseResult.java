package com.monster.auth.response;

import java.time.LocalDateTime;
import java.util.Map;


/**
 * 
 * @description 用于统一定义返回给客户端的成功响应结果
 * @author guokai
 * @date 2018年7月8日
 * @version v1.0
 */
public class SuccessResponseResult extends CommonResponseResult{

	/**
	 * 用户请求失败时候返回的错误信息，用map定义数据结构方便转成json
	 */
	private Map<String,Object> data;

	public SuccessResponseResult() {
		super();
	}

	public SuccessResponseResult(String result, Integer code, String msg, String subMsg, LocalDateTime timestamp) {
		super(result, code, msg, subMsg, timestamp);
	}
	
	public SuccessResponseResult(String result, Integer code, String msg, String subMsg, LocalDateTime timestamp,Map<String, Object> data) {
		super(result, code, msg, subMsg, timestamp);
		this.data = data;
	}


	public Map<String, Object> getData() {
		return data;
	}

	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "SuccessResponseResult [data=" + data + ", toString()=" + super.toString() + "]";
	}
	
	
	
	

	
	

}
