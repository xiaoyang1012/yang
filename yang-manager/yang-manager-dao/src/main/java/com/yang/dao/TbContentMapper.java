package com.yang.dao;

import java.util.List;

import com.yang.pojo.ContentWithCat;
import com.yang.pojo.TbContent;



public interface TbContentMapper {
    

    int insert(TbContent record);

    int insertSelective(TbContent record);

   void deleteByPrimaryKey(String string);
   
   void rollBackBlog(String string);
   
   void releaseBlog(String string);
   
    List<ContentWithCat> selectAll();
    
    List<ContentWithCat> selectOneCatList(Long id);
    
    void addBrowse(Long id);
    
    void addAdmire(Long id);
    
    
    List<TbContent> contentSortedByBrowse();
    
    List<TbContent> contentSortedByAdmire();
    
    ContentWithCat selectOneContent(Long id);
    
    List<ContentWithCat> selectAllPushed();

    int updateByPrimaryKeySelective(TbContent record);

    int updateByPrimaryKeyWithBLOBs(TbContent record);

    int updateByPrimaryKey(TbContent record);
}