<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script language="JavaScript">

var a = Math.random() + ""
var rand1 = a.charAt(5)
quotes = new Array
<!-- 展示在感言区-->
quotes[1] = '世界上最勇敢的事情，是微笑着听你们之间的爱情！'
quotes[2] = '喜欢独自到陌生的城市旅行，没有目的，没有攻略，也无需陪伴...'
quotes[3] = '很多的事都是如此，不能强求，但也别将就...'
quotes[4] = '如果有来生，要做一棵树，一半在空中飞扬，一半在地下安详...'
quotes[5] = '2019，四处走走...'
quotes[6] = '把每一天都当做生命的最后一天来过，一定比现在精彩很多'
quotes[7] = '加油2019！'
quotes[8] = '要努力呀 ,因为你想买的东西很贵 ,你想去的地方很远，你喜欢的人，很优秀！'
quotes[9] = '最近花在健身上面的时间真是太少了'
quotes[0] = '如果你觉得自己又穷又丑，请不要悲伤，至少你的判断还是对的。'
var quote = quotes[rand1]
</script>
<header class="header">
        <div class="container">                       
            <div class="profile-content pull-left">
                <h2 class="desc"><a style="color:#A9A9A9" href="http://www.yxlzone.top">欢迎来到小仰的个人网站</a></h2>  
		<!--	<marquee width=500 color="red" onMouseOut="this.start()" onMouseOver="this.stop()">   -->
					<script language="JavaScript">
						document.write("<font style='color:#87CEFA; font-size:14px'>"+ quote +"</font>")
					</script>
					&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<font style='color:blue; font-size:14px'>---小仰说</font>
			<!--	</marquee>   -->
            </div><!--//profile-->
            <!-- 搜索框 --> 
            <div class="profile-content pull-right">
			<input type="text" id="keyword" class="form-control" size="35" placeholder="请输入关键字" maxlength="15" onkeydown="javascript:if(event.keyCode==13) search('keyword');">
			</div>  
            <!-- 搜索框 -->   
        </div><!--//container-->
    </header><!--//header-->

    
    
    
    
    
    
    