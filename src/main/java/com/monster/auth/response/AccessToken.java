package com.monster.auth.response;

/**
 * 
 * @description oauth2授权时候给授权成功给用户返回的token相关信息
 * @author guokai
 * @date 2018年7月10日
 * @version v1.0
 */
public class AccessToken {
	
	/**
	 * 访问token
	 */
	private String accessToken;
	
	/**
	 * token类型，包括：bearer和
	 */
	private String tokenType;
	
	/**
	 * 失效时间
	 */
	private Integer expireIn;
	
	/**
	 * 刷新token，可以全程无需人干预
	 */
	private String refreshToken;
	
	/**
	 *  权限范围
	 */
	private String scope;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}

	public Integer getExpireIn() {
		return expireIn;
	}

	public void setExpireIn(Integer expireIn) {
		this.expireIn = expireIn;
	}

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	@Override
	public String toString() {
		return "AccessToken [accessToken=" + accessToken + ", tokenType=" + tokenType + ", expireIn=" + expireIn
				+ ", refreshToken=" + refreshToken + ", scope=" + scope + "]";
	}
	
	

}
