<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>给小仰留言</title>

<link rel="stylesheet" href="${pageContext.request.contextPath }/wordwall/css/index.css">

<script type="text/javascript" src='${pageContext.request.contextPath }/wordwall/js/jquery-1.7.2.min.js'></script>
<script type="text/javascript" src='${pageContext.request.contextPath }/wordwall/js/index.js'></script>
</head>
<body>

	<div id='top'>
		<span id='send'></span>
	</div>
	
	<div id='main'>
		<c:forEach items="${words}" var="word">
		<dl class='paper a5'>
			<dt>
				<span class='username'>${word.getName()}</span>
				<span class='num'>No.00${word.getId()}</span>
			</dt>
			<dd class='content'>${word.getMessage()}</dd>
			<dd class='bottom'>
				<span class='time'><fmt:formatDate value="${word.getCreated()}" pattern="yyyy-MM-dd"/></span>
				<a href="" class='close'></a>
			</dd>
		</dl>
		</c:forEach>
	</div>

	<div id='send-form'>
		<p class='title'><span>许下你的愿望</span><a href="" id='close'></a></p>
		<form action="" name='wish'>
			<p>
				<label for="username">昵称：</label>
				<input type="text" name='nickname' id='username'/>
			</p>
			<p>
				<label for="content">愿望：(您还可以输入&nbsp;<span id='font-num'>50</span>&nbsp;个字)</label>
				<textarea name="content" id='content'></textarea>
				
			</p>
			<button id='send-btn'>发表留言</button>
		</form>
	</div>

<!--[if IE 6]>
<script type="text/javascript" src="js/iepng.js"></script>
<script type="text/javascript">
DD_belatedPNG.fix('#send,#close,.close');
</script>
<![endif]-->

<!--这里是用来发表留言的js -->
     <script type="text/javascript">
    	$("#send-btn").click(function(){
    		var name = $("[name=nickname]").val();
    		var message = $("[name=content]").val();
    		if (confirm("留言将提交审核，通过后就能展示，确定提交吗？")) {  
    			$.post("wordwall/insert.html",{'name':name,'message':message}, function(data){
				if(data.status == 200||"200".equals(data.status)){
					alert("谢谢您！您的留言已经提交审核，审核通过以后就会展示！");
				}else{
					alert('网络拥挤，请稍后重试！');
				}
				});	
        	}  
       		 else {  
              
        		}  
    		
    		
    		
    	});
    
    </script>


</body>
</html>