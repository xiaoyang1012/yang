package com.yang.portal.service;

import java.util.List;

import com.yang.pojo.WordWall;
import com.yang.util.YangResult;

public interface WordWallService { 

	YangResult insertWord(WordWall wordWall);
	
	List<WordWall> showAllWord();
}
