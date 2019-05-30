package com.yang.dao;

import org.apache.ibatis.annotations.Param;

import com.yang.pojo.user;



public interface userMapper {
    int deleteByPrimaryKey(String id);

    int insert(user record);

    int insertSelective(user record);

    user selectByPrimaryKey(String id);
    
    user selectByName(@Param("name")String name,@Param("password")String password);

    int updateByPrimaryKeySelective(user record);

    int updateByPrimaryKey(user record);
}