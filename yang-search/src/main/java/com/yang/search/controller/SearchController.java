package com.yang.search.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.search.pojo.SearchResult;
import com.yang.search.service.SearchService;
import com.yang.search.service.impl.SearchServerImpl;
import com.yang.util.ExceptionUtil;
import com.yang.util.YangResult;
/**
 * 搜索服务的url：/search/query?keyword=xxx&page=1&rows=30
 * @author 小仰
 *
 */

@Controller
public class SearchController {
	@Autowired
	private SearchService searchService;
	
	@RequestMapping("/query")
	@ResponseBody
	public YangResult search(@RequestParam(defaultValue="")String keyword, 
			@RequestParam(defaultValue="1")Integer page, 
			@RequestParam(defaultValue="15")Integer rows){
		try {
			//转换字符集
			keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
			SearchResult searchResult = searchService.search(keyword, page, rows);
			return YangResult.ok(searchResult);
		} catch (Exception e) {
			e.printStackTrace();
			return YangResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		
	}
}
