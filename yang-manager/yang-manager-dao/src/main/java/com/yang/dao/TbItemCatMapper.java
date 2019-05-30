package com.yang.dao;

import java.util.List;

import com.yang.pojo.ItemCatNode;
import com.yang.pojo.TbItemCat;


public interface TbItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TbItemCat record);

    int insertSelective(TbItemCat record);

    TbItemCat selectByPrimaryKey(Long id);
    
    List<TbItemCat> selectByParentId(Long parentid);
    
    List<ItemCatNode> selectAllChirld();
    
    String seletCatByID(Long id);

    int updateByPrimaryKeySelective(TbItemCat record);

    int updateByPrimaryKey(TbItemCat record);
    Long selectParentId(Long id);
}