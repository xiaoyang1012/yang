<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<title>小仰后台内容登陆平台</title>
	<link rel="stylesheet" href="">
	<style>
		html,body {margin: 0;padding: 0;width: 100%;height: 100%;}
		.page {width: 100%;height: 100%;background: #016aa9;position: relative;}
		.login {width: 927px;height: 457px;background: url('${pageContext.request.contextPath }/img/login.png');position: absolute;top: 50%;left: 50%;margin-left: -464px;margin-top: -229px;}
		.box {font-size: 12px;letter-spacing: 3px;width: 300px;position: absolute;top: 225px;left: 375px;}
		input {border:1px solid #85c8e0;box-sizing: border-box;width: 110px;height: 20px;background: #292929;color: #fff;font-size: 12px;text-indent: 6px;}
		.user {margin-bottom: 8px;}
		.btn {display:inline-block;width: 60px;height: 20px;background: #1e1f21;text-align: center;line-height: 20px;margin-left: 4px;color: #fff;border-radius: 3px;cursor: pointer;}
		.btn:hover {background: #003f62;}
		.btn:active {background: #016aa9;}
		.tip {color: red; text-indent: 40px;}
	</style>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery.min.js"></script></head>
<body class="page">
	<div class="login">
		<div class="box">
			<div class="user">
				<span>用户</span>
				<input type="text" name="username" id="user" onkeydown="userEnter(event);">
			</div>
			<div class="pwd">
				<span>密码</span>
				<input type="password" name="password" id="pwd" onkeydown="pwdEnter(event);">
				<span class="btn" onclick="return checkLogin();">登录</span>
			</div>
			<p class="tip" id="tip"></p>
		</div>
	</div>
</body>

<script>
	document.getElementById('user').focus();

	function userEnter(e) {
		var user = document.getElementById('user').value;
		var tip = document.getElementById('tip');
		if (e.keyCode == 13) {
			if (user == '') {
				tip.innerHTML = '请输入用户名';
			} else {
				document.getElementById('pwd').focus();
				tip.innerHTML = '';
			}
		}
	}

	function pwdEnter(e) {
		if (e.keyCode == 13) {
			checkLogin();
		}
	}

	function checkLogin(){
    		var username = $("[name=username]").val();
    		var password = $("[name=password]").val();
    		$.ajax({
        url : "login/hello",// 获取自己系统后台用户信息接口
        data :{"name":username,"password":password},
        type : "POST",
        async :false,
        dataType: "json",
        success : function(data) {
                if (data.status == 200) { //判断返回值，这里根据的业务内容可做调整
                       window.location.href ="index";//指向登录的页面地址
                       window.event.returnValue=false;
                       
                    } else {
                        tip.innerHTML ="提示!用户名或者密码错误!";//显示登录失败的原因
                        return true;
                    }
            }
    });
    	};
</script>
</html>



