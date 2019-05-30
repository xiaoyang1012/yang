package com.yang.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.service.WordWallService;
import com.yang.util.EasyUIResult;
import com.yang.util.YangResult;
/**
 * 用来管理用户留言的controller
 * @author 小仰
 *
 */
@Controller
public class WordWallController {
	@Autowired
	private WordWallService wordWallService;
	
	/**
	 * 展示所有的留言
	 */
	@RequestMapping("/words/list")
	@ResponseBody
	public EasyUIResult getAllWords(Integer page,Integer rows){
		EasyUIResult result=wordWallService.showAllWords(page,rows);
		return result;
	}
	/**
	 * 删除指定的wordWall
	 */
	@RequestMapping("/rest/words/delete")
	@ResponseBody
	public YangResult deleteWords(String ids){
		YangResult result=wordWallService.deleteWordsByPrimaryKey(ids);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_SYNC_URL);
		return result;
	}
	
	/**
	 * 审核通过留言
	 * @param ids
	 * @return
	 */
	@RequestMapping("/rest/words/pass")
	@ResponseBody
	public YangResult passWrods(String ids){
		YangResult result=wordWallService.passWords(ids);
		//content内容发生改变，应该调用服务同步redis缓存
	//	HttpClientUtil.doGet(REST_BASE_URL+CONTENT_SYNC_URL);
		return result;
	}

}
