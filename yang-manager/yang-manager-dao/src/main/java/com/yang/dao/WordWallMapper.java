package com.yang.dao;

import java.util.List;

import com.yang.pojo.WordWall;

public interface WordWallMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WordWall record);

    int insertSelective(WordWall record);

    WordWall selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WordWall record);

    int updateByPrimaryKey(WordWall record);
    
    List<WordWall> selectAllByCreated();
    
    List<WordWall> selectAllWords();
    
    void passWords(int id);
    
}