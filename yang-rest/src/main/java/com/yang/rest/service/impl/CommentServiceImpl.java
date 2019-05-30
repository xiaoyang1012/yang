package com.yang.rest.service.impl;


import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dao.CommentMapper;
import com.yang.pojo.Comment;

import com.yang.rest.service.CommentService;
import com.yang.util.CommentResult;
import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;
@Service
public class CommentServiceImpl implements CommentService {
	Logger logger = Logger.getLogger(CommentServiceImpl. class );
	
	@Autowired
	private CommentMapper commentMapper;
	/**
	 * 发布服插入评论
	 */
	@Override
	public YangResult insertComment(Comment comment) {
		//System.out.println(comment.toString());
		//调用commnetMapper将信息插入数据库
		commentMapper.insert(comment);
		logger.info("insertComment");
		//System.out.println(comment.getContent()+"--"+comment.getCustomerName()+"--"+comment.getParentCommentId());
		return YangResult.ok();
	}
	/**
	 * 根据文章id获取该文章下面所有的评论
	 */
	@Override
	public CommentResult getCommentListInfoById(Long id) {
		//调用commnetMapper将信息插入数据库
		List<Comment> list=commentMapper.getCommentListByContentId(id+"");
		logger.info("get comment list size:"+list.size()+"-----content id:"+id);
		EasyUIResult result=new EasyUIResult();
		result.setRows(list);
		//评论的个数应该是根评论的个数，而不是所有评论的个数
		int count=0;
		CommentResult result1=new CommentResult();
		List<Comment> root=new ArrayList<Comment>();
		List<Comment> foot=new ArrayList<Comment>();
		for(Comment comment:list){
			//将根评论和叶子评论分开
			if((0+"").equals(comment.getParentCommentId()) ||comment.getParentCommentId()==(0+"")){
				root.add(comment);
				count++;
			}else{
				foot.add(comment);
			}
		}
		result1.setCount(count);
		result1.setFootComment(foot);
		result1.setRootComment(root);
		result1.setStatus(200);
		return result1;
	}

}
