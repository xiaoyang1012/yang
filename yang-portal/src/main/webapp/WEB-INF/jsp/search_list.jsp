<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8"> <![endif]-->  
<!--[if IE 9]> <html lang="en" class="ie9"> <![endif]-->  
<!--[if !IE]><!--> <html lang="en"> <!--<![endif]-->  
<head>
    <title>小仰的个人网站</title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive HTML5 Website landing Page for Developers">
    <meta name="author" content="3rd Wave Media">    
   <link rel="shortcut icon" href="blog/img/favicon.ico">
    
    <!-- Global CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/blog/plugins/bootstrap/css/bootstrap.min.css">   
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/blog/plugins/font-awesome/css/font-awesome.css">
    <!-- tag css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/blog/css/tagList.css">
    <!-- 文章列表的css-->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/blog/css/comment_list.css">
    <!-- Theme CSS -->  
    <link id="theme-style" rel="stylesheet" href="${pageContext.request.contextPath }/blog/css/styles.css">
    <style type="text/css">
    	ul.pagination {display: inline-block;padding: 0;margin: 0;}
		ul.pagination li {display: inline;}
		ul.pagination li a {color: black;float: left; padding: 8px 16px;text-decoration: none;}
		ul.pagination li a.active { background-color: #4CAF50; color: white;}
		ul.pagination li a:hover:not(.active) {background-color: #ddd;}
    </style>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->    
</head> 
<body>
    <!-- ******HEADER****** --> 
    <jsp:include page="blog_head.jsp"></jsp:include>
    
    <div class="container sections-wrapper">
        <div class="row">
            <div class="primary col-md-8 col-sm-12 col-xs-12">
                <section class="latest section">
                    <div  class="section-inner">
                        <p>当前位置:<a href="http://www.yxlzone.top/blog_index.html" >首页</a>————>搜索结果
                        <div class="content">
                            <!-- 文章列表显示开始 -->
 							<c:forEach items="${listInOnePage}" var="listInOnePage">
		   						 <li>
		        					<a href="info/${listInOnePage.id}.html" style="font-size:20px;">${listInOnePage.title}</a>
		        					<p style="font-size:14px;">
										<span style="color:blue;">类目：</span>${listInOnePage.category}
									 <!-- 	<span style="color:blue;">发表日期：</span>${listInOnePage.created} 
										<span style="color:blue;">浏览量：</span>${listInOnePage.browse}</p> --> 
		        					
		    					</li>
 							</c:forEach>
                        </div><!--//content-->
                        
                        
                        
                        <!-- 分页标签开始 -->
  
  <ul class="pagination">
  <li ><a>共${totalSize}页</a></li>
  	
            <c:choose>
                <c:when test="${currentPage == 1}">
                	<li><a href="#">首页</a></li>
                	<li><a href="#">«</a></li>
                </c:when>
                <c:otherwise>
                	<li><a href="blog/categorylist/1/${categoryId}.html">首页</a></li>
                	<li><a href="blog/categorylist/${currentPage-1}/${categoryId}.html">«</a></li>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test="${totalSize <= 5}">
                    <c:forEach begin="1" end="${totalSize}" varStatus="s">
                        <c:choose>
                            <c:when test="${s.index ==currentPage}">
                                <li class="active"><a href="#">${s.index}</a></li>
                            </c:when>
                            <c:otherwise>
                                <li><a href="blog/categorylist/${s.index}/${categoryId}.html">${s.index}</a></li>
                            </c:otherwise>
                        </c:choose>
                    </c:forEach>
                </c:when>
                
            </c:choose>
            <c:choose>
                <c:when test="${currentPage == totalSize}">
                	<li><a href="#">»</a></li>
                	<li><a href="#">末页</a></li>
                </c:when>
                <c:otherwise>
                	<li><a href="blog/categorylist/${currentPage+1}/${categoryId}.html">»</a></li>
                	<li><a href="blog/categorylist/${totalSize}/${categoryId}.html">末页</a></li>
                </c:otherwise>
            </c:choose>
            </ul>
  <!-- 分页标签结束 -->
                    </div><!--//section-inner-->                 
                </section><!--//section-->
            </div><!--//primary-->
            <div class="secondary col-md-4 col-sm-12 col-xs-12">
                 <aside class="info aside section">
                    <div class="section-inner">
                        <h2 class="heading sr-only">Basic Information</h2>
                        <div class="content">
                            <ul class="list-unstyled">
                                程序员加班中。。。
                            </ul>
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </aside><!--//aside-->
                <!-- 近期热门 -->
                <!--<aside class="blog aside section">
                    <div class="section-inner">
                        <h4 class="heading">近期热门</h4>
                        <div class="content">
	  						11111111111   			  					             
                        </div>//content-->  
                    </div><!--//section-inner-->                 
                </aside><!--//section-->
                <!--     近期热门 end       -->
                <!--     标签墙 begin       -->
              
            </div><!--//secondary-->    
        </div><!--//row-->
    </div><!--//masonry-->
    
    <!-- ******FOOTER****** --> 
    <jsp:include page="blog_foot.jsp"></jsp:include>
 
    <!-- Javascript -->          
    <script type="text/javascript" src="${pageContext.request.contextPath }/blog/plugins/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/blog/plugins/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath }/blog/plugins/bootstrap/js/bootstrap.min.js"></script>    
    
    <!-- custom js -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/blog/js/main.js"></script> 
  	<!-- 搜索框的js -->
    <script type="text/javascript">
    	function search(a){
     var b = "${pageContext.request.contextPath }/blog/search.html?q=" + encodeURIComponent(document.getElementById(a).value);
    return window.location.href = b;
    	}
    </script>         
</body>
</html> 