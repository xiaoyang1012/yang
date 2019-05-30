package com.yang.portal.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.portal.service.SearchServicePortal;
import com.yang.util.SearchResult;



@Controller
public class SearchController {

	@Autowired
	private SearchServicePortal searchService;
	
	@RequestMapping("/blog/search")
	public String Search(@RequestParam("q")String keyword, 
			@RequestParam(defaultValue="1")Long page, 
			 Model model){
		//get乱码处理
		try {
			keyword = new String(keyword.getBytes("iso8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			keyword = "";
			e.printStackTrace();
		}
		SearchResult searchResult = searchService.search(keyword, page);
			//将文章列表返回
			model.addAttribute("listInOnePage",searchResult.getContentList());
			model.addAttribute("currentPage", searchResult.getPageCount());
			model.addAttribute("totalSize",searchResult.getPageCount());
		return "search_list";
	}
}
