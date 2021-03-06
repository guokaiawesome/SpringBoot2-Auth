package com.monster.auth.dao;

import java.time.LocalDateTime;

import static org.hamcrest.CoreMatchers.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.monster.auth.pojo.po.RbacRole;

/**
 * 
 * @description RBAC中的角色相关单元测试
 * @author guokai
 * @date 2018年7月23日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class RbacRoleMapperTest {
	
	@Autowired
	RbacRoleMapper  rbacRoleMapper;
	
	static RbacRole rbacRole=new RbacRole();
	
	//用于测试Junit的构造器
	public RbacRoleMapperTest() {
		super();
		System.out.println("构造新的对象");
	}


	@BeforeClass
	public static void init() {
		//用于测试@Before和@BeforeClass
		System.out.println("test before");
		System.out.println("record="+rbacRole);
		rbacRole.setName("2018-07-26");
		rbacRole.setUpdatePersonId(2L);
		rbacRole.setGmtCreate(LocalDateTime.now());
		rbacRole.setGmtModified(LocalDateTime.now());
	}
	
	
	@Test
	public void test01Insert() {
		System.out.println("---1---");
		int ret=rbacRoleMapper.insert(rbacRole);
		Assert.assertThat("mysql affected rows must be one", ret, is(1));
		Assert.assertNotNull("mysql return primaryKey must be not null", rbacRole.getId());
		Assert.assertTrue("mysql return primaryKey must greater than 0",rbacRole.getId()>0);
	}
	

	
	@Test
	public void test02SelectByPrimaryKey() {
		System.out.println("---2---");
		RbacRole record=rbacRoleMapper.selectByPrimaryKey(rbacRole.getId());
		//junit4官方GitHub用这种方法，第一个参数是断言失败时候的输出信息
		Assert.assertNotNull("record should be not null", record);
		/*RbacRole expect=new RbacRole();
		Assert.assertThat("reason", record, sameInstance(expect));*/
	}
	
	@Test
	public void test03UpdateByPrimaryKeySelective() {
		System.out.println("---3---");
		rbacRole.setName("another");
		int ret=rbacRoleMapper.updateByPrimaryKeySelective(rbacRole);
		Assert.assertThat("mysql affected rows must be one", ret, is(1));
	}
	
	@Test
	public void test04UpdateByPrimaryKey() {
		System.out.println("---4---");

		rbacRole.setName("another2");
		int ret=rbacRoleMapper.updateByPrimaryKeySelective(rbacRole);
		Assert.assertThat("mysql affected rows must be one", ret, is(1));
	}
	
	/**
	 * 
	 * @description 这个测试顺序要放在每次插入更新之后
	 */
	@Test
	public void test05DeleteByPrimaryKey() {
		System.out.println("---5---");

		int ret=rbacRoleMapper.deleteByPrimaryKey(rbacRole.getId());
		Assert.assertThat("mysql affected rows must be one", ret, is(1));

	}
	
	@Test
	public void test06InsertSelective() {
		System.out.println("---6---");

		rbacRole.setName("selective");
		int ret=rbacRoleMapper.insertSelective(rbacRole);
		Assert.assertThat("mysql affected rows must be one", ret, is(1));
		Assert.assertNotNull("mysql affected rows must greater than 0", rbacRole.getId());
		Assert.assertTrue(rbacRole.getId()>0);

	}
	
	@Test
	public void test07SelectByPrimaryKey() {
		System.out.println("---7---");
		
		RbacRole record=rbacRoleMapper.selectByPrimaryKey(rbacRole.getId());
		//junit4官方GitHub用这种方法，第一个参数是断言失败时候的输出信息
		Assert.assertNotNull("record should be not null", record);
	}
	
	@Test
	public void test08DeleteByPrimaryKey() {
		System.out.println("---8---");
		
		int ret=rbacRoleMapper.deleteByPrimaryKey(rbacRole.getId());
		Assert.assertThat("mysql affected rows must be one", ret, is(1));
	}

}
