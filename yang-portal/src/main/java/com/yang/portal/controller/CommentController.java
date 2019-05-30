package com.yang.portal.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.yang.pojo.Comment; 
import com.yang.portal.service.CommentService;
import com.yang.util.CommentResult;

@Controller
public class CommentController {
	@Autowired
	private CommentService commentService; 
	/*
	 * 插入根评论
	 */
	@RequestMapping("/comment/insert/{id}")
	@ResponseBody
	public String insertComment(Comment comment,@PathVariable Long id){
		//System.out.println(id);
		commentService.insertComment(comment,id);
		CommentResult result=new CommentResult();
//		result.setStatus(200);
//		result.setMessage("成功");
//		String result1=result.toString();
		return "200";
	} 
}
