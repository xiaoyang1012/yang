package com.yang.portal.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yang.portal.service.SearchServicePortal;
import com.yang.util.HttpClientUtil;
import com.yang.util.SearchResult;
import com.yang.util.YangResult;
@Service
public class SearchServicePortalImpl implements SearchServicePortal {
	Logger logger = Logger.getLogger(SearchServicePortalImpl. class );
	
	//导入url
	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;

	

	@Override
	public SearchResult search(String keyWords, Long page) {
		//创建查询条件
		Map<String, String> param = new HashMap();
		param.put("keyword", keyWords);
		param.put("page", page + "");
		
		// 获取文章类目列表
		String searchResult=HttpClientUtil.doGet(SEARCH_BASE_URL,param);
		logger.info("searchResult:"+searchResult);
		//将获得的json转换成pojo对象
		YangResult result=YangResult.formatToPojo(searchResult, SearchResult.class);
		logger.info("get serach result key:"+keyWords);
		SearchResult result1=(SearchResult)result.getData();
		return result1;
	}

}
