<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt"%>
<!DOCTYPE html>
<head>
    <title>小仰的个人网站</title>
    <!-- Meta -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="Responsive HTML5 Website landing Page for Developers">
    <meta name="author" content="3rd Wave Media">    
    <link rel="shortcut icon" href="${pageContext.request.contextPath }/blog/img/favicon.ico">
    
    
    <!-- Plugins CSS -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/blog/plugins/font-awesome/css/font-awesome.css">
    <!-- tag css -->
    <link rel="stylesheet" href="${pageContext.request.contextPath }/blog/css/tagList.css">
   	<link rel="stylesheet" href="${pageContext.request.contextPath }/blog/css/comment_list.css">
   	<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
   	<style>
.content img {
max-width:500px;
width:expression(document.body.clientWidth>500?"500px":"auto");
overflow:hidden;
}
</style>
   	
</style> 
    
    <!-- Theme CSS -->  
    <link id="theme-style" rel="stylesheet" href="${pageContext.request.contextPath }/blog/css/styles.css">      
</head> 
<body>
    <!-- ******HEADER****** --> 
    <jsp:include page="blog_head.jsp"></jsp:include>
    
    <div class="container sections-wrapper">
        <div class="row">
            <div class="primary col-md-8 col-sm-12 col-xs-12">
                <section class="about section">
                    <div class="section-inner">
                    <p>当前位置：<a href="http://www.yxlzone.top/blog_index.html">首页</a>———>正文———><span style="color:red">${content.getTitle()}</span></p>
                        <h2 class="heading">${content.getTitle()}</h2>
                        
                        <div class="content">
							<span style="color:blue;font-size:14px;float:right">
							发表时间:<span style="color:red;"><fmt:formatDate value="${content.getCreated()}" pattern="yyyy-MM-dd hh:mm:ss"/></span>
							类目:   <span style="color:red;"> ${content.getCategory()}</span>
							浏览量:<span style="color:red;">${content.getBrowse()}</span>
							</span>
							<br><br>
							${content.getContent()}
							
							<!-- 点赞模块开始 -->
							<p style="color:#87CEFA; font-size:14px; float:right;">当前点赞次数<span id="admire" style="color:red;" >${content.getAdmire()}</span></p>
							<button type="button" id="addAdmire"  onclick="aa()">赞一个</button>
							<!-- 点赞模块结束 -->
							
							<!-- 赞赏模块开始 -->
							<div class="panel-group" id="accordion">
							<div class="panel panel-default">
								<div class="panel-heading">
								<h4 class="panel-title">
								<a data-toggle="collapse" data-parent="#accordion" 
				   				href="#collapseOne">
								写的太好了，我要小额赞赏鼓励作者！>>>
								</a>
								</h4>
							</div>
							<div id="collapseOne" class="panel-collapse collapse">
								<div class="panel-body">
								<p>人间自有真情在，一分两分都是爱</p>
				                <img src="${pageContext.request.contextPath }/blog/img/alipayimg.jpg" height="200" width="200" />
				                <img src="${pageContext.request.contextPath }/blog/img/zhiyin.jpg" height="200" width="200" />
				                <img src="${pageContext.request.contextPath }/blog/img/weipayimg.jpg" height="200" width="200" />
								</div>
							</div>
						</div>
    						<!-- 赞赏模块结束 -->
                        </div><!--//content-->
                    </div><!--//section-inner-->                 
                </section><!--//section-->   
                
                <!-- 评论以及列表战视 -->
                <section class="projects section">
                    <div class="section-inner">
                        <h2 class="heading" style="font-size:20px;">我要发表我的看法</h2> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; 
                        <!-- 发表评论   开始 -->
                        	<!-- 评论框 -->
                        	<input type="text" style="width:690px;float:left;" name="customerName" placeholder="您的尊姓大名..."><br>
                        	<p><textarea name="content" style="width:690px;float:left;" rows="6" cols="84" onpropertychange="if(this.scrollHeight>80) this.style.posHeight=this.scrollHeight+5" placeholder="请在此处发表您对本文的看法..."></textarea></p>
							<br><br><br><br><br><br>
                        	<button id="releaseComment" style="float:right;">提交评论</button>
                        <!-- 发表评论   结束 -->
                        <div class="content">
                        <!-- 评论列表的展示 开始-->
                        	<!-- 开始展示评论 --><br>
							<p style="color:blue;font-size:14px;">评论列表(一共有${commentCount}条评论)</p>

                        	<c:forEach items="${rootCommentList}" var="rootcomment">
                        			<p>#<span style="color:red;">${rootcomment.customerName}</span>#评论说:"${rootcomment.content}"
									&nbsp;&nbsp;
									<span style="color:blue;">
										<script type="text/javascript">
										// 格式 yyyy-MM-dd hh:mm:ss
												var date = new Date(${rootcomment.commentDate});
												Y = date.getFullYear() + '-';
												M = (date.getMonth()+1 < 10 ? '0'+(date.getMonth()+1) : date.getMonth()+1) + '-';
												D = date.getDate() + ' ';
												h = date.getHours() + ':';
												m = date.getMinutes() + ':';
												s = date.getSeconds(); 
	                        					document.write(Y+M+D+h+m+s)
	                        					
	                        				</script>
										
									</span></p>
                        			<c:forEach items="${footCommentList}" var="footcomment">
                        				
                        				<c:if test="${footcomment.parentCommentId==rootcomment.id}">
                        					<li><p>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;#<span style="color:red;">${footcomment.customerName}</span>#回复#<span style="color:red;">${rootcomment.customerName}</span>#说:"${footcomment.content}"</p></li>
                        				</c:if>
                        				
                        			</c:forEach>
                        	</c:forEach>
						
                        	<!-- 展示评论结束 -->
                        <!-- 评论列表的展示  结束-->
                        
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </section><!--//section-->
                 <!-- 评论以及列表展示     ---------------------------- -->
                
                
                  
            </div><!--//primary-->
			
            <div class="secondary col-md-4 col-sm-12 col-xs-12">
                <!-- 近期热门 -->
                <aside class="blog aside section">
                    <div class="section-inner">
                        <h4 class="heading">流量榜</h4>
                        <div class="content">
	  						<c:forEach items="${conntentListOrderByBrowse}" begin="0" end="15" var="conntentListOrderByBrowse">
	  						<li >
								<a style="color:black;font-size:14px;" href="/blog/info/${conntentListOrderByBrowse.getId()}.html">
									${conntentListOrderByBrowse.getTitle()}<span style="float:right;">(${conntentListOrderByBrowse.getBrowse()})</span>
								</a>
							</li>
	  						</c:forEach>    			  					             
                        </div><!--//content-->  
                    </div><!--//section-inner-->                 
                </aside><!--//section-->
                <!--     近期热门 end       -->
                <!--     阅读榜 begin       -->
                <aside class="testimonials aside section">
                    <div class="section-inner">
                        <h2 class="heading">获赞排行</h2>
                        <div  class="content">
                        <c:forEach items="${conntentListOrderByAdmire}" begin="0" end="15" var="conntentListOrderByAdmire">
	  						<li >
								<a style="color:black;font-size:14px;" href="/blog/info/${conntentListOrderByAdmire.getId()}.html">
									${conntentListOrderByAdmire.getTitle()}<span style="float:right;">(${conntentListOrderByAdmire.getAdmire()})</span>
								</a>
							</li>
	  						</c:forEach> 				                	
                        </div><!--//content-->
                    </div><!--//section-inner-->
                </aside><!--//section-->
                <!--     阅读榜end        -->
              
            </div><!--//secondary-->    
        </div><!--//row-->
    </div><!--//masonry-->
    
    <!-- ******FOOTER****** --> 
    <jsp:include page="blog_foot.jsp"></jsp:include>
 
    <!-- Javascript -->          
    <script type="text/javascript" src="${pageContext.request.contextPath }/blog/plugins/jquery-migrate-1.2.1.min.js"></script>
    <!-- custom js -->
    <script type="text/javascript" src="${pageContext.request.contextPath }/blog/js/main.js"></script> 
  	<!-- 搜索框的js -->
    <script type="text/javascript">
    	function search(a){
     var b = "${pageContext.request.contextPath }/blog/search.html?q=" + encodeURIComponent(document.getElementById(a).value);
    return window.location.href = b;
    	}
    </script> 
    <!--这里是用来发表评论（根评论）的js -->
     <script type="text/javascript">
    	$("#releaseComment").click(function(){
    		var id=${content.getId()};
    		var customerName = $("[name=customerName]").val();
    		var content = $("[name=content]").val();
    		if(typeof customerName == "undefined" || customerName == null || customerName == ""||typeof content == "undefined" || content == null || content == ""){
    			alert('名字和内容都不能为空！');
    			return;
    		}
    		$.post("${pageContext.request.contextPath }/comment/insert/"+id+".html",{'customerName':customerName,'content':content}, function(data){ 	
			if(data == 200||"200".equals(data)){
				alert('评论成功。感谢您的反馈！');
				location.reload();
			}else{
				alert('网络拥挤，请稍后重试！');
			}
		});	
    	});
    	
    	//弹出一个输入框，输入一段文字，可以提交  
    function prom() {  
        var name = prompt("请输入您的名字", ""); //将输入的内容赋给变量 name ，  
  
        //这里需要注意的是，prompt有两个参数，前面是提示的话，后面是当对话框出来后，在对话框里的默认值  
        if (name)//如果返回的有内容  
        {  
            alert("欢迎您：" + name)  
        }  
  
    }
    	
    </script>
	
   <script type="text/javascript">	
	function aa(){
			var id=${content.getId()};
			//发出post请求
			$.post("${pageContext.request.contextPath }/blog/admire/"+id+".html", function(data){ 	
			
		});	
			
			var button=document.getElementById("addAdmire");
			var x=document.getElementById("admire").innerHTML;
			x=parseInt(x)+1;
			document.getElementById("admire").innerHTML=x;
			button.disabled="true";
			}
			
	
</script> 
  
</body>
</html> 