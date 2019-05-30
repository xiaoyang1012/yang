package com.yang.jedis;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yang.rest.component.JedisClient;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class JedisTest {

	//单机版测试
	@Test
	public void testJedis(){
		//床建一个jedis对象【先把jedis依赖的jar包添加到工程中】
		Jedis jedis=new Jedis("47.99.74.206",6379);
		jedis.set("hello", "hello jedis");
		String hello=jedis.get("hello");
		System.out.println(hello);
		jedis.close();
	}
	
	/**
	 * 使用连接池
	 */
	@Test
	public void testJedisWithPool(){
		//创建一个连接池对象
		JedisPool pool=new JedisPool("47.99.74.206",6379);
		//从连接池中国获得一个链接
		Jedis jedis=pool.getResource();
		String hello=jedis.get("hello");
		System.out.println(hello);
		jedis.close();
		//当系统关闭时，关闭连接池
		pool.close();
	}
	
	
	/**
	 * 测试spring整合jedis
	 */
	@Test
	public void testJedisBySpring(){
		//创建一个spring容器
		ApplicationContext app=new ClassPathXmlApplicationContext("classpath:spring/applicationContext-*.xml");
		//从容器中获得jedisclient对象
		JedisClient jedisClient=app.getBean(JedisClient.class);
		//使用jedisClient来操作
		jedisClient.set("client", "1000");
		String key=jedisClient.get("client");
		System.out.println(key);
		
	}
}
