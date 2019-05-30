package com.yang.rest.service;

import java.util.List;

import com.yang.pojo.WordWall;
import com.yang.util.YangResult;

/**
 * 留言墙接口
 * @author 小仰
 *
 */
public interface WordWallService {

	YangResult insertWord(WordWall wordWall);
	List<WordWall> showWords();
}
