package com.yang.portal.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


import com.yang.pojo.Comment;
import com.yang.portal.service.CommentService;
import com.yang.util.HttpClientUtil;
import com.yang.util.YangResult;
/**
 * 用来调用服务，向数据库中插入一条评论，这个只针对父评论(就是parentId为0的评论)
 * @author 小仰
 *
 */
@Service
public class CommentServiceImpl implements CommentService {
	Logger logger = Logger.getLogger(CommentServiceImpl. class );

	//导入url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${COMMENT_INSERT_URL}")
	private String COMMENT_INSERT_URL;
	
	
	
	
	@Override
	public YangResult insertComment(Comment comment, Long id) {
		//补全commnet属性
		comment.setCommentDate(new Date());
		comment.setParentCommentId("0");
		comment.setContentId(id.toString());
		//随机生成id
		UUID uuid=UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
		comment.setId(uuidStr);
		// 调用rest发布的服务
	//	System.out.println(comment.toString());
		Map<String,String> param =new HashMap<String,String>();
		//生成参数
		param.put("customerName", comment.getCustomerName());
		param.put("parentCommentId", comment.getParentCommentId());
		param.put("contentId", comment.getContentId());
		param.put("content", comment.getContent());
		param.put("commentDate", comment.getCommentDate().toString());
		param.put("id", comment.getId().toString());
		//发出post请求，插入评论到数据库
		HttpClientUtil.doPost(REST_BASE_URL+COMMENT_INSERT_URL, param);
		logger.info("send a post request to rest server");
		return YangResult.ok();
	}

}
