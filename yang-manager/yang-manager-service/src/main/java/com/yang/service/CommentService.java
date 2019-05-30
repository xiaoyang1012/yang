package com.yang.service;

import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;

public interface CommentService {
 
	EasyUIResult getComentList(int page,int rows);
	YangResult deleteSelectedComment(String ids);
	EasyUIResult getSearchResult(String flag,String value,int page,int rows);
}
