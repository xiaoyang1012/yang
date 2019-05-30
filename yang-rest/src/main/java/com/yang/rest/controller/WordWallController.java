package com.yang.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.WordWall;
import com.yang.rest.service.WordWallService;
import com.yang.util.YangResult;
/**
 * 留言墙功能模块，发布服务新建一条留言
 * @author 小仰
 *
 */
@Controller
public class WordWallController {
	@Autowired
	private WordWallService service;
	/*
	 * 插入一条数据
	 */
	@RequestMapping("/wordwall/insert")
	@ResponseBody
	public YangResult insertWord(WordWall wordWall){
		System.out.println(wordWall.getName()+"----"+wordWall.getMessage());
		YangResult result=service.insertWord(wordWall);
		return result;
	}
	/**
	 * 获取所有的数据
	 * @param wordWall
	 * @return
	 */
	@RequestMapping("/wordwall/showall")
	@ResponseBody
	public YangResult getAllWord(){
		List<WordWall> list=service.showWords();
		YangResult result=new YangResult();
		result.setData(list);
		result.setStatus(200);
		return result;
	}

}
