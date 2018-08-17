package com.monster.auth.dao;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.monster.auth.pojo.po.RbacResource;

/**
 * 
 * @description 权限控制资源(接口)相关单元测试
 * @author guokai
 * @date 2018年8月17日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacResourceMapperTest {
	
	/**
	 * 这里需要注意一下，getLogger的时候用类名，这里打印不出日志，用字符串是可以打印的，
	 * 这里字符串可以是logback配置的，也可以是随便写的
	 */
	private static final Logger logger=LoggerFactory.getLogger("junit-test");
	
	@Autowired
	private RbacResourceMapper rbacResourceMapper;
	
	private static RbacResource rbacResource=new RbacResource();
	
	
	@BeforeClass
	public static void init() {
		//junit单元测试往数据库插入的数据尽量都有明显的junit:test测试标识，虽然大部分时间按照正常流程都会删除，
		//但是为了避免单元测试异常导致数据异常，加上明显的标识方便定位错误
		rbacResource.setCategory("");
		
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
