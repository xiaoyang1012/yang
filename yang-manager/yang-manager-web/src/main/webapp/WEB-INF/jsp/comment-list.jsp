<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<input id="ss" class="easyui-searchbox" style="width:400px" 
data-options="searcher:qq,prompt:'Please Input Value',menu:'#mm'"></input> 

<div id="mm" style="width:150px"> 
<div data-options="name:'byName'">评论人昵称检索</div> 
<div data-options="name:'byContent'">评论内容检索</div> 
</div> 

<table class="easyui-datagrid" id="itemList" title="用户留言列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'comments/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">评论ID</th>
            <th data-options="field:'customerName',width:200">评论人昵称</th>
            <th data-options="field:'content',width:600">评论内容</th>
            <th data-options="field:'commentDate',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
        </tr>
    </thead>
</table>
</div>
<script type="text/javascript"> 
	function qq(value,name){
		var url1='comments/list';
		if(name=="byName"){
			url1='search/comments/list/1/'+value;
		}else if(name=="byContent"){
			url1='search/comments/list/2/'+value;
		}
		$("#itemList").datagrid({
    url:url1,singleSelect:false,collapsible:true,pagination:true,method:'get',toolbar:toolbar,
    columns:[[    
    	{field:'ck',checkbox:true}, 
        {field:'id',title:'评论ID',width:60},    
        {field:'customerName',title:'评论人昵称',width:200},    
        {field:'content',title:'评论内容',width:600},
        {field:'commentDate',title:'创建日期',width:130,align:'center'}
    ]]    
});  

} 
</script> 


<script>

    function getSelectionsIds(){
    	var itemList = $("#itemList");
    	var sels = itemList.datagrid("getSelections");
    	var ids = [];
    	for(var i in sels){
    		ids.push(sels[i].id);
    	}
    	ids = ids.join(",");
    	return ids;
    }
    
    var toolbar = [{
        text:'删除选中评论',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','请至少选中一条评论!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的评论吗？该操作将不能恢复！',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("rest/comment/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>