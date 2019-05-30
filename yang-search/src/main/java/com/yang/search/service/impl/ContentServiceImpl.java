package com.yang.search.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dao.TbContentMapper;
import com.yang.pojo.ContentWithCat;
import com.yang.search.service.contentService;
import com.yang.util.YangResult;
@Service
public class ContentServiceImpl implements contentService {
	Logger logger=Logger.getLogger(ContentServiceImpl.class);

	@Autowired
	private SolrServer solrServer;
	@Autowired
	private TbContentMapper contentMapper;
	
	@Override
	public YangResult importContent() throws Exception {
		// 查询数据库获取content
		List<ContentWithCat> list=contentMapper.selectAll();
		//遍历集合
		for(ContentWithCat cat:list){
			//新建document
			SolrInputDocument document=new SolrInputDocument();
			//添加域
			document.addField("id",cat.getId()+"");
			document.addField("content_title",cat.getTitle());
			document.addField("content_category",cat.getCategory());
			document.addField("content_author",cat.getAuthor());
			document.addField("content_image",cat.getPic());
			document.addField("content_content",cat.getContent());
			//添加document
			solrServer.add(document);
		}
		//提交
		solrServer.commit();
		logger.info("success to import all content to solr ---size:"+list.size());
		return YangResult.ok();
	}

}
