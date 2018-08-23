package com.monster.auth.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.monster.auth.response.CommonResponseResult;


/**
 * 
 * 参考资料阮一峰博客、Oauth2官网、developer.okta.com
 * 对于几种授权模式的获取token的方法可以写在一个方法里面，每次传参数不一样，仿照okta
 * 也可以写在不同方法里面，方便自己理解
 * 
 * @description 主要用于oauth2相关认证授权 按照oauth2官网最新的6种授权模式
 *              client_id和client_secret通过web页面申请
 *              client_id和client_secret就是国内喜欢用的app_id和app_secret
 *              
 *              
 *              
 *  对于密码、客户端凭证、刷新令牌流来说，调用/token/是唯一步骤，对于授权码流，调用/token/是流程的第二步
 * 
 * @author guokai
 * @date 2018年7月10日
 * @version v1.0
 */
@RestController
@RequestMapping("/oauth2/token/")
public class TokenController {

	/**
	 * 
	 * @description 授权码模式获取token
	 * @param grantType   此处为固定值authorization_code
	 * @param code    /oauth2/authorize/authorization-code中返回给用户的code
	 * @param redirectUri  获取access_token的uri,此接口会将access_token参数重定向至此redirect_uri,要求此uri和上一步authorrizationCodeType中的uri要一致
	 * @param clientId		web页面用户获取的类似app_id参数
	 * @param clientSecret    这一步有的地方不需要，但是微信公众号需要，是否需要这个参数还需要仔细考虑，防止风险
	 * @return
	 */
	@GetMapping("/authorization-code")
	public CommonResponseResult authorizationCodeGrantType(
			@RequestParam(value = "grant_type") String grantType,
			@RequestParam(value = "code") String code, @RequestParam(value = "redirect_uri") String redirectUri,
			@RequestParam(value = "client_id") String clientId,
			@RequestParam(value = "client_secret") String clientSecret) {

		return null;
	}

	/**
	 * 
	 * @description oauth2的简化模式，相比授权码模式去掉了code这一步，用浏览器进行交互，后台需要发送redirect（302httpstatus）和location头
	 * @return
	 */
	@GetMapping("/implicit")
	public CommonResponseResult implicitGrantType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的密码模式 也就是用app_id和app_secret直接调用
	 * @return
	 */
	@GetMapping("/password")
	public CommonResponseResult passwordGrantType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的Client Credentials模式
	 *  TODO 有待进一步研究
	 * @return
	 */
	@GetMapping("/client-crddentials")
	public CommonResponseResult clientCredentialsGrantType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的Device Code模式
	 *  TODO 有待进一步研究
	 * @return
	 */
	@GetMapping("/device-code")
	public CommonResponseResult deviceCodeGrantType() {

		return null;
	}

	/**
	 * 
	 * @description oauth2的Refresh Token模式
	 * @return
	 */
	@GetMapping("/refresh-token")
	public CommonResponseResult refreshTokenGrantType() {

		return null;
	}

}
