package com.yang.service;

import com.yang.util.YangResult;


public interface UserService {
 
	YangResult Login(String name,String password);
}
