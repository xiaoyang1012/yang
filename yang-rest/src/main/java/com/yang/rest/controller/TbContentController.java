package com.yang.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;
import com.yang.rest.service.TbContentService;
import com.yang.util.EasyUIResult;
import com.yang.util.ExceptionUtil;
import com.yang.util.JsonUtils;
import com.yang.util.YangResult;
/**
 * 发布服务获取content
 * @author 小仰
 *
 */
@Controller
public class TbContentController {

	@Autowired
	private TbContentService contentService;
	
	@RequestMapping("/content/list")
	@ResponseBody
	public YangResult contentList(){
		try{
			List<ContentWithCat> list=contentService.selectContent();
			return YangResult.ok(list);
		}catch(Exception e){
			e.printStackTrace();
			return YangResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	/**
	 * 根据id查询某一个content
	 * @return
	 */
	@RequestMapping("/blog/info/{id}")
	@ResponseBody
	public YangResult selectOneContenet(@PathVariable Long id){
		try{
			ContentWithCat content=contentService.selectOneContent(id);
			return YangResult.ok(content);
		}catch(Exception e){
			e.printStackTrace();
			return YangResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	/**
	 * 获取content的阅读量排行榜
	 * @return
	 */
	@RequestMapping("/blog/browselist")
	@ResponseBody
	public YangResult contentSortedByBrowse(){
		try{
			List<TbContent> list=contentService.contentSortedByBrowse();
			return YangResult.ok(list);
		}catch(Exception e){
			e.printStackTrace();
			return YangResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	/**
	 * 获取content的点赞量排行榜
	 * @return
	 */
	@RequestMapping("/blog/admirelist")
	@ResponseBody
	public YangResult contentSortedByAdmire(){
		try{
			List<TbContent> list=contentService.contentSortedByAdmire();
			return YangResult.ok(list);
		}catch(Exception e){
			e.printStackTrace();
			return YangResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}
	
	/**
	 * 获取content的阅读量排行榜
	 * @return
	 */
	@RequestMapping("/blog/admire/{id}")
	@ResponseBody
	public YangResult admire(@PathVariable Long id){
		try{
			contentService.addAdmire(id);
			return YangResult.ok();
		}catch(Exception e){
			e.printStackTrace();
			return YangResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}
	/**
	 * 调用服务根据分类id获取文章列表，而且带有分页
	 * @param id
	 * @param model
	 * @return
	 */
	
	@RequestMapping(value = "/blog/categorylist/{page}/{id}",method = RequestMethod.GET,produces = "text/html;charset=UTF-8")
	@ResponseBody
	public String selectOneCatList(@PathVariable Long id,@PathVariable int page){
		//调用servcie 
		EasyUIResult result=contentService.selectOneCatList(id,page);
		
		//将结果序列化为json
		String result1=JsonUtils.objectToJson(result);
		return result1;
		
	}
	
}
