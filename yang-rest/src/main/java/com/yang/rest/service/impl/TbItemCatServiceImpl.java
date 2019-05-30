package com.yang.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dao.TbItemCatMapper;
import com.yang.pojo.ItemCatNode;

import com.yang.rest.service.TbItemCatService;
@Service
public class TbItemCatServiceImpl implements TbItemCatService {

	@Autowired
	private TbItemCatMapper catMapper;
	@Override
	public List<ItemCatNode> selectItemCat() {
		// 获取所有的叶子分类
		List<ItemCatNode> list=catMapper.selectAllChirld();
		return list;
	}

}
