package com.yang.util;

import java.util.List;

public class CommentResult {
	private List<?> rootComment;
	private List<?> footComment;
	private int count;
	private int status;
	private String message;
	
	public List<?> getRootComment() {
		return rootComment;
	}
	public void setRootComment(List<?> rootComment) {
		this.rootComment = rootComment;
	}
	public List<?> getFootComment() {
		return footComment;
	}
	public void setFootComment(List<?> footComment) {
		this.footComment = footComment;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
