package com.yang.dao;

import java.util.List;

import com.yang.pojo.Comment;



public interface CommentMapper {
    int deleteByPrimaryKey(String id);

    int insert(Comment record);

    int insertSelective(Comment record);

    Comment selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKey(Comment record);
    
    List<Comment> getCommentListByContentId(String id);
    
    List<Comment> getAllCommentList();
    
    List<Comment> searchCommentsByName(String value);
    
    List<Comment> searchCommentsByContent(String value);
}