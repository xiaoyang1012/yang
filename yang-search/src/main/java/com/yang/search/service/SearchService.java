package com.yang.search.service;

import com.yang.search.pojo.SearchResult;

public interface SearchService {
	
	SearchResult search(String queryString,int page,int rows)throws Exception;

}
 