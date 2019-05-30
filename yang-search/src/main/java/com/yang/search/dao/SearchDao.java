package com.yang.search.dao;

import org.apache.solr.client.solrj.SolrQuery;

import com.yang.search.pojo.SearchResult;

public interface SearchDao {

	SearchResult search(SolrQuery query) throws Exception;
}
