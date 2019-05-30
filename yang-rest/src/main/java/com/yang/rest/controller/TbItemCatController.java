package com.yang.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yang.pojo.ItemCatNode;
import com.yang.rest.service.TbItemCatService;
import com.yang.util.ExceptionUtil;
import com.yang.util.YangResult;

/**
 * 发布服务获取所有的文章叶子分类
 * @author 小仰
 *
 */
@Controller
public class TbItemCatController {
	@Autowired
	private TbItemCatService catService;
	
	@RequestMapping("/itemcat/list")
	@ResponseBody
	public YangResult itemCatList(){
		try{
			List<ItemCatNode> list=catService.selectItemCat();
			return YangResult.ok(list);
		}catch(Exception e){
			e.printStackTrace();
			return YangResult.build(500,ExceptionUtil.getStackTrace(e));
		}
		
	}

}
