package com.monster.auth.dao;

import java.time.LocalDateTime;

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

import static org.hamcrest.CoreMatchers.*;

import com.monster.auth.pojo.po.RbacResource;
import com.monster.auth.pojo.po.RbacRoleResource;

/**
 * 
 * @description Mapper层空模板，其他新写相关测试可以参考
 * @author guokai
 * @date 2018年8月17日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacRoleResourceMapperTest {
	
	/**
	 * 这里需要注意一下，getLogger的时候用类名，这里打印不出日志，用字符串是可以打印的，
	 * 这里字符串可以是logback配置的，也可以是随便写的
	 */
	private static final Logger logger=LoggerFactory.getLogger("junit-test");
	
	@Autowired
	private RbacRoleResourceMapper rbacRoleResourceMapper;
	
	private static RbacRoleResource rbacRoleResource=new RbacRoleResource();
	
	@BeforeClass
	public static void init() {
		//junit单元测试往数据库插入的数据尽量都有明显的junit:test测试标识，虽然大部分时间按照正常流程都会删除，
		//但是为了避免单元测试异常导致数据异常，加上明显的标识方便定位错误
		
		rbacRoleResource.setRoleId(99999L);
		rbacRoleResource.setResourceId(99999L);
		rbacRoleResource.setUpdatePersonId(99999L);
		rbacRoleResource.setGmtCreate(LocalDateTime.now());
		rbacRoleResource.setGmtModified(LocalDateTime.now());
		
		logger.debug("junit:init:rbacRoleResource--->{}",rbacRoleResource);
	}
	
	@Test
	public void test01InsertSelective() {
		int ret = rbacRoleResourceMapper.insertSelective(rbacRoleResource);
		logger.debug("junit:test01InsertSelective result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test02SelectByPrimaryKey() {
		RbacRoleResource record=rbacRoleResourceMapper.selectByPrimaryKey(rbacRoleResource.getId());
		logger.debug("junit:test02SelectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null",record);
	}
	
	@Test
	public void test03UpdateByPrimaryKeySelective() {
		rbacRoleResource.setWhetherDeleted((byte)1);
		int ret = rbacRoleResourceMapper.updateByPrimaryKeySelective(rbacRoleResource);
		logger.debug("junit:test03UpdateByPrimaryKeySelective result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test04UpdateByPrimaryKey() {
		rbacRoleResource.setWhetherDeleted((byte)0);
		int ret = rbacRoleResourceMapper.updateByPrimaryKey(rbacRoleResource);
		logger.debug("junit:test04UpdateByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));

	}
	
	@Test
	public void test05DeleteByPrimaryKey() {
		int ret = rbacRoleResourceMapper.deleteByPrimaryKey(rbacRoleResource.getId());
		logger.debug("junit:test05DeleteByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test06Insert() {
		int ret = rbacRoleResourceMapper.insert(rbacRoleResource);
		logger.debug("junit:test06Insert result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test07SelectByPrimaryKey() {
		RbacRoleResource record = rbacRoleResourceMapper.selectByPrimaryKey(rbacRoleResource.getId());
		logger.debug("junit:test07SelectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null",record);
	}
	
	@Test
	public void test08DeleteByPrimaryKey() {
		int ret = rbacRoleResourceMapper.deleteByPrimaryKey(rbacRoleResource.getId());
		logger.debug("junit:test08DeleteByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}


}
