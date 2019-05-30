package com.yang.service;

import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;

public interface WordWallService { 

	EasyUIResult showAllWords(int page,int rows);
	
	YangResult deleteWordsByPrimaryKey(String ids);
	
	YangResult passWords(String id);
}
