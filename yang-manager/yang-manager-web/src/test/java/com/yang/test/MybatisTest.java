package com.yang.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


import com.yang.dao.userMapper;
import com.yang.pojo.user;


public class MybatisTest {
	@Autowired
	private userMapper userdao;
	@Test 
	public void testMybatis(){
		//1:获取mapper代理对象
		ApplicationContext ac=
			new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		userMapper bean=ac.getBean(userMapper.class);
		user user=bean.selectByPrimaryKey("1");
		System.out.println(user.getId());
	}

}
