package com.yang.portal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.Comment;
import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;
import com.yang.portal.service.TbContentService;
import com.yang.util.CommentResult;
import com.yang.util.EasyUIResult;
import com.yang.util.JsonUtils;
import com.yang.util.YangResult;

@Controller
public class ContentDetailController {
	
	@Autowired
	private TbContentService contentService;
	
	@RequestMapping("/blog/info/{id}")
	public String showContentDetail(@PathVariable Long id ,Model model){
		//调用servcie 根据id查询content 应用于博客详情
		ContentWithCat content=contentService.getOneContent(id);
		//调用服务，获取文章阅读量的排行榜数据返回
		List<TbContent> conntentListOrderByBrowse=contentService.contentSortedByBrowse();
		
		//调用服务，获取文章的评论列表json数据，返回
		CommentResult commentResult=contentService.getCommentList(id);
		//这个commentcount应该是根评论个数
		int commentCount=commentResult.getCount();
		List<Comment> rootCommentList=(List<Comment>)commentResult.getRootComment();
		List<Comment> footCommentList=(List<Comment>)commentResult.getFootComment();
		
		//调用服务，获取文章点赞量的排行榜数据返回
		List<TbContent> conntentListOrderByAdmire=contentService.contentSortedByAdmire();
		//System.out.println(conntentListOrderByAdmire.get(1));
		model.addAttribute("content", content);
		//浏览量排行榜
	    model.addAttribute("conntentListOrderByBrowse", conntentListOrderByBrowse);
	    //点赞量排行榜
		model.addAttribute("conntentListOrderByAdmire", conntentListOrderByAdmire);
		//将评论相关信息，发送给页面
		model.addAttribute("commentCount", commentCount);
		model.addAttribute("rootCommentList", rootCommentList);
		model.addAttribute("footCommentList", footCommentList);
		return "blog_info";
	}
	/**
	 * 调用服务增加点赞数
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/blog/admire/{id}")
	@ResponseBody
	public String addAdmire(@PathVariable Long id){
		//调用servcie 
		YangResult reslut=contentService.addAdmire(id);
		//将结果序列化为json
		String result1=JsonUtils.objectToJson(reslut);
		return result1;
		
	}
	/**
	 * 调用服务获取某一分类下的文章，page是页码
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/blog/categorylist/{page}/{id}")
	public String getContentListByCat(@PathVariable Long id,@PathVariable int page,Model model){
		//调用servcie 
		EasyUIResult result=contentService.getContentListByCat(page, id);
		int count=result.getTotal();
		List<TbContent> listInOnePage=(List<TbContent>) result.getRows();
		//System.out.println("-------------------------------------------------------------------");
		//System.out.println(count);
		int totalSize=0;
		if(count%3==0){
			totalSize=count/3;
		}else{
			totalSize=count/3+1;
		}
		model.addAttribute("count",count);
		model.addAttribute("categoryId",id);
		model.addAttribute("totalSize",totalSize);
		model.addAttribute("currentPage",page);
		model.addAttribute("listInOnePage",listInOnePage);
		return "blog_list";
		
	}
	

}
