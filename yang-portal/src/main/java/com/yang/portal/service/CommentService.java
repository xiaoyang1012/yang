package com.yang.portal.service;

import com.yang.pojo.Comment;
import com.yang.util.YangResult;

public interface CommentService {

	YangResult insertComment(Comment comment,Long id);
}
