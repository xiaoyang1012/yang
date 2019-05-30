package com.yang.portal.service;

import com.yang.util.SearchResult; 


public interface SearchServicePortal {
	
	SearchResult  search(String keyWords,Long page);

}
