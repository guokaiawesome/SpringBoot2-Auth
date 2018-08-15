package com.monster.auth.dao;

import java.time.LocalDateTime;
import java.util.UUID;

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
import com.monster.auth.pojo.po.Oauth2ClientInfo;
import com.monster.auth.pojo.po.UserBaseInfo;
import static org.hamcrest.CoreMatchers.*;

/**
 * 
 * @description 用户调用API凭证相关测试
 * @author guokai
 * @date 2018年8月13日
 * @version v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class Oauth2ClientInfoMapperTest {
	
	/**
	 * 这里需要注意一下，getLogger的时候用类名，这里打印不出日志，用字符串是可以打印的，
	 * 这里字符串可以是logback配置的，也可以是随便写的
	 */
	private static final Logger logger=LoggerFactory.getLogger("junit-test");

	@Autowired
	Oauth2ClientInfoMapper oauth2ClientInfoMapper;
	
	@Autowired
	UserBaseInfoMapper userInfoMapper;
	
	private static Oauth2ClientInfo oauth2ClientInfo=new Oauth2ClientInfo();
	
	private static UserBaseInfo userBaseInfo=new UserBaseInfo();
	
	/**
	 * 
	 * @description 数据初始化
	 * BeforeClass注解里面的方法只会执行一次
	 */
	@BeforeClass
	public static void init() {
		//这里写死的话实际上也不靠谱，可以考虑先在user_base_info表里面插入一条记录，然后取出uid
		//单纯测试的话也可以写上特殊标识，比如junit-test这种开头，后面加上随机数，方便大家辨识统一删除
		//在AfterClass注解里面统一进行删除，这样就可以达到这个mapperTest只涉及到这一个表的操作
		//一定要确保在这个Class里面执行的所有插入、更新操作等，在执行完测试之后务必要删除，不管junit是否成功
		//oauth2ClientInfo.setUid("");
		oauth2ClientInfo.setClientId(RandomStringUtils.randomAlphabetic(32));
		//oauth2ClientInfo.setClientSecret(UUID.randomUUID().toString().replaceAll("-", ""));
		//oauth2ClientInfo.setClientSecret(RandomStringUtils.randomAlphanumeric(32));
		oauth2ClientInfo.setClientSecret(RandomStringUtils.randomAscii(32));
		oauth2ClientInfo.setGmtCreate(LocalDateTime.now());
		oauth2ClientInfo.setGmtModified(LocalDateTime.now());
		
		userBaseInfo.setUid(UUID.randomUUID().toString().replaceAll("-", ""));
		//userBaseInfo.setNickName(RandomStringUtils.randomAlphabetic(12));
		userBaseInfo.setRealName(RandomStringUtils.randomAlphanumeric(12));
		userBaseInfo.setState((byte) 1);
		userBaseInfo.setGmtCreate(LocalDateTime.now());
		userBaseInfo.setGmtModified(LocalDateTime.now());
		
		logger.debug("junit:init:oauth2ClientInfo--->{}",oauth2ClientInfo.toString());
		logger.debug("junit:init:userBaseInfo--->{}",userBaseInfo.toString());
	}
	
	/**
	 * 
	 * @description 测试insertSelective
	 * insertSelective放在前面测试
	 */
	@Test
	public void test01InsertSelective() {
		
		int ret=userInfoMapper.insertSelective(userBaseInfo);
		logger.debug("junit:test01InsertSelective:insertUserBaseInfo result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
		
		oauth2ClientInfo.setUid(userBaseInfo.getUid());
		int ret2=oauth2ClientInfoMapper.insertSelective(oauth2ClientInfo);
		logger.debug("junit:test01InsertSelective:insertOauth2ClientInfo result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret2, is(1));
	}
	
	@Test
	public void test02SelectByPrimaryKey() {
		Oauth2ClientInfo record=oauth2ClientInfoMapper.selectByPrimaryKey(oauth2ClientInfo.getId());
		logger.debug("junit:test02SelectByPrimaryKey:selectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null",record);
	}
	
	@Test
	public void test03UpdateByPrimaryKeySelective() {
		oauth2ClientInfo.setWhetherFrozen((byte)1);
		int ret=oauth2ClientInfoMapper.updateByPrimaryKeySelective(oauth2ClientInfo);
		logger.debug("junit:test03UpdateByPrimaryKeySelective:updateByPrimaryKeySelective result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));

	}
	
	@Test
	public void test04UpdateByPrimaryKey() {
		oauth2ClientInfo.setWhetherFrozen((byte)0);
		oauth2ClientInfo.setWhetherDeleted((byte)0);

		int ret=oauth2ClientInfoMapper.updateByPrimaryKey(oauth2ClientInfo);
		logger.debug("junit:test04UpdateByPrimaryKey:updateByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test05DeleteByPrimaryKey() {
		int ret=oauth2ClientInfoMapper.deleteByPrimaryKey(oauth2ClientInfo.getId());

		//删除完成之后看下mybatis有没有将oauth2ClientInfo这个对象的id清除
		logger.debug("junit:test05DeleteByPrimaryKey:deleteByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
		
		//上面的assert语句为false之后下面的代码不会执行
		int ret2=userInfoMapper.deleteByPrimaryKey(userBaseInfo.getId());
		Assert.assertThat("mysql affect rows must be one", ret2, is(1));
	}
	
	@Test
	public void test06Insert() {
		
		int ret=oauth2ClientInfoMapper.insert(oauth2ClientInfo);
		//这里对比一下oauth2ClientInfo中的id和之前的id是否一致，理论上应该是不一致的
		logger.debug("junit:test06Insert:insert result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));
	}
	
	@Test
	public void test07SelectByPrimaryKey() {
		Oauth2ClientInfo record=oauth2ClientInfoMapper.selectByPrimaryKey(oauth2ClientInfo.getId());
		logger.debug("junit:test07SelectByPrimaryKey:selectByPrimaryKey result--->{}",record);
		Assert.assertNotNull("record should be not null", record);
	}
	
	@Test
	public void test08DeleteByPrimaryKey() {
		int ret=oauth2ClientInfoMapper.deleteByPrimaryKey(oauth2ClientInfo.getId());
		logger.debug("junit:test08DeleteByPrimaryKey:deleteByPrimaryKey result--->{}",ret);
		Assert.assertThat("mysql affect rows must be one", ret, is(1));

	}
	
	
	
}
