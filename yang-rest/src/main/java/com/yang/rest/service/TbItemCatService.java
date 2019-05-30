package com.yang.rest.service;

import java.util.List;

import com.yang.pojo.ItemCatNode;



/**
 * 初始化文章类目
 * @author 小仰
 *
 */
public interface TbItemCatService {

	List<ItemCatNode> selectItemCat();
}
