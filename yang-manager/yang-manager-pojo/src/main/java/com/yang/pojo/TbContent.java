package com.yang.pojo;

import java.io.Serializable;
import java.util.Date;

public class TbContent implements Serializable{
	private String id;
	private Integer category;
	private String title;
	private String author;
	private String url; 
	private String pic; 
	private String pic2;
	private String content;
	private Date created;
	private Date updated;
	private Integer browse;
	private Integer admire;
	private String status;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getCategory() {
		return category;
	}
	public void setCategory(Integer category) {
		this.category = category;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getPic2() {
		return pic2;
	}
	public void setPic2(String pic2) {
		this.pic2 = pic2;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getCreated() {
		return created;
	}
	public void setCreated(Date created) {
		this.created = created;
	}
	public Date getUpdated() {
		return updated;
	}
	public void setUpdated(Date updated) {
		this.updated = updated;
	}
	public Integer getBrowse() {
		return browse;
	}
	public void setBrowse(Integer browse) {
		this.browse = browse;
	}
	public Integer getAdmire() {
		return admire;
	}
	public void setAdmire(Integer admire) {
		this.admire = admire;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
