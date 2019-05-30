package com.yang.util;

import java.util.List;

public class SearchResult {
	private List<?> contentList;
	private Long recordCount;
	private int pageCount;
	private int currentPage;
	
	public List<?> getContentList() {
		return contentList;
	}
	public void setContentList(List<?> contentList) {
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
