package com.yang.portal.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.WordWall;
import com.yang.portal.service.WordWallService;
import com.yang.util.YangResult;

@Controller
public class WordWallController {

	@Autowired
	private WordWallService wordService;
	/**
	 * 插入一条留言
	 * @param wordWall
	 * @return
	 */
	@RequestMapping("/wordwall/insert")
	@ResponseBody
	public YangResult insertWord(WordWall wordWall){
		System.out.println(wordWall.getName()+"---"+wordWall.getMessage());
		YangResult result=wordService.insertWord(wordWall);
		result.setStatus(200);
		return result;
	}
	
	
	
}
