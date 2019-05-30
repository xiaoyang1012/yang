package com.yang.portal.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;
import com.yang.pojo.TbItemCat;
import com.yang.portal.service.TbContentService;
import com.yang.util.CommentResult;
import com.yang.util.EasyUIResult;
import com.yang.util.HttpClientUtil;
import com.yang.util.JsonUtils;
import com.yang.util.YangResult;
/**
 * 调用服务端的方法来获取cotent内容，并且组装好发送给controller
 * @author 小仰
 *
 */
@Service
public class TbContentServiceImpl implements TbContentService {
	
	Logger logger = Logger.getLogger(TbContentServiceImpl. class );

	//导入url
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${REST_CONTENT_URL}")
	private String REST_CONTENT_URL;
	
	@Value("${REST_CAT_URL}")
	private String REST_CAT_URL;
	
	@Value("${GET_ONE_CONTENT_URL}")
	private String GET_ONE_CONTENT_URL;

	@Value("${CONTENT_BROWSE_LIST}")
	private String CONTENT_BROWSE_LIST;
	
	@Value("${ADD_ADMIRE_URL}")
	private String ADD_ADMIRE_URL;
	
	@Value("${CONTENT_ADMIRE_LIST}")
	private String CONTENT_ADMIRE_LIST;
	
	@Value("${CONTENT_CAT_LIST}")
	private String CONTENT_CAT_LIST;
	
	@Value("${COMMENT_LIST_URL}")
	private String COMMENT_LIST_URL;
	
	
	@Override
	public List<Object> getContent() {
		// 获取文章类目列表
		String contentCat=HttpClientUtil.doGet(REST_BASE_URL+REST_CAT_URL);
		// 获取文章列表
		String contentlist=HttpClientUtil.doGet(REST_BASE_URL+REST_CONTENT_URL);
		//将获得的json转换成pojo对象
		YangResult catResult=YangResult.formatToList(contentCat, TbItemCat.class);
		List<TbItemCat> catList=(List<TbItemCat>) catResult.getData();
		logger.info("get catList size:"+catList.size());
		YangResult contentResult=YangResult.formatToList(contentlist, ContentWithCat.class);
		List<TbContent> contentList=(List<TbContent>) contentResult.getData();
		logger.info("get contentList size:"+contentList.size());
		List<Object> list=new ArrayList<Object>();
		list.add(catList);
		list.add(contentList);
		return list;
	}


	@Override
	public ContentWithCat getOneContent(Long id) {
		// 获取文章
		String content=HttpClientUtil.doGet(REST_BASE_URL+GET_ONE_CONTENT_URL+id);
		//将获得的json转换成pojo对象
		YangResult contentResult=YangResult.formatToPojo(content, ContentWithCat.class);
		ContentWithCat oneContent=(ContentWithCat) contentResult.getData();
		return oneContent;
	}


	/**
	 * 阅读排行榜
	 */
	@Override
	public List<TbContent> contentSortedByBrowse() {
		// 获取排行列表
		String list=HttpClientUtil.doGet(REST_BASE_URL+CONTENT_BROWSE_LIST);
		YangResult contentList=YangResult.formatToList(list, TbContent.class);
		List<TbContent> result=(List<TbContent>) contentList.getData();
		return result;
	}


	@Override
	public YangResult addAdmire(Long id) {
		//增加点赞数
		String list=HttpClientUtil.doGet(REST_BASE_URL+ADD_ADMIRE_URL+id);
		YangResult result=YangResult.format(list);
			return result;
		
	}
	/**
	 * 点赞排行榜
	 */
	@Override
	public List<TbContent> contentSortedByAdmire() {
		// 获取排行列表
		String list=HttpClientUtil.doGet(REST_BASE_URL+CONTENT_ADMIRE_LIST);
		YangResult contentList=YangResult.formatToList(list, TbContent.class);
		List<TbContent> result=(List<TbContent>) contentList.getData();
		return result;
	}


	/**
	 * 根据id和页码取出某一个分类下的文章列表
	 */
	@Override
	public EasyUIResult getContentListByCat(int page, long id) {
		// 调用webService
		String list=HttpClientUtil.doGet(REST_BASE_URL+CONTENT_CAT_LIST+page+"/"+id);
		
		//将获得的json转换成pojo对象
		EasyUIResult contentResult=JsonUtils.jsonToPojo(list, EasyUIResult.class);
		
		return contentResult;
	}


	/**
	 * 调用服务获取一个文章下面的所有评论的列表
	 */
	@Override
	public CommentResult getCommentList(Long id) {
		// 调用webService
		String comment_list_json=HttpClientUtil.doGet(REST_BASE_URL+COMMENT_LIST_URL+id);
		CommentResult commentResult=JsonUtils.jsonToPojo(comment_list_json, CommentResult.class);
		
		return commentResult;
	}



}
