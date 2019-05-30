package com.yang.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.dao.WordWallMapper;
import com.yang.pojo.WordWall;
import com.yang.service.WordWallService;
import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;
@Service
public class WordWallServiceImpl implements WordWallService {
	Logger logger = Logger.getLogger(WordWallServiceImpl. class );

	@Autowired
	private WordWallMapper mapper;
	/**
	 * 展示所有的留言
	 */
	@Override
	public EasyUIResult showAllWords(int page,int rows) {
		PageHelper.startPage(page,rows);
		List<WordWall> list=mapper.selectAllWords();
		PageInfo<WordWall> info=new PageInfo<WordWall>(list);
		EasyUIResult result=new EasyUIResult();
		result.setRows(list);
		result.setTotal((int)(info.getTotal()));
		// 从数据库中获取所有的留言
		logger.info("get all words size:"+list.size());
		return result;
	}
	/**
	 *根据id来删除不予通过的留言
	 */
	@Override
	public YangResult deleteWordsByPrimaryKey(String ids) {
		String[] id=ids.split(",");
		for(String result:id){
			int int_id=Integer.parseInt(result);
			mapper.deleteByPrimaryKey(int_id);
			//此时应该删除该id对用文章的缓存
			//HttpClientUtil.doGet(REST_BASE_URL+CONTENT_ONE_URL+result);
		}
		return YangResult.ok();
	}
	
	/**
	 * 审核通过留言
	 */
	@Override
	public YangResult passWords(String id) {
		String[] ids=id.split(",");
		for(String result:ids){
			int int_id=Integer.parseInt(result);
			mapper.passWords(int_id);
		}
		return YangResult.ok(); 
	}

}
