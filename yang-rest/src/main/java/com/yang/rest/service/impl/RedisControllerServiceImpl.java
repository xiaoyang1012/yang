package com.yang.rest.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.rest.component.JedisClient;
import com.yang.rest.service.RedisControllerService;
import com.yang.util.YangResult;
@Service
public class RedisControllerServiceImpl implements RedisControllerService {
	Logger logger=Logger.getLogger(RedisControllerServiceImpl.class);

	//注入JedidClient实现缓存
	@Autowired
	private JedisClient jedisClient;
	
	/*
	 * 删除缓存里面的所有已发布文章
	 */
	@Override
	public YangResult delContentPushed() {
		//调用jedisClient删除缓存
			jedisClient.hdel("content", "pushed");
			return YangResult.ok();
	
	}
	/*
	 * 根据id删除某一个content
	 */
	public YangResult delContentById(Integer id){
		//调用jedisClient删除缓存
		jedisClient.hdel("content", id+"");
		return YangResult.ok();
	}
	
	/*
	 * 删除某个分类id对应的分类集合
	 */
	public YangResult delCatListById(Integer id){
		//调用jedisClient删除缓存
		jedisClient.hdel("Onecatlist", id+"");
		return YangResult.ok();
	}
	
}
