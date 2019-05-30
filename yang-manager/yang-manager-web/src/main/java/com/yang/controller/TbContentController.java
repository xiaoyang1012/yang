package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.TbContent;
import com.yang.service.TbContentService;
import com.yang.util.EasyUIResult;
import com.yang.util.HttpClientUtil;
import com.yang.util.YangResult;

@Controller
public class TbContentController {
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${CONTENT_SYNC_URL}")
	private String CONTENT_SYNC_URL;
	
	@Value("${CONTENT_ONE_URL}")
	private String CONTENT_ONE_URL;

	@Autowired
	private TbContentService contentservice;
	/**
	 * 获取所有文章
	 * @param page
	 * @param rows
	 * @return
	 */
	@RequestMapping("/content/query/list")
	@ResponseBody
	public EasyUIResult showBlog(Integer page,Integer rows,String category){
		System.out.println("category值是："+category);
		//int id1=Integer.parseInt(id);
		//long id2=(long)id1;
		EasyUIResult result=contentservice.selectAll(page,rows);
		return result;
	}
	/**
	 * 删除
	 * @param ids
	 * @return
	 */
	@RequestMapping("/rest/item/delete")
	@ResponseBody
	public YangResult deleteBlog(String ids){
		YangResult result=contentservice.deleteByPrimaryKey(ids);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_SYNC_URL);
		return result;
	}
	/**
	 * 撤回文章
	 * @param ids
	 * @return
	 */
	@RequestMapping("/rest/item/instock")
	@ResponseBody
	public YangResult rollBackBlog(String ids){
		YangResult result=contentservice.RollBackBlog(ids);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_SYNC_URL);
		return result;
	}
	/**
	 * 发布文章
	 * @param ids
	 * @return
	 */
	@RequestMapping("/rest/item/reshelf")
	@ResponseBody
	public YangResult releaseBlog(String ids){
		YangResult result=contentservice.releaseBlog(ids);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_SYNC_URL);
		return result;
	}
	/**
	 * 插入文章
	 * @param con
	 * @param categoryId
	 * @return
	 */
	@RequestMapping("/item/save")
	@ResponseBody
	public YangResult insertBlog(TbContent con,Integer categoryId){
		YangResult result=contentservice.insertContent(con,categoryId);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_SYNC_URL);
		return result;
	}
	
	@RequestMapping("/rest/item/edit")
	@ResponseBody
	public YangResult edittBlog(TbContent con){
		int id1=0;
		//System.out.println(con.getId());
		YangResult result=contentservice.editContent(con);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_SYNC_URL);
		//此时应该删除该id对用文章的缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_ONE_URL+con.getId());
		return result;
	}
}
