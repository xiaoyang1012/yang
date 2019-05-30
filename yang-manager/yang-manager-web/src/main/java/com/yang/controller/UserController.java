package com.yang.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.yang.pojo.user;
import com.yang.service.UserService;
import com.yang.util.YangResult;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@Autowired 
	HttpServletRequest request;

	@RequestMapping("/login/hello")
	@ResponseBody
	public YangResult login(String name,String password,Model model) throws Exception{
		//解决乱码问题
	//	String name1=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		HttpSession session=request.getSession();
		YangResult result=service.Login(name, password);
		System.out.println("name:"+name+"----password:"+result.getStatus());
		//将用户名存在session中
		if(result.getStatus()==200){
			session.setAttribute("username",name);
			/*
			 *以下是初始化首页需要的展示内容  
			 */
			//1：将用户名称发送给前台，用于展示
			model.addAttribute("username", name);
			//将用户的标识传递给界面     对应用户表里面的introduction字段
			user user=(user) result.getData();
			model.addAttribute("introduction",user);
		}
		return result;
	}
	/**
	 * 用户注销登陆
	 * @param name
	 * @param password
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("/logout/bye")
	public ModelAndView logout() throws Exception{
		//解决乱码问题
	//	String name1=new String(name.getBytes("ISO-8859-1"),"UTF-8");
		HttpSession session=request.getSession();
		if(session.getAttribute("username")!=null&&!"".equals(session.getAttribute("username"))){
			//将用户信息从session中清除
			session.removeAttribute("username");
		}
		
		return new ModelAndView("redirect:/login");
	}
	
	
}

