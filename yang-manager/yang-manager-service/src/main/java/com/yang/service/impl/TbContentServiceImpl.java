package com.yang.service.impl;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.dao.TbContentMapper;
import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;

import com.yang.service.TbContentService;
import com.yang.util.EasyUIResult;
import com.yang.util.HttpClientUtil;
import com.yang.util.IDUtils;
import com.yang.util.YangResult;
@Service
public class TbContentServiceImpl implements TbContentService {
	
	Logger logger = Logger.getLogger(TbContentServiceImpl. class );

	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	@Value("${CONTENT_ONE_URL}")
	private String CONTENT_ONE_URL;
	@Autowired
	private TbContentMapper contentDao;
	@Autowired 
	HttpServletRequest request;
	
	
	public EasyUIResult selectAll(int page,int rows) {
		PageHelper.startPage(page,rows);
		List<ContentWithCat> list;
//		if(id+""==null ||"".equals(id+"")){
			list=contentDao.selectAll();
//		}else{
//			list=contentDao.selectOneCatList(id);
//		}
		
		PageInfo<ContentWithCat> info=new PageInfo<ContentWithCat>(list);
		EasyUIResult result=new EasyUIResult();
		result.setRows(list);
		result.setTotal((int)(info.getTotal()));
		logger.info("get all content!size:"+list.size());
		return result;
	}
	
	public YangResult deleteByPrimaryKey(String id) {
		String[] ids=id.split(",");
		for(String result:ids){
			contentDao.deleteByPrimaryKey(result);
			//此时应该删除该id对用文章的缓存
			//HttpClientUtil.doGet(REST_BASE_URL+CONTENT_ONE_URL+result);
		}
		
		return YangResult.ok();
	}

	/**
	 * 撤回一篇文章
	 */
	
	public YangResult RollBackBlog(String id) {
		logger.error("yxl test chehui");
		String[] ids=id.split(",");
		for(String result:ids){
			contentDao.rollBackBlog(result);
		}
		return YangResult.ok();
	}

	/**
	 * 发布一篇文章
	 */
	
	public YangResult releaseBlog(String id) {
		String[] ids=id.split(",");
		for(String result:ids){
			contentDao.releaseBlog(result);
		}
		return YangResult.ok(); 
	}

	/**
	 * 新建一篇文章
	 */
	@Override
	public YangResult insertContent(TbContent con,Integer categoryId) {
		// 生成ID
		String id=IDUtils.genId();
		//get session
		HttpSession session=request.getSession();
		//getname
		String name=(String)session.getAttribute("username");
		//补全属性
		con.setId(id);
		con.setStatus("草稿");
		con.setAdmire(0);
		con.setBrowse(0);
		Date date=new Date();
		con.setCreated(date);
		con.setUpdated(date);
		//con.setPic(pic);
		if(name!=null){
			con.setAuthor(name);
		}
		
		con.setCategory(categoryId);
		contentDao.insert(con);
		return YangResult.ok();
	}

	/**
	 * 编辑文章
	 */
	@Override
	public YangResult editContent(TbContent content) {
		// TODO Auto-generated method stub
		contentDao.updateByPrimaryKeySelective(content);
		return YangResult.ok();
	}

}
