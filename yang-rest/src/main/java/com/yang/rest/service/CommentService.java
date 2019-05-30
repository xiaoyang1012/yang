package com.yang.rest.service;



import com.yang.pojo.Comment;
import com.yang.util.CommentResult;
import com.yang.util.YangResult;

public interface CommentService {

	YangResult insertComment(Comment comment);
	CommentResult getCommentListInfoById(Long id);
}
