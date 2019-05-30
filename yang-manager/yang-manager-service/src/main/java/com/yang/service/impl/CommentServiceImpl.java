package com.yang.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.dao.CommentMapper;
import com.yang.pojo.Comment;
import com.yang.service.CommentService;
import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;
@Service
public class CommentServiceImpl implements CommentService {
	 Logger logger = Logger.getLogger(CommentServiceImpl. class );

	@Autowired
	private CommentMapper commentMapper;
	@Override
	public EasyUIResult getComentList(int page,int rows) {
		PageHelper.startPage(page,rows);
		List<Comment> list=commentMapper.getAllCommentList();
		logger.info("get comment list size:"+list.size());
		PageInfo<Comment> info=new PageInfo<Comment>(list);
		EasyUIResult result=new EasyUIResult();
		result.setRows(list);
		result.setTotal((int)(info.getTotal()));
		return result;
	}
	@Override
	public YangResult deleteSelectedComment(String ids) {
		String[] id=ids.split(",");
		for(String result:id){
			commentMapper.deleteByPrimaryKey(result);
			logger.info("success to delete comments");
			//此时应该删除该id对用文章的缓存
			//HttpClientUtil.doGet(REST_BASE_URL+CONTENT_ONE_URL+result);
		}
		return YangResult.ok();
		
	}
	@Override
	public EasyUIResult getSearchResult(String flag, String value,int page,int rows) {
		List<Comment> list=null;
		PageHelper.startPage(page,rows);
		//给like语句拼接%
		String value1="%"+value+"%";
		// 首先判断flag类型来决定执行哪一个操作
		if(flag=="1"||"1".equals(flag)){//按照名称查询
			list=commentMapper.searchCommentsByName(value1);
			logger.info("get search result by name-----size:"+list.size());
		}else if(flag=="2"||"2".equals(flag)){//按照内容查询
			list=commentMapper.searchCommentsByContent(value1);
			logger.info("get search result by content-----size:"+list.size());
		}
		//返回list
		
		PageInfo<Comment> info=new PageInfo<Comment>(list);
		EasyUIResult result=new EasyUIResult();
		result.setRows(list);
		result.setTotal((int)(info.getTotal()));
		return result;
	}

}
