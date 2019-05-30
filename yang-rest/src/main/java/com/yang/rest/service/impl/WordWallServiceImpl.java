package com.yang.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dao.WordWallMapper;
import com.yang.pojo.WordWall;
import com.yang.rest.service.WordWallService;
import com.yang.util.YangResult;
@Service
public class WordWallServiceImpl implements WordWallService {

	@Autowired
	private WordWallMapper wordWallDao;

	@Override
	public YangResult insertWord(WordWall wordWall) {
		wordWallDao.insert(wordWall);
		YangResult result=new YangResult();
		result.setStatus(200);
		result.setMsg("成功插入留言！");
		return null;
	}

	@Override
	public List<WordWall> showWords() {
		List<WordWall> list=wordWallDao.selectAllByCreated();
		return list;
	}
	
	

}
