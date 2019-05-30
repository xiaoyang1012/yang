package com.yang.rest.service.impl;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yang.dao.TbContentMapper;
import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;
import com.yang.rest.component.JedisClient;
import com.yang.rest.service.TbContentService;
import com.yang.util.EasyUIResult;
import com.yang.util.JsonUtils;
@Service
public class TbContentServiceImpl implements TbContentService {
	
	Logger logger=Logger.getLogger(TbContentServiceImpl.class);
	
	@Autowired
	private TbContentMapper contentMapper;
	//注入JedidClient实现缓存
	@Autowired
	private JedisClient jedisClient;
	
	@Override
	public List<ContentWithCat> selectContent() {
		//在查询数据库之前应该先查询缓存中是否有记录，如果有，就直接返回
//		try{
//			//添加缓存，我为了规范key使用hset
//			String json=jedisClient.hget("content", "pushed");
//			if(json!=null&&!"".equals(json)){
//				//将json转换成list
//				List<ContentWithCat> list=JsonUtils.jsonToList(json, ContentWithCat.class);
//				return list;
//			}
//		}catch(Exception e){}
		//查询tbcontent表中所有状态为‘已发布’的内容
		List<ContentWithCat> list=contentMapper.selectAllPushed();
		logger.info("rest   ----selectContent size:"+list.size());
		//返回结果之前应该向缓存中添加数据  为了不影响正常的逻辑，添加try
//		try{
//			//添加缓存，我为了规范key使用hset
//			jedisClient.hset("content", "pushed", JsonUtils.objectToJson(list));
//		}catch(Exception e){}
		return list;
	}
	@Override
	public ContentWithCat selectOneContent(Long id) {
		//在查询数据库之前应该先查询缓存中是否有记录，如果有，就直接返回
//		try{
//			//添加缓存，我为了规范key使用hset
//			String json=jedisClient.hget("content", id+"");
//			if(json!=null&&!"".equals(json)){
//				//将json转换成ContentWithCat
//				ContentWithCat content=JsonUtils.jsonToPojo(json, ContentWithCat.class);
//				return content;
//			}
//		}catch(Exception e){}
		
		// 根据id查询文章
		ContentWithCat content=contentMapper.selectOneContent(id);
		//相当于浏览一次，那么文章的浏览量就应该加1
		addBrowse(id);
		
		//返回结果之前应该向缓存中添加数据  为了不影响正常的逻辑，添加try
//		try{
//			//添加缓存，我为了规范key使用hset
//			jedisClient.hset("content",id+"", JsonUtils.objectToJson(content));
//		}catch(Exception e){}
		
		return content;
	}
	@Override
	public List<TbContent> contentSortedByBrowse() {
		//在查询数据库之前应该先查询缓存中是否有记录，如果有，就直接返回
//		try{
//			//添加缓存，我为了规范key使用hset
//			String json=jedisClient.get("contentsortedbybrowse");
//			if(json!=null&&!"".equals(json)){
//				//将json转换成list
//				List<TbContent> list=JsonUtils.jsonToList(json, TbContent.class);
//				return list;
//			}
//		}catch(Exception e){}
		// 查询content按照浏览量排序
		List<TbContent> list=contentMapper.contentSortedByBrowse();
		
		//返回结果之前应该向缓存中添加数据  为了不影响正常的逻辑，添加try
//		try{
//			//添加缓存，我为了规范key使用hset
//			jedisClient.set("contentsortedbybrowse", JsonUtils.objectToJson(list));
//			//浏览量排行榜缓存每天刷新一次
//			jedisClient.expire("contentsortedbybrowse", 60*60*24);
//		}catch(Exception e){}
		return list;
	}
	@Override
	public void addBrowse(Long id) {
		// 浏览量加1 
		contentMapper.addBrowse(id);	
	}
	@Override
	public void addAdmire(Long id) {
		// 点赞数加一
		contentMapper.addAdmire(id);
		
	}
	/**
	 * service:点赞排行榜
	 */
	@Override
	public List<TbContent> contentSortedByAdmire() {
		//在查询数据库之前应该先查询缓存中是否有记录，如果有，就直接返回
//		try{
//			//添加缓存，我为了规范key使用hset
//			String json=jedisClient.get("contentsortedbyadmire");
//			if(json!=null&&!"".equals(json)){
//				//将json转换成list
//				List<TbContent> list=JsonUtils.jsonToList(json, TbContent.class);
//				return list;
//			}
//		}catch(Exception e){}
		
		// 查询content按照点赞量排序
		List<TbContent> list=contentMapper.contentSortedByAdmire();
		
		//返回结果之前应该向缓存中添加数据  为了不影响正常的逻辑，添加try
//		try{
//			//添加缓存，我为了规范key使用hset
//			jedisClient.set("contensortedbyadmire", JsonUtils.objectToJson(list));
//			//点赞量排行榜缓存每天刷新一次
//			jedisClient.expire("contensortedbyadmire", 60*60*24);
//		}catch(Exception e){}
		return list;
	}
	
	
	@Override
	public EasyUIResult selectOneCatList(Long id,int page) {
		//初始化分页插件
		PageHelper.startPage(page,3);
		EasyUIResult result=new EasyUIResult();
//		//-----------------------------------------------------
//		//在查询数据库之前应该先查询缓存中是否有记录，如果有，就直接返回
//		try{
//			//添加缓存，我为了规范key使用hset
//			String json=jedisClient.hget("Onecatlist",id+"");
//			if(json!=null&&!"".equals(json)){
//				//将json转换成list
//				List<ContentWithCat> list=JsonUtils.jsonToList(json, ContentWithCat.class);
//				PageInfo<ContentWithCat> info=new PageInfo<ContentWithCat>(list);
//				result.setRows(list);
//				result.setTotal((int)(info.getTotal()));
//				return result;
//			}
//		}catch(Exception e){}
		//----------------------------
		List<ContentWithCat> list=contentMapper.selectOneCatList(id);
		PageInfo<ContentWithCat> info=new PageInfo<ContentWithCat>(list);
		result.setRows(list);
		result.setTotal((int)(info.getTotal()));
//		//-------------------------------------
//		//返回结果之前应该向缓存中添加数据  为了不影响正常的逻辑，添加try
//		try{
//			//添加缓存，我为了规范key使用hset
//			jedisClient.hset("Onecatlist", id+"", JsonUtils.objectToJson(result));
//		}catch(Exception e){}
//		//-----------------------------
//		
		return result;
	}
	

}
