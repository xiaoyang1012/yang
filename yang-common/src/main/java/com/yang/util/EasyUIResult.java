package com.yang.util;

import java.util.List;

/**
 * EasyUI相应数据结构的pojo
 */
public class EasyUIResult {

	private Integer total;
	
	private List<?> rows;
	
	

	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
