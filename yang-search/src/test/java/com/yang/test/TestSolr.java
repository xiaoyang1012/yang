package com.yang.test;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

public class TestSolr {
	@Test
	public void testSolr() throws Exception{
		//创建链接
		SolrServer solrServer=new HttpSolrServer("http://47.99.74.206:8080/solr");
		//创建一个文档
		SolrInputDocument document=new SolrInputDocument();
		document.addField("id", "solrTest01");
		document.addField("content_title", "测试标题");
		document.addField("content_category", "才认识分类");
		//添加到索引库
		solrServer.add(document);
		solrServer.commit();
	}
	
	
	@Test
	public void testQuery() throws Exception {
		//创建连接
		SolrServer solrServer = new HttpSolrServer("http://47.99.74.206:8080/solr");
		//创建一个查询对象
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*"); 
		//执行查询
		QueryResponse response = solrServer.query(query);
		//取查询结果
		SolrDocumentList solrDocumentList = response.getResults();
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("content_title"));
			System.out.println(solrDocument.get("content_category"));
		}
	}

}
