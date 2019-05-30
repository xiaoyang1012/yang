package com.yang.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.Comment;
import com.yang.rest.service.CommentService;
import com.yang.util.CommentResult;
import com.yang.util.YangResult;
/**
 * 评论模块的controller  用于发布插入评论或者获取评论内容
 * @author 小仰
 *
 */
@Controller
public class CommentController {
	
	@Autowired 
	private CommentService commnetService;
	
	
	//@RequestMapping(value="/comment/insert",produces="application/json;charset=utf-8")
	//用来插入评论的controller
	@RequestMapping("/comment/insert")
	@ResponseBody
	public YangResult insertComment(Comment comment) throws Exception{
	//	Comment comment1=JsonUtils.jsonToPojo(comment, Comment.class);
//		String comment1 = new String(comment.toString().getBytes("ISO-8859-1"), "utf-8");
//		String comment2 = new String(comment.toString().getBytes("gbk"), "utf-8");
		//String comment1=new String(comment.toString().getBytes("ISO-8859-1"),"UTF-8");
//		System.out.println("服务端刚刚接收到的--"+comment.toString());
//		System.out.println("转码后的的--"+comment1);
//		System.out.println("comment2"+comment2);
//		System.out.println("comment"+comment);
		return commnetService.insertComment(comment);
	} 
	
	
	//用来获取评论列表的controller
	@RequestMapping("/comment/getInfo/{id}")
	@ResponseBody
	public CommentResult getCommentList(@PathVariable Long id) throws Exception{
		return commnetService.getCommentListInfoById(id);
	} 

}
