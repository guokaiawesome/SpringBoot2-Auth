package com.monster.auth.dao;

import static org.hamcrest.CoreMatchers.*;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
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

import com.monster.auth.pojo.po.RbacMenu;

/**
 * 
 * @description 权限控制菜单相关测试
 * @author guokai
 * @date 2018年8月17日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacMenuMapperTest {
	
	/**
	 * 这里需要注意一下，getLogger的时候用类名，这里打印不出日志，用字符串是可以打印的，
	 * 这里字符串可以是logback配置的，也可以是随便写的
	 */
	private static final Logger logger=LoggerFactory.getLogger("junit-test");
	
	@Autowired
	private RbacMenuMapper rbacMenuMapper;
	
	private static RbacMenu rbacMenu=new RbacMenu();
	
	@BeforeClass
	public static void init() {
		//junit单元测试往数据库插入的数据尽量都有明显的junit:test测试标识，虽然大部分时间按照正常流程都会删除，
		//但是为了避免单元测试异常导致数据异常，加上明显的标识方便定位错误
		rbacMenu.setName("junit:test-"+RandomStringUtils.randomAlphabetic(6));
		rbacMenu.setUpdatePersonId(99999L);
		rbacMenu.setGmtCreate(LocalDateTime.now());
		rbacMenu.setGmtModified(LocalDateTime.now());
		logger.debug("junit:init:rbacMenu--->{}",rbacMenu);
	}
	
	@Test
	public void test01InsertSelective() {
		int ret=rbacMenuMapper.insertSelective(rbacMenu);
		logger.debug("junit:test01InsertSelective result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test02SelectByPrimaryKey() {
		RbacMenu record=rbacMenuMapper.selectByPrimaryKey(rbacMenu.getId());
		logger.debug("junit:test02SelectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null",record);
	}
	
	@Test
	public void test03UpdateByPrimaryKeySelective() {
		rbacMenu.setWhetherDeleted((byte)1);
		int ret=rbacMenuMapper.updateByPrimaryKeySelective(rbacMenu);
		logger.debug("junit:test03UpdateByPrimaryKeySelective result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test04UpdateByPrimaryKey() {
		rbacMenu.setWhetherDeleted((byte)0);
		int ret=rbacMenuMapper.updateByPrimaryKey(rbacMenu);
		logger.debug("junit:test04UpdateByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test05DeleteByPrimaryKey() {
		int ret=rbacMenuMapper.deleteByPrimaryKey(rbacMenu.getId());
		logger.debug("junit:test05DeleteByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test06Insert() {
		int ret=rbacMenuMapper.insert(rbacMenu);
		logger.debug("junit:test06Insert result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test07SelectByPrimaryKey() {
		RbacMenu record=rbacMenuMapper.selectByPrimaryKey(rbacMenu.getId());
		logger.debug("junit:test07SelectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null",record);
		
	}
	
	@Test
	public void test08DeleteByPrimaryKey() {
		int ret=rbacMenuMapper.deleteByPrimaryKey(rbacMenu.getId());
		logger.debug("junit:test08DeleteByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));

	}

}
