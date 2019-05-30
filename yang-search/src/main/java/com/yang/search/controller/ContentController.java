package com.yang.search.controller;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.search.service.contentService;
import com.yang.util.YangResult;
/**
 * 导入商品数据
 * @author 小仰
 *
 */
@Controller
public class ContentController {

	@Autowired
	private contentService service;
	
	/**
	 * 用来将数据库里面的所有数据导入到solr服务器
	 * @return
	 */
	@RequestMapping("/importall")
	@ResponseBody
	public YangResult importAll(){
		try{
			return service.importContent();
		}catch(Exception e){
			return YangResult.build(500,ExceptionUtils.getMessage(e));
		}
	}
	
	
	
	
	
	
	
	
}
