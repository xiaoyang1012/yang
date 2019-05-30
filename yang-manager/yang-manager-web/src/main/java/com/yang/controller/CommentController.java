package com.yang.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.Comment;
import com.yang.service.CommentService;
import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;

@Controller
public class CommentController { 

	@Autowired
	private CommentService commentService;
	
	/**
	 * 获取所有评论列表
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/comments/list")
	@ResponseBody
	public EasyUIResult getCommentList(Integer page,Integer rows){
		return commentService.getComentList(page,rows);
	}
	/**
	 * 删除选中的列表
	 * @param ids
	 * @return
	 */
	@RequestMapping("/rest/comment/delete")
	@ResponseBody
	public YangResult deleteSlectedComment(String ids){
		return commentService.deleteSelectedComment(ids);
	}
	/**
	 * 评论模块，搜索功能的实现
	 * @param flage
	 * @param value
	 * @return
	 * @throws UnsupportedEncodingException
	 */
	@RequestMapping("/search/comments/list/{flage}/{value}")
	@ResponseBody
	public EasyUIResult searchCommentsResult(@PathVariable String flage,@PathVariable String value,
			Integer page,Integer rows) throws UnsupportedEncodingException{
		//进行编码转换
		String value1=new String(value.getBytes("iso-8859-1"),"UTF-8");
		EasyUIResult result=commentService.getSearchResult(flage, value1, page, rows);
//		System.out.println(result.getTotal());
//		List<Comment> list=(List<Comment>) result.getRows();
//		for(int i=0;i<list.size();i++){
//			System.out.println(list.get(i).getCustomerName()+list.get(i).getContent());
//		}
		return result;
	}
	
}
