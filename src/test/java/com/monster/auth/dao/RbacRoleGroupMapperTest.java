package com.monster.auth.dao;

import static org.hamcrest.CoreMatchers.*;

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

import com.monster.auth.pojo.po.RbacRoleGroup;

/**
 * 
 * @description 权限控制相关角色和用户组的关系测试
 * @author guokai
 * @date 2018年8月17日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacRoleGroupMapperTest {
	
	
	/**
	 * 这里需要注意一下，getLogger的时候用类名，这里打印不出日志，用字符串是可以打印的，
	 * 这里字符串可以是logback配置的，也可以是随便写的
	 */
	private static final Logger logger=LoggerFactory.getLogger("junit-test");
	
	@Autowired
	private RbacRoleGroupMapper rbacRoleGroupMapper;
	
	private static RbacRoleGroup rbacRoleGroup=new RbacRoleGroup();
	
	@BeforeClass
	public static void init() {
		//junit单元测试往数据库插入的数据尽量都有明显的junit:test测试标识，虽然大部分时间按照正常流程都会删除，
		//但是为了避免单元测试异常导致数据异常，加上明显的标识方便定位错误
		
		rbacRoleGroup.setGroupId(99999L);
		rbacRoleGroup.setRoleId(99999L);
		rbacRoleGroup.setGmtCreate(LocalDateTime.now());
		rbacRoleGroup.setGmtModified(LocalDateTime.now());
		
		logger.debug("junit:init:rbacRoleGroup--->{}",rbacRoleGroup);
	}
	
	@Test
	public void test01InsertSelective() {
		int ret = rbacRoleGroupMapper.insertSelective(rbacRoleGroup);
		logger.debug("junit:test01InsertSelective result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test02SelectByPrimaryKey() {
		RbacRoleGroup record = rbacRoleGroupMapper.selectByPrimaryKey(rbacRoleGroup.getId());
		logger.debug("junit:test02SelectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null",record);
	}
	
	@Test
	public void test03UpdateByPrimaryKeySelective() {
		rbacRoleGroup.setWhetherDeleted((byte)1);
		int ret = rbacRoleGroupMapper.updateByPrimaryKeySelective(rbacRoleGroup);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test04UpdateByPrimaryKey() {
		rbacRoleGroup.setWhetherDeleted((byte)0);
		int ret=rbacRoleGroupMapper.updateByPrimaryKey(rbacRoleGroup);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test05DeleteByPrimaryKey() {
		int ret = rbacRoleGroupMapper.deleteByPrimaryKey(rbacRoleGroup.getId());
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test06Insert() {
		int ret = rbacRoleGroupMapper.insert(rbacRoleGroup);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test07SelectByPrimaryKey() {
		RbacRoleGroup record = rbacRoleGroupMapper.selectByPrimaryKey(rbacRoleGroup.getId());
		logger.debug("junit:test07SelectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null",record);
		
	}
	
	@Test
	public void test08DeleteByPrimaryKey() {
		int ret = rbacRoleGroupMapper.deleteByPrimaryKey(rbacRoleGroup.getId());
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}


}
