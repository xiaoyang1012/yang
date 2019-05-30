<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script type="text/javascript">
	function logout(){
		 if (confirm("你确定要退出吗？")) {  
            location.href="logout/bye";
        }  
        else {  
              
        }  
		
	}
</script>
<div id="cc" class="easyui-layout" style="width:1000px;height:600px;">
    <div data-options="region:'north',split:true" style="height:100px;text-align: center;line-height: 50px;">
    	<h1>欢迎来到小仰的网站后台管理系统</h1>
    </div>
    <div data-options="region:'south',title:'South Title',split:true" style="height:200px;"></div>
    <div data-options="region:'east',title:'East',split:true" style="width:250px;"></div>
    <div data-options="region:'west',title:'用户信息',split:true" style="width:250px;">
    	<table>
    		<tr><td>当前登陆用户:${username}</td></tr>
    		<tr><td>用户标识:站长</td></tr>
    		<tr><td></td></tr>
    		<tr><td><button onClick="logout();">退出登录</button></td></tr>
    		
    	</table>
    </div>
    <div data-options="region:'center',title:'center title'" style="padding:5px;background:#eee;"></div>
</div>