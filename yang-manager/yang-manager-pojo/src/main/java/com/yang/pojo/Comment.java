package com.yang.pojo;

import java.io.Serializable;   
import java.util.Date;

public class Comment implements Serializable{
    /** 
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String id;

    private String customerName;

    private String parentCommentId;

    private String contentId;

    private String content;

    private Date commentDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName == null ? null : customerName.trim();
    }

    public String getParentCommentId() {
        return parentCommentId;
    }

    public void setParentCommentId(String parentCommentId) {
        this.parentCommentId = parentCommentId == null ? null : parentCommentId.trim();
    }

    public String getContentId() {
        return contentId;
    }

    public void setContentId(String contentId) {
        this.contentId = contentId == null ? null : contentId.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Date getCommentDate() {
        return commentDate;
    }

    public void setCommentDate(Date commentDate) {
        this.commentDate = commentDate;
    }

	@Override
	public String toString() {
		return "Comment [commentDate=" + commentDate + ", content=" + content
				+ ", contentId=" + contentId + ", customerName=" + customerName
				+ ", id=" + id + ", parentCommentId=" + parentCommentId + "]";
	}
    
}