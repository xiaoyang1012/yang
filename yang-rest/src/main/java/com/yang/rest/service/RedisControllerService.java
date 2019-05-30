package com.yang.rest.service;

import com.yang.util.YangResult;



public interface RedisControllerService {
	 
	YangResult delContentPushed();
	YangResult delCatListById(Integer id);
	YangResult delContentById(Integer id);

}
