package com.yang.search.service.impl;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.search.dao.SearchDao;
import com.yang.search.pojo.SearchResult;
import com.yang.search.service.SearchService;
@Service
public class SearchServerImpl implements SearchService {
	
	Logger logger=Logger.getLogger(SearchServerImpl.class);

	@Autowired
	private SearchDao searchDao;
	@Override
	public SearchResult search(String queryString, int page, int rows)
			throws Exception {
		//创建查询条件
		SolrQuery query = new SolrQuery();
		//设置查询条件
		query.setQuery(queryString);
		//设置分页条件
		query.setStart((page-1)*rows);
		query.setRows(rows);
		//设置默认搜索域
		query.set("df", "content_title");
		//设置高亮
		query.setHighlight(true);
		query.addHighlightField("content_title");
		query.setHighlightSimplePre("<font style=\"color:red\">");
		query.setHighlightSimplePost("</font>");
		//执行查询
		SearchResult searchResult = searchDao.search(query);
		//计算总页数
		Long recordCount = searchResult.getRecordCount();
		int pageCount = (int) (recordCount / rows);
		if (recordCount % rows > 0) {
			pageCount++;
		}
		searchResult.setPageCount(pageCount);
		searchResult.setCurrentPage(page);
		logger.info("query message successfully!");
		return searchResult;	
	}

}
