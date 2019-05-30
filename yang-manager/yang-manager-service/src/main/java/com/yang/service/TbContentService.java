package com.yang.service;





import com.yang.pojo.TbContent;
import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;

public interface TbContentService { 
	EasyUIResult selectAll(int page,int rows);
	YangResult deleteByPrimaryKey(String ids);
	YangResult RollBackBlog(String ids);
	YangResult releaseBlog(String ids);
	YangResult insertContent(TbContent content,Integer categoryId);
	YangResult editContent(TbContent content);
	
}
