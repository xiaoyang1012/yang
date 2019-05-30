<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>小仰个人网站后台管理系统</title>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/themes/default/easyui.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/themes/icon.css" />
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/css/taotao.css" />
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/jquery.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/jquery.easyui.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/jquery-easyui-1.4.1/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/common.js"></script>
<style type="text/css">
	.content {
		padding: 10px 10px 10px 10px;
	}
</style>
</head>
<body class="easyui-layout">
    <div data-options="region:'west',title:'菜单',split:true" style="width:180px;">
    	<ul id="menu" class="easyui-tree" style="margin-top: 10px;margin-left: 5px;">
    	<!-- #############博客内容管理########################### -->
    		<li>
         		<span>博客内容管理</span>
         		<ul>
	         		<li data-options="attributes:{'url':'content-category'}">文章分类管理</li>
	         		<li data-options="attributes:{'url':'content'}">文章管理</li>
	         	</ul>
         	</li>
         	
         	<!-- #############留言板管理########################### -->
         	<li>
         		<span>用户评论管理</span>
         		<ul>
         			<li data-options="attributes:{'url':'comment-list'}">所有评论列表</li>
	         	</ul>
         	</li>
         	
    		<!-- #############留言板管理########################### -->
         	<li>
         		<span>留言板管理</span>
         		<ul>
         			<li data-options="attributes:{'url':'item-list'}">留言列表</li>
	         		<li data-options="attributes:{'url':'item-recycle'}">留言回收站</li>
	         	</ul>
         	</li>
         	
         </ul>
    </div>
    <div data-options="region:'center',title:''">
    	<div id="tabs" class="easyui-tabs">
		    <div title="首页" style="padding:20px;">
		        <!-- 首页内容 -->
		        <jsp:include page="home.jsp"></jsp:include>	
		    </div>
		</div>
    </div>
    
<script type="text/javascript">
$(function(){
	$('#menu').tree({
		onClick: function(node){
			if($('#menu').tree("isLeaf",node.target)){
				var tabs = $("#tabs");
				var tab = tabs.tabs("getTab",node.text);
				if(tab){
					tabs.tabs("select",node.text);
				}else{
					tabs.tabs('add',{
					    title:node.text,
					    href: node.attributes.url,
					    closable:true,
					    bodyCls:"content"
					});
				}
			}
		}
	});
});
</script>
</body>
</html>