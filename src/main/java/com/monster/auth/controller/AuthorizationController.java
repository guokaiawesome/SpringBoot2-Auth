package com.monster.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.auth.response.CommonResponseResult;


/**
 * 
 * @description 主要用于单点登录和授权信息
 * 此种模式一般必须必填配置和提供redirect_uri
 * 
 * @author guokai
 * @date 2018年7月10日
 * @version v1.0
 */
@RestController
@RequestMapping("/oauth2/authorize")
public class AuthorizationController {
	

	/**
	 * 
	 * @description oauth2的授权码模式 功能最完整，流程最严密，一般用于授权登录，比如微信授权登录
	 * 
	 * @param response_type
	 *            授权类型，必填项，此处固定为code
	 * @param client_id
	 *            客户端Id，必填项
	 * @param redirect_uri
	 *            重定向URI，可选项
	 * @param scope
	 *            申请的权限范围，可选项
	 * @param state
	 *            为了防范CSRF安全漏洞，建议用户带上此参数，服务器会原封不动的返回这个值
	 * @return 给用户返回code和state参数
	 *         code作为换取access_token的票据，每次用户授权带上的code不一样，code只能使用一次，5分钟未使用自动过期
	 *         state作为安全原样措施返回给用户
	 */
	@GetMapping("/authorization-code/")
	public CommonResponseResult authorrizationCodeType(@RequestParam(value = "response_type") String responseType,
			@RequestParam(value = "client_id") String clientId,
			@RequestParam(value = "redirect_uri") String redirectUri, @RequestParam(value = "scope") String scope,
			@RequestParam(value = "state") String state) {

		return null;
	}


}
