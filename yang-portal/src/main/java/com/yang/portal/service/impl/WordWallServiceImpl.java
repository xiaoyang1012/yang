package com.yang.portal.service.impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;
import com.yang.pojo.TbItemCat;
import com.yang.pojo.WordWall;
import com.yang.portal.service.WordWallService;
import com.yang.util.HttpClientUtil;
import com.yang.util.YangResult;
@Service
public class WordWallServiceImpl implements WordWallService {
	
	Logger logger = Logger.getLogger(WordWallServiceImpl. class );

	//导入url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${WORDWALL_INSERT_URL}")
	private String WORDWALL_INSERT_URL;
	
	@Value("${WORDWALL_SHOW_ALL_URL}")
	private String WORDWALL_SHOW_ALL_URL;
	
	
	@Override
	public YangResult insertWord(WordWall wordWall) {
		//首先要补全wordwall的属性
		if(wordWall.getName()==null||"".equals(wordWall.getName())){//用户匿名留言
			wordWall.setName("匿名网友");
		}
		wordWall.setCreated(new Date());
		// 调用httpClient  向服务端发送插入留言墙的请求
		// 调用rest发布的服务
		//	System.out.println(comment.toString());
			Map<String,String> param =new HashMap<String,String>();
			//生成参数
			param.put("name", wordWall.getName());
			param.put("message", wordWall.getMessage());
			param.put("created", wordWall.getCreated().toString());
			param.put("status", "0");
			
			//发出post请求，插入评论到数据库
			HttpClientUtil.doPost(REST_BASE_URL+WORDWALL_INSERT_URL, param);
			logger.info("success to send a post request to insert a word");
			YangResult result=new YangResult();
			result.setMsg("插入成功");
		return result;
	}


	@Override
	public List<WordWall> showAllWord() {
		//发出post请求，插入评论到数据库
		String json=HttpClientUtil.doGet(REST_BASE_URL+WORDWALL_SHOW_ALL_URL);
		//将获得的json转换成pojo对象
		YangResult result=YangResult.formatToList(json, WordWall.class);
		List<WordWall> wordList=(List<WordWall>) result.getData();
		logger.info("get all words size:"+wordList.size());
		return wordList;
	}

	

}
