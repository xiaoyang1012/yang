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
		//��������
		SolrServer solrServer=new HttpSolrServer("http://47.99.74.206:8080/solr");
		//����һ���ĵ�
		SolrInputDocument document=new SolrInputDocument();
		document.addField("id", "solrTest01");
		document.addField("content_title", "���Ա���");
		document.addField("content_category", "����ʶ����");
		//��ӵ�������
		solrServer.add(document);
		solrServer.commit();
	}
	
	
	@Test
	public void testQuery() throws Exception {
		//��������
		SolrServer solrServer = new HttpSolrServer("http://47.99.74.206:8080/solr");
		//����һ����ѯ����
		SolrQuery query = new SolrQuery();
		query.setQuery("*:*"); 
		//ִ�в�ѯ
		QueryResponse response = solrServer.query(query);
		//ȡ��ѯ���
		SolrDocumentList solrDocumentList = response.getResults();
		for (SolrDocument solrDocument : solrDocumentList) {
			System.out.println(solrDocument.get("id"));
			System.out.println(solrDocument.get("content_title"));
			System.out.println(solrDocument.get("content_category"));
		}
	}

}
