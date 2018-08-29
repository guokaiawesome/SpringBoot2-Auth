package com.monster.auth.util;

import java.util.Map;

import com.monster.auth.exception.custom.ClientParameterErrorException;

/**
 * 
 * @description 用于参数校验，参考spring和junit里面Assert的写法
 * @author guokai
 * @date 2018年8月29日
 * @version v1.0
 */
public class AssertUtil {

	
	/**
	 * 工具类的构造器必须private修饰，不让new对象，junit里面是protect修饰
	 */
	private AssertUtil() {
		
	}
	
	/**
	 * 
	 * @description 因为抛出的就是ClientParameterErrorException所以这里不需要msg,直接带上detail就行了
	 * @param message
	 * @param object
	 */
	public static void assertNotNull(String message, Object object,Map<String,Object> error) {
		if(object==null) {
			throw new ClientParameterErrorException(message, error);
		}
	}
	
	/**
	 * 这个方法可以移动到别的地方去，业务所有地方字符串转数字如果需要捕获异常的就自己写，
	 * 不需要捕获异常的地方直接通过assert扔出异常
	 * @description 用于将字符串转化为Integer、Long、Double这种
	 * @param message
	 * @param origin
	 */
	public static void assertNumerical(String message,String origin) {
		
	}
	
	/**
	 * 
	 * @description 断言字符串长度超长
	 */
	public static void assertStrParamTooLong() {
		
	}
	
	/**
	 * 
	 * @description 断言数字类型超过范围
	 */
	public static void assertNumericalParmOverrun() {
		
	}
	
	
	
}
