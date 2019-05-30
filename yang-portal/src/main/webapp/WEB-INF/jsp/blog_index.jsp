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
    <link rel="stylesheet" href="blog/plugins/bootstrap/css/bootstrap.min.css">   
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="blog/plugins/font-awesome/css/font-awesome.css">
    <!-- tag css -->
    <link rel="stylesheet" href="blog/css/tagList.css">
    <!-- 文章列表的css-->
    <style type="text/css">
		.latest section { font-family:simsun; margin:0px; padding:0px;}
		.latest section .content { font-size:12px; text-align:center;}
		.latest section .content ul, li { list-style:none;}
		.latest section .content a{ text-decoration:none; color:#3381BF;}
		.latest section .content a:hover{ text-decoration:underline;}

		#movie_rank { height:auto;}
		.box2 {  text-align:left; overflow:hidden; color:#9C9C9C; }
		.box2 { margin-bottom:1px;}
		.box2 h2{ background:#fff; height:16px; line-height:16px;  border-bottom:1px solid #ADDFF2; color:#1974C8; font-size:14px;}
		.box2 h2 a.more{ float:right; text-decoration:underline; background:url() no-repeat 100% -123px; padding-right:1px; font-weight:normal;}
		.box2 h2 span{ margin-left:5px; font-weight:normal; color:#B9B7B8;}
		.box2 .inner{ padding:1px; line-height:16px; overflow:hidden; color:#3083C7;}
		.box2 a{ color:#3083C7; white-space:nowrap;}
		.rank_list{ line-height:14px; margin:auto; padding-top:1px;padding-left:1px;}
		.rank_list li{ height:14px; margin-bottom:5px;  padding-left:15px; white-space:nowrap; overflow:hidden; position:relative;}
		.rank_list li.top3 em{ background:#FFE4B7; border:1px solid #FFBB8B; color:#FF6800;}
		.rank_list em{ position:absolute; left:0; top:0; width:12px; height:12px; border:1px solid #B1E0F4; color:#6298CC; font-style:normal; font-size:10px; font-family:Arial; background:#E6F0FD; text-align:center; line-height:14px; overflow:hidden;}
		.rank_list span{ position:absolute; width:80px; color:#B7B7B7; text-align:right; height:12px; background:#fff; left:110px;}
		#movie_rank .rank_list span{ position:absolute; width:80px; color:#B7B7B7; text-align:right; height:14px; background:#fff; left:600px;}	
</style> 

	 <!-- 留言板的css-->
    <style type="text/css">
		#div1 {position: relative;width: 690px;height: 180px;margin: 4px auto 0;overflow: hidden;}
		#div1 span {position: absolute;color: #8e8e8e;text-decoration: none;top: 260px;display: block;border: #8e8e8e 1px solid;box-shadow: 0 0 5px #8e8e8e;-webkit-box-shadow: 0 0 5px #8e8e8e;-moz-box-shadow: 0 0 5px #8e8e8e;background: #fff;filter: alpha(opacity: 30);opacity: 0.3;font-size: 14px;padding: 3px 5px;font-family: arial;}
		#div1 span:hover {filter: alpha(opacity: 100);opacity: 1;font-weight: bold;font-size: 16px;}
</style> 
    
    <!-- Theme CSS -->  
    <link id="theme-style" rel="stylesheet" href="blog/css/styles.css">
    
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
                <section class="about section">
                    <div class="section-inner">
                        <p><a href="wordwall.html">千里有缘来相聚，留下大名再离去？>>></a></p>
                        <div id="div1" class="content">
                        	<c:forEach items="${wordsWall}" var="wordsWall">
                        		<span id="liuyan"  >${wordsWall.getMessage()}</span>
                        	</c:forEach>
                        </div><!--//content-->
                    </div><!--//section-inner-->                 
                </section><!--//section-->
    		<!-- 博客列表begin -->
               <section class="latest section">
                    <div class="section-inner">
                        <h2 class="heading">博客列表</h2>
                        <div class="content" style="height: auto">
                        	<c:forEach items="${cat}" var="catlist" >
								<div class="box2" id="movie_rank">
									<h2><a href="blog/categorylist/1/${catlist.getId()}.html"  class="more">更多</a>${catlist.getName()}</h2>
									<div class="inner">
										<ul class="rank_list">
										<c:forEach items="${content}"  var="contentList" >
          									<c:if test="${contentList.getCategory()==catlist.getName()}" >
												<li class="top3"><em>1</em><A title=${contentList.getTitle()} href="blog/info/${contentList.getId()}.html" _fcksavedurl="blog/info/${contentList.getId()}.html">${contentList.getTitle()}</A><U style="float:right;"><fmt:formatDate value="${contentList.getCreated() }" pattern="yyyy-MM-dd"/></U></li>
		  									</c:if>
        								</c:forEach> 
										</ul>
									</div>	
								</div>
							</c:forEach>
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </section><!--//section-->
                <!-- 博客列表 end-->
             
            </div><!--//primary-->
            <div class="secondary col-md-4 col-sm-12 col-xs-12">
                 <aside class="info aside section">
                    <div class="section-inner">
                        <h2 class="heading sr-only">Basic Information</h2>
                        <div class="content">
                            <ul class="list-unstyled">
                                <li><i class="fa fa-map-marker"></i><span class="sr-only">Location:</span>杭州</li>
                                <li><i class="fa fa-envelope-o"></i><span class="sr-only">Email:</span><a href="http://www.yxlzone.top">18855466026@163.com</a></li>
                                <li><i class="fa fa-link"></i><span class="sr-only">Website:</span><a href="http://www.yxlzone.top">http://www.yxlzone.top</a></li>
                            </ul>
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </aside><!--//aside-->
                <!-- 近期热门 -->
                <aside class="blog aside section">
                    <div class="section-inner">
                        <h4 class="heading">近期热门</h4>
                        <div class="content">
	  						<c:forEach items="${conntentListOrderByBrowse}" begin="0" end="15" var="conntentListOrderByBrowse">
	  						<li >
								<a style="color:black;font-size:14px;" href="blog/info/${conntentListOrderByBrowse.getId()}.html">
									${conntentListOrderByBrowse.getTitle()}<U style="float:right;color:#C4C4C4">(${conntentListOrderByBrowse.getBrowse()})</U>
								</a>
							</li>
	  						</c:forEach>    			  					             
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </aside><!--//section-->
                <!--     近期热门 end       -->
                <!--     标签墙 begin       -->
                <aside class="testimonials aside section">
                        <h2 class="heading">标签墙</h2>
                        <div id ="tagshome" class="content">
                        <c:forEach items="${cat}"  var="catList">
                        <div class="box shadow">
	  						<a href='blog/categorylist/1/${catList.getId()}.html'  title='${catList.getName()}' >${catList.getName()}</a>
  						<div class="circle"></div>
						</div>
                        </c:forEach>				                	
                        </div><!--//content-->
                </aside><!--//section-->
                <!--     标签墙end        -->
                
                
              
            </div><!--//secondary-->    
        </div><!--//row-->
    </div><!--//masonry-->
    
    <!-- ******FOOTER****** --> 
    <jsp:include page="blog_foot.jsp"></jsp:include>
 
    <!-- Javascript -->          
    <script type="text/javascript" src="blog/plugins/jquery-1.11.2.min.js"></script>
    <script type="text/javascript" src="blog/plugins/jquery-migrate-1.2.1.min.js"></script>
    <script type="text/javascript" src="blog/plugins/bootstrap/js/bootstrap.min.js"></script>    
    
    <!-- custom js -->
    <script type="text/javascript" src="blog/js/main.js"></script> 
    <!-- 留言板的js -->
    <script>
	window.onload = function() {
	var oDiv = document.getElementById('div1');
	var aA = document.getElementsByTagName('span');
	var i = 0;
	for (i = 0; i < aA.length; i++) {
		aA[i].pause = 1;
		aA[i].time = null;
		initialize(aA[i]);
		aA[i].onmouseover = function() {
			this.pause = 0;
		};
		aA[i].onmouseout = function() {
			this.pause = 1;
		};
	}
	setInterval(starmove, 50);

	function starmove() {
		for (i = 0; i < aA.length; i++) {
			if (aA[i].pause) {
				domove(aA[i]);
			}
		}
	}

	function domove(obj) {
		if (obj.offsetTop <= -obj.offsetHeight) {
			obj.style.top = oDiv.offsetHeight + "px";
			initialize(obj);
		} else {
			obj.style.top = obj.offsetTop - obj.ispeed + "px";
		}
	}

	function initialize(obj) {
		var iLeft = parseInt(Math.random() * oDiv.offsetWidth);
		var scale = Math.random() * 1 + 1;
		var iTimer = parseInt(Math.random() * 1500);
		obj.pause = 0;

		obj.style.fontSize = 12 * scale + 'px';

		if ((iLeft - obj.offsetWidth) > 0) {
			obj.style.left = iLeft - obj.offsetWidth + "px";
		} else {
			obj.style.left = iLeft + "px";
		}
		clearTimeout(obj.time);
		obj.time = setTimeout(function() {
			obj.pause = 1;
		}, iTimer);
		obj.ispeed = Math.ceil(Math.random() * 4) + 1;
	}
};
</script>
  	<!-- 搜索框的js -->
    <script type="text/javascript">
    	function search(a){
     var b = "blog/search.html?q=" + encodeURIComponent(document.getElementById(a).value);
    return window.location.href = b;
    	}
    </script>         
</body>
</html> 


