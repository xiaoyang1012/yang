<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>欢迎来到小仰的个人网站</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/index/css/bootstrap.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/index/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/index/css/button.css" />

</head>
<body>

<div id="top-image">
  <div id="content" class="container center-block">
    <div class="jumbotron">
      <div class="container">
        <h1>欢迎您！</h1>
        <p>您可以在这里检索站内文章，或者点击按钮进入相应模块浏览...</p>
        <div class="input-group input-group-lg"> <span class="input-group-addon" id="sizing-addon1"><span class="glyphicon glyphicon-plus" aria-hidden="true"></span></span>
          <input type="text" id="keyword" class="form-control" placeholder="请键入您的关键词..." aria-describedby="sizing-addon1" onkeydown="javascript:if(event.keyCode==13) search('keyword');" >
          </div>
      </div>
      <br>
      <br>
      <br>
      <br>
      <!-- 按钮 -->
      <div id="button" class="svg-wrapper">
			<svg height="40" width="150" >
				<rect id="shape" height="40" width="150" />
				<div id="text">
					<a href="blog_index.html"><span class="spot"></span>博客首页</a>
				</div>
			</svg>
		</div>
		<div id="button" class="svg-wrapper">
			<svg height="40" width="150" >
				<rect id="shape" height="40" width="150" />
				<div id="text">
					<a href="wordwall.html"><span class="spot"></span>印象墙</a>
				</div>
			</svg>
		</div>
		<div id="button" class="svg-wrapper">
			<svg height="40" width="150" >
				<rect id="shape" height="40" width="150" />
				<div id="text">
					<a href="resume.html"><span class="spot"></span>作品展示</a>
				</div>
			</svg>
		</div>
      <!-- 按钮结束 -->
      
      
    </div>
  </div>
</div>

<script src="${pageContext.request.contextPath}/index/js/jquery.min.js"></script>

<!-- 搜索框的js -->
    <script type="text/javascript">
    	function search(a){
     var b = "${pageContext.request.contextPath }/blog/search.html?q=" + encodeURIComponent(document.getElementById(a).value);
    return window.location.href = b;
    	}
    </script> 

</body>
</html>