package com.yang.rest.component;

import org.springframework.beans.factory.annotation.Autowired;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
/**
 * redis客户端单机版实现类
 * @author 小仰
 *
 */
public class JedisClientSingle implements JedisClient {

	//需要使用jedispool对象，该对象应该由spring注入
	@Autowired
	private JedisPool jedisPool;
	@Override
	public Long decr(String key) {
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.decr(key);
		jedis.close();
		return result;
	}

	@Override
	public Long expire(String key, int second) {
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.expire(key,second);
		jedis.close();
		return result;
	}

	@Override
	public String get(String key) {
		Jedis jedis=jedisPool.getResource();
		String result=jedis.get(key);
		jedis.close();
		return result;
	}

	@Override
	public String hget(String key, String item) {
		Jedis jedis=jedisPool.getResource();
		String result=jedis.hget(key,item);
		jedis.close();
		return result;
	}

	@Override
	public Long hset(String key, String item, String value) {
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.hset(key,item, value);
		jedis.close();
		return result;
	}

	@Override
	public Long incr(String key) {
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.incr(key);
		jedis.close();
		return result;
	}

	@Override
	public String set(String key, String value) {
		Jedis jedis=jedisPool.getResource();
		String result=jedis.set(key, value);
		jedis.close();
		return result;
	}

	@Override
	public Long ttl(String key) {
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.ttl(key);
		jedis.close();
		return result;
	}
	
	@Override
	public Long hdel(String key, String item) {
		Jedis jedis=jedisPool.getResource();
		Long result=jedis.hdel(key,item);
		jedis.close();
		return result;
	}


}
