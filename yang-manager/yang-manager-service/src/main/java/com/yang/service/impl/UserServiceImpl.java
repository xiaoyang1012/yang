package com.yang.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yang.dao.userMapper;
import com.yang.pojo.user;

import com.yang.service.UserService;
import com.yang.util.MD5Utils;
import com.yang.util.YangResult;
@Service
public class UserServiceImpl implements UserService  { 
	Logger logger = Logger.getLogger(UserServiceImpl. class );

	@Autowired
	private userMapper userdao;
	

	public YangResult Login(String name, String password) {
		//对密码进行加密
		String encryptPassword=MD5Utils.encrypt(password);
		//System.out.println("加密后的密码："+encryptPassword);
		user user=userdao.selectByName(name, encryptPassword);
		
		if(user==null||"".equals(user)){
			return YangResult.build(404,"用户名或密码错误!");	 
		}
		//set username to session
		return YangResult.ok(user);
	}
	
}
