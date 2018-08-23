package com.monster.auth.interceptor;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.monster.auth.constant.CodeAndMsgEnum;
import com.monster.auth.constant.CommonConstant;
import com.monster.auth.constant.RedisKeyPrefix;
import com.monster.auth.response.FailureResponseResult;

/**
 * 
 * @description access_token拦截器
 * 拦截器可以实现HandlerInterceptor，也可以继承HandlerInterceptorAdapter
 * @author guokai
 * @date 2018年7月17日
 * @version v1.0
 */
public class AccessTokenInterceptor implements HandlerInterceptor{
	
	@Autowired
	StringRedisTemplate stringRedisTemplate;
	
	RedisTemplate<String, Object> objectRedisTemplate;
	
	//看下这下面post和complete执行方法的先后顺序

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		//访问access_token
		String accessToken=request.getHeader("access_token");
		String clientId=request.getHeader("client_id");
		//用access_token去redis校验用户信息，redis查询不到的话去查mysql，redis最好设置超时时间
		//如果用access_token去redis查找不到的话直接提示token不存在或者已经过期
		//如果想提示粒度更细的话可以db:access_token的key(永久不失效)找是否存在提示access_token是过期还是不存在

		Map<String, Object> error = new HashMap<>();
		Map<String, Object> errorParam = new HashMap<>();
		
		if(StringUtils.isBlank(accessToken)) {
			FailureResponseResult failRet = new FailureResponseResult(CommonConstant.FAILURE,
					CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getCode(), CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getMsg(),
					CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getMsg(), LocalDateTime.now());
			failRet.setSubMsg("access_token不存在或者已经失效");
			errorParam.put("access_token", accessToken);
			error.put("error_param", errorParam);
			failRet.setError(error);
			ObjectMapper om=new ObjectMapper();
			String s=om.writeValueAsString(failRet);
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-type", "text/plain; charset=utf-8");
			response.getWriter().write(s);
			
			return false;
		}
		
		//加一个accessToken不符合某种正则表达式的话直接返回错误值，避免查询redis
		
		
		//key的规则：业务线:功能:clientid值:accesstoken值
		Integer userId=(Integer)objectRedisTemplate.opsForValue().get(RedisKeyPrefix.COMMON_TOKEN_ACCESS.getKey()+accessToken);
		if(userId==null) {
			FailureResponseResult failRet = new FailureResponseResult(CommonConstant.FAILURE,
					CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getCode(), CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getMsg(),
					CodeAndMsgEnum.CLIENT_PARAMETER_ERROR.getMsg(), LocalDateTime.now());
			failRet.setSubMsg("access_token不存在或者已经失效");
			errorParam.put("access_token", accessToken);
			error.put("error_param", errorParam);
			failRet.setError(error);
			
			ObjectMapper om=new ObjectMapper();
			String s=om.writeValueAsString(failRet);
			response.setCharacterEncoding("UTF-8");
			response.setHeader("content-type", "text/plain; charset=utf-8");
			response.getWriter().write(s);

			
			return false;
		}
		
		request.setAttribute("userId", userId);
		//logger.info("拦截器往request里面放入参数userId="+userId);
		return true;
		
		//将错误信息写入response  return false
		//return HandlerInterceptor.super.preHandle(request, response, handler);
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
	}

	
	
}
