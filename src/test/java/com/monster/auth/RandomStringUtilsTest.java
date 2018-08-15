package com.monster.auth;

import org.apache.commons.lang3.RandomStringUtils;

/**
 * 
 * @description 工具包中的RandomStringUtils随机字符串测试
 * @author guokai
 * @date 2018年8月13日
 * @version v1.0
 */
public class RandomStringUtilsTest {
	public static void main(String[] args) {
		//从32-126的ascii字符  看源码
		RandomStringUtils.randomAscii(32);
		
		//看源码   为33-125的字符
		RandomStringUtils.randomGraph(32);
	}

}
