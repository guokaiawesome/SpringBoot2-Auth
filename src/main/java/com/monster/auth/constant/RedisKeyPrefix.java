package com.monster.auth.constant;

public enum RedisKeyPrefix {
	
	COMMON_TOKEN_ACCESS("common_accesstoken:",7200,"seconds","common accessToken,失效期2小时"),
	COMMON_TOKEN_REFRESH("common_refreshtoken:",30*24*60*60,"seconds","common refreshToken,失效时间30天"),
	OAUTH_AUTH_CODE("oauth_code:",60,"seconds","oauth code"),
	OAUTH_TOKEN_ACCESS("oauth_accesstoken:",7200,"seconds","oauth accessToken,失效期2小时"),
	OAUTH_TOKEN_REFRESH("oauth_refreshtoken:",30*24*60*60,"seconds","oauth refreshToken,失效时间30天");

	private String key;
	
	private long expire;
	
	private String timeUnit;
	
	private String desc;

	private RedisKeyPrefix(String key, long expire, String timeUnit, String desc) {
		this.key = key;
		this.expire = expire;
		this.timeUnit = timeUnit;
		this.desc = desc;
	}

	public String getKey() {
		return key;
	}

	public long getExpire() {
		return expire;
	}

	public String getTimeUnit() {
		return timeUnit;
	}

	public String getDesc() {
		return desc;
	}

}
