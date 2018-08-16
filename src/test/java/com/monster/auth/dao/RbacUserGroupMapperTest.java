package com.monster.auth.dao;

import org.junit.BeforeClass;
import org.junit.Test;

public class RbacUserGroupMapperTest {
	
	@BeforeClass
	public static void init() {
		//junit单元测试往数据库插入的数据尽量都有明显的junit:test测试标识，虽然大部分时间按照正常流程都会删除，
		//但是为了避免单元测试异常导致数据异常，加上明显的标识方便定位错误
		
		//logger.debug("junit:init:rbacGroup--->{}",rbacGroup);
	}
	
	@Test
	public void test01InsertSelective() {
		//logger.debug("junit:test01InsertSelective result--->{}",ret);
	}
	
	@Test
	public void test02SelectByPrimaryKey() {
		//logger.debug("junit:test02SelectByPrimaryKey result--->{}",record);
	}
	
	@Test
	public void test03UpdateByPrimaryKeySelective() {
		
	}
	
	@Test
	public void test04UpdateByPrimaryKey() {
		
	}
	
	@Test
	public void test05DeleteByPrimaryKey() {
		
	}
	
	@Test
	public void test06Insert() {
		
	}
	
	@Test
	public void test07SelectByPrimaryKey() {
		
	}
	
	@Test
	public void test08DeleteByPrimaryKey() {
		
	}


}
