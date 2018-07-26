package com.monster.auth.other;

import com.monster.auth.pojo.po.RbacRole;

public class Test {
	
	private RbacRole role=new RbacRole();
	
	public String get1() {
		role.setName("abc");
		return role.toString();
	}
	
	public String get2() {
		role.setName("cde");
		return role.toString();
	}

}
