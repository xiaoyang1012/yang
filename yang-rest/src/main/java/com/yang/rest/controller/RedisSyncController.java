package com.yang.rest.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.rest.service.RedisControllerService;
import com.yang.util.YangResult;

@Controller
public class RedisSyncController {

	@Autowired
	private RedisControllerService redisController;
	/**
	 * 发布服务，删除redis缓存中的所有已发布文章的集合的
	 */
	@RequestMapping("/sync/contentpushed")
	@ResponseBody
	public YangResult SyncContentPushed(){
		try{
			YangResult result=redisController.delContentPushed();
			return result;
		}catch(Exception e){
			return YangResult.build(500,ExceptionUtils.getStackTrace(e));
		}
	}
	
	/**
	 * 发布服务，删除redis缓存中的某一个id对应的content
	 */
	@RequestMapping("/sync/oneContent/{id}")
	@ResponseBody
	public YangResult SyncContentById(@PathVariable int id){
		try{
			YangResult result=redisController.delContentPushed();
			return result;
		}catch(Exception e){
			return YangResult.build(500,ExceptionUtils.getStackTrace(e));
		}
	}
	
	/**
	 * 发布服务，删除redis缓存中的某一个id对应的content
	 */
	@RequestMapping("/sync/catlistbyid/{id}")
	@ResponseBody
	public YangResult SyncCatListById(@PathVariable int id){
		try{
			YangResult result=redisController.delCatListById(id);
			return result;
		}catch(Exception e){
			return YangResult.build(500,ExceptionUtils.getStackTrace(e));
		}
	}
	
}
