package com.yang.service;

import java.util.List;

import com.yang.util.EasyUITreeNode;
import com.yang.util.YangResult;


public interface ItemCatService { 
	List<EasyUITreeNode> getItemCatList(long parentId);
	YangResult insertCat(Long parentId,String name);

	YangResult updateCat(Long id,String name);

	void deleteCat(Long id);
}
