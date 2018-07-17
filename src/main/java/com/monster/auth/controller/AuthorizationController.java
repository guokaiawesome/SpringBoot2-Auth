package com.monster.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.auth.response.CommonResponseResult;


/**
 * 
 * @description 主要用于oauth2相关认证授权 按照oauth2官网最新的6种授权模式
 *              client_id和client_secret通过web页面申请
 *              client_id和client_secret就是国内喜欢用的app_id和app_secret
 * 
 * @author guokai
 * @date 2018年7月10日
 * @version v1.0
 */
@RestController
@RequestMapping("/oauth2/")
public class AuthorizationController {

	/**
	 * 
	 * @description 参考oauth2国外网站编写，和国内微信获取token稍有不同，微信获取token不需要redirect_uri参数
	 * @param grant_type
	 *            固定值 authorization_code
	 * @param code
	 *            上一步authorrizationCodeType方法中给用户返回的code
	 * @param redirect_uri
	 *            获取access_token的uri,此接口会将access_token参数重定向至此redirect_uri,要求此uri和上一步authorrizationCodeType中的uri要一致
	 * @param client_id
	 *            web页面用户获取的类似app_id参数
	 * @param client_secret
	 *            web页面用户获取的类似app_secret参数
	 * @return access_token相关 {@link AccessToken}
	 */
	public CommonResponseResult exchangeToken(
			@RequestParam(value = "grant_type", defaultValue = "authorization_code") String grantType,
			@RequestParam(value = "code") String code, @RequestParam(value = "redirect_uri") String redirectUri,
			@RequestParam(value = "client_id") String clientId,
			@RequestParam(value = "client_secret") String clientSecret) {

		return null;
	}

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
	@GetMapping("/grant/authorization-code/")
	public CommonResponseResult authorrizationCodeType(@RequestParam(value = "response_type") String responseType,
			@RequestParam(value = "client_id") String clientId,
			@RequestParam(value = "redirect_uri") String redirectUri, @RequestParam(value = "scope") String scope,
			@RequestParam(value = "state") String state) {

		return null;
	}

	/**
	 * 
	 * @description oauth2的简化模式 简化模式，相比授权码模式去掉了
	 * @return
	 */
	public CommonResponseResult implicitType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的密码模式 也就是用app_id和app_secret直接调用
	 * @return
	 */
	public CommonResponseResult passwordType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的Client Credentials模式 TODO 有待进一步研究
	 * @return
	 */
	public CommonResponseResult clientCredentialsCodeType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的Device Code模式 TODO 有待进一步研究
	 * @return
	 */
	public CommonResponseResult deviceCodeType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的Refresh Token模式
	 * @return
	 */
	public CommonResponseResult refreshTokenType() {

		return null;
	}

}
