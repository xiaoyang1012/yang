package com.yang.pojo;

import java.io.Serializable;

/**
 *用来接收文章类目的pojo
 * @author 小仰
 *
 */
public class ItemCatNode implements Serializable{

	private Long id; 
	private String name;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
