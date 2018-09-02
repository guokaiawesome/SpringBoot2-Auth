package com.monster.auth.other;

import java.util.UUID;

import com.alibaba.fastjson.JSON;

/**
 * 
 * @description 用于测试json字符串和对象的互相转换 比如json中字段比Object中多或者少字段看看能不能正常转换
 *              用于测试API版本升级过程中返回参数增加字段各调用方的服务容错性
 * @author guokai
 * @date 2018年9月2日
 * @version v1.0
 */
public class JsonToObjectTest {

	public static void main(String[] args) {

		Order order = new Order();
		order.setId(999);
		order.setName("abc");
		order.setUid(UUID.randomUUID().toString());
		order.setProducer("producer");
		order.setConsumer("consumer");
		order.setVars("vars");

		//String json1 = JSON.toJSONString
		String json1=JSON.toJSONString(order);
		//JSON.toJSONString(order, null, null);
		//JSON.toJSONString(order, features);
		System.out.println(json1);
		
		//这种用法会报错
		/*Order order2=(Order) JSON.parse(
				"{\"consumer\":\"consumer\",\"id\":999,\"name\":\"abc\",\"producer\":\"producer\",\"uid\":\"94503490-6a3a-4473-a1b0-05d400e92bcb\",\"vars\":\"vars\"}");
*/
		
		//证明text里面加减字段都可以正常转换为类对象
		String text="{\"consumer\":\"consumer\",\"name\":\"abc\",\"producer\":\"producer\",\"uid\":\"94503490-6a3a-4473-a1b0-05d400e92bcb\",\"vars\":\"vars\",\"s\":1}";
		Order order2=JSON.parseObject(text, Order.class);
		System.out.println(order2.toString());
	}

}
