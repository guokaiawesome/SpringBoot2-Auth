package com.monster.auth.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @description 调用频率限制
 * 包括每分钟限制频率，每天调用次数限制（根据客户等级不同），否则如果用户恶意频繁更新和查询操作造成压力过大
 * 针对恶意调用用户，比如直接输入错入token，用户名密码这种，检测单个ip调用次数，达到一定次数直接进入ip黑名单
 * ip黑名单里面的用户不进入接口直接返回，ip黑名单最好采用Linux定时任务根据日志文件统计插入数据库，不必实时统计
 * Request里面要想获取真实ip，需要在NGINX端进行配置
 * @author guokai
 * @date 2018年8月9日
 * @version v1.0
 */
public class CallTimesInterceptor implements HandlerInterceptor{

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return HandlerInterceptor.super.preHandle(request, response, handler);
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
