package com.yang.portal.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.yang.pojo.TbContent;
import com.yang.pojo.TbItemCat;
import com.yang.pojo.WordWall;
import com.yang.portal.service.TbContentService;
import com.yang.portal.service.WordWallService;


/**
 * 显示首页的controller
 * @author 小仰
 *
 */
@Controller
public class IndexController {

	@Autowired
	private TbContentService contentservice;
	
	@Autowired
	private WordWallService wordService;
	
	
	
	@RequestMapping("/blog_index")
	public String showBlog_index(Model model){
		//调用服务，获取文章阅读量的排行榜数据返回
		List<TbContent> conntentListOrderByBrowse=contentservice.contentSortedByBrowse();
		//调用服务，获取文章点赞量的排行榜数据返回
		List<TbContent> conntentListOrderByAdmire=contentservice.contentSortedByAdmire();
		//System.out.println(conntentListOrderByAdmire.get(1));
		List<Object> list=contentservice.getContent();
		List<TbItemCat> catlist=(List<TbItemCat>) list.get(0);
		List<TbContent> contentList=(List<TbContent>)list.get(1);
		//首页展示留言墙
		List<WordWall> wordsWall=wordService.showAllWord();
		
		model.addAttribute("conntentListOrderByBrowse", conntentListOrderByBrowse);
		model.addAttribute("conntentListOrderByAdmire", conntentListOrderByAdmire);
		model.addAttribute("cat", catlist);
		model.addAttribute("content", contentList);
		model.addAttribute("wordsWall", wordsWall);
		return "blog_index";
	}
	
	@RequestMapping("/index")
	public String showIndex(Model model){
		return "index";
	}
	/**
	 * 留言板功能--初始化时候，需要到数据库或者缓存中查询留言记录
	 * @param model
	 * @return
	 */
	@RequestMapping("/wordwall")
	public String showWordWall(Model model){
		//展示留言
		List<WordWall> result=wordService.showAllWord();
		model.addAttribute("words", result);
		return "wordwall";
	}
	
	
	@RequestMapping("/resume")
	public String showResume(Model model){
//		//展示留言
//		List<WordWall> result=wordService.showAllWord();
//		model.addAttribute("words", result);
		return "resume";
	}
	
}
