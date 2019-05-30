package com.yang.search.pojo;

import java.util.List;

import com.yang.pojo.ContentWithCat;



public class SearchResult {
	private List<ContentWithCat> contentList;
	private Long recordCount;
	private int pageCount;
	private int currentPage;
	public List<ContentWithCat> getContentList() {
		return contentList;
	}
	public void setContentList(List<ContentWithCat> contentList) {
		this.contentList = contentList;
	}
	public Long getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(Long recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	

}
