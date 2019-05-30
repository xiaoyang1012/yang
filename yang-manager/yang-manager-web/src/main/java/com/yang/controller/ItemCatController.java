package com.yang.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.service.ItemCatService;
import com.yang.util.EasyUITreeNode;
import com.yang.util.HttpClientUtil;
import com.yang.util.YangResult;

@Controller
@RequestMapping("/content/category")
public class ItemCatController {
	@Value("${REST_BASE_URL}")
	private String REST_BASE_URL;
	
	@Value("${CAT_LIST_SYNC}")
	private String CAT_LIST_SYNC;
	
	
	
	
	
	
	@Autowired
	private ItemCatService itemcatservice;
	@RequestMapping("/list")
	@ResponseBody
	public List<EasyUITreeNode> getItemCatList(@RequestParam(value="id",defaultValue="0")long parentId){
		List<EasyUITreeNode> list=itemcatservice.getItemCatList(parentId);
		return list;
	}
	

	@RequestMapping("/create")
	@ResponseBody
	public YangResult insertItemCat(long parentId,String name){
		YangResult result=itemcatservice.insertCat(parentId, name);
		return result;
	}
	/**
	 * 更新类目名称
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/update")
	@ResponseBody
	public YangResult updateItemCat(long id,String name){
		YangResult result=itemcatservice.updateCat(id, name);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CAT_LIST_SYNC+id);
		return result;
	}
	
	/**
	 * 删除类目及其子类目
	 * @param id
	 * @param name
	 * @return
	 */
	@RequestMapping("/delete")
	@ResponseBody
	public void deleteItemCat(long id){
	itemcatservice.deleteCat(id);
	//content内容发生改变，应该调用服务同步redis缓存
//	HttpClientUtil.doGet(REST_BASE_URL+CAT_LIST_SYNC+id);
	}
	
	
}
