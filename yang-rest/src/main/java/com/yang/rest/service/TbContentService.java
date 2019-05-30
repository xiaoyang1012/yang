package com.yang.rest.service;

import java.util.List;

import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;
import com.yang.util.EasyUIResult;


/**
 * 获取博客文章的服务
 * 即查询tbcontent表，获取数据返回
 * @author 小仰
 *
 */
public interface TbContentService {
	List<ContentWithCat> selectContent();
	ContentWithCat selectOneContent(Long id);
	void addBrowse(Long id);
	void addAdmire(Long id);
	List<TbContent> contentSortedByBrowse();
	List<TbContent> contentSortedByAdmire();
	EasyUIResult selectOneCatList(Long id,int page);
}
