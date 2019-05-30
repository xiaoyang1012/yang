package com.yang.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.yang.service.impl.WordWallServiceImpl;

public class LoginInterceptor implements HandlerInterceptor {
	Logger logger = Logger.getLogger(LoginInterceptor. class );
 
	 @Override
	  public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
	    Object user = request.getSession().getAttribute("username");
	    if (user == null) {
	      logger.info("尚未登录，调到登录页面");
	      response.sendRedirect("/");
	      return false;
	    }
	    return true;
	  }
	 
	  @Override
	  public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//		  Object user = request.getSession().getAttribute("username");
//		  
//	    System.out.println(user+"postHandle");
	  }
	 
	  @Override
	  public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//		  Object user = request.getSession().getAttribute("username");
//	    System.out.println(user+"afterCompletion");
	  }
}
