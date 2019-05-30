package com.yang.search.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yang.pojo.ContentWithCat;
import com.yang.search.dao.SearchDao;
import com.yang.search.pojo.SearchResult;
/**
 * solr查询dao
 * @author 小仰
 *
 */
@Repository
public class SearchDaoImpl implements SearchDao {
	
	Logger logger =Logger.getLogger(SearchDaoImpl.class);
	//注入solrServer
	@Autowired
	private SolrServer solrServer;

	@Override
	public SearchResult search(SolrQuery query) throws Exception{
		// 执行查村
		QueryResponse response=solrServer.query(query);
		//结果列表
		List<ContentWithCat> list=new ArrayList<ContentWithCat>();
		//去查询结果列表
		SolrDocumentList solrDocumentList=response.getResults();
		for(SolrDocument solrDocument:solrDocumentList){
			//创建一个contentWitnCat对象
			ContentWithCat cat=new ContentWithCat();
			cat.setAuthor(solrDocument.get("content_author")+"");
			cat.setCategory(solrDocument.get("content_category")+"");
			cat.setId(solrDocument.get("id")+"");
			//取高亮显示
			Map<String, Map<String, List<String>>> highlighting=response.getHighlighting();
			List<String> list2 =highlighting.get(solrDocument.get("id")).get("content_title");
			String highlight="";
			if(list2!=null&&list2.size()!=0){
				//取高亮后的结果，只会有一条数据
				highlight=list2.get(0);	
			}else{
				highlight=(String)solrDocument.get("content_title");
			}
			cat.setTitle(highlight+"");
			cat.setPic(solrDocument.get("content_image")+"");
			//添加到列表
			list.add(cat);
		}
		SearchResult result=new SearchResult();
		logger.info("get query result size="+list.size());
		result.setContentList(list);
		//查询结果总数量
		result.setRecordCount(solrDocumentList.getNumFound());
		
		return result;
	}

}
