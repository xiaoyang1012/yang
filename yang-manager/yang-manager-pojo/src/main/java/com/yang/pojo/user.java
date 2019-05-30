package com.yang.pojo;

import java.io.Serializable;
import java.util.Date;

public class user implements Serializable {

	private Integer id;
	private String name;
	private String password;
	private Date creatime;
	private Date updatime; 
	private Integer phone;
	private String picture;
	private String introduction;
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Date getCreatime() {
		return creatime;
	}
	public void setCreatime(Date creatime) {
		this.creatime = creatime;
	}
	public Date getUpdatime() {
		return updatime;
	}
	public void setUpdatime(Date updatime) {
		this.updatime = updatime;
	}
	public Integer getPhone() {
		return phone;
	}
	public void setPhone(Integer phone) {
		this.phone = phone;
	}
	
}
