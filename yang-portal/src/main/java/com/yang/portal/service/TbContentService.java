package com.yang.portal.service;

import java.util.List;

import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;

import com.yang.util.CommentResult;
import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;

public interface TbContentService { 
	List<Object> getContent();
	ContentWithCat getOneContent(Long id);
	List<TbContent> contentSortedByBrowse();
	List<TbContent> contentSortedByAdmire();
	YangResult addAdmire(Long id);
	EasyUIResult getContentListByCat(int page,long id);
	CommentResult getCommentList(Long id);
}
