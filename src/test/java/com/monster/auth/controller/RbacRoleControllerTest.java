package com.monster.auth.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * 
 * @description 单元测试
 * @author guokai
 * @date 2018年7月23日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWebMvc
public class RbacRoleControllerTest {
	
	@Autowired
	MockMvc mvc;
	
	@Test
	public void test() {
		
	}

}
