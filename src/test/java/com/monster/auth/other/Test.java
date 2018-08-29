package com.monster.auth.other;

import java.util.UUID;

import com.alibaba.fastjson.JSON;
import com.monster.auth.pojo.po.RbacRole;

public class Test {
	
	public static void main(String[] args) {
		
		String str=UUID.randomUUID().toString();
		System.out.println(str);
		System.out.println(str.length());
		
		String str2=str.replaceAll("-", "");
		System.out.println(str2);
		System.out.println(str2.length());
		
		JSON.parseObject("");
		
	}

}
