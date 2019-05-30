<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<table class="easyui-datagrid" id="itemList" title="用户留言列表" 
       data-options="singleSelect:false,collapsible:true,pagination:true,url:'words/list',method:'get',pageSize:30,toolbar:toolbar">
    <thead>
        <tr>
        	<th data-options="field:'ck',checkbox:true"></th>
        	<th data-options="field:'id',width:60">留言ID</th>
            <th data-options="field:'name',width:200">用户昵称</th>
            <th data-options="field:'message',width:600">留言内容</th>
            <th data-options="field:'status',width:60,align:'center',formatter:TAOTAO.formatItemStatus">状态</th>
            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
        </tr>
    </thead>
</table>
<div id="itemEditWindow" class="easyui-window" title="编辑商品" data-options="modal:true,closed:true,iconCls:'icon-save',href:'rest/page/item-edit'" style="width:80%;height:80%;padding:10px;">
</div>
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
        text:'彻底删除留言',
        iconCls:'icon-cancel',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','请至少选中一条留言!');
        		return ;
        	}
        	$.messager.confirm('确认','确定删除ID为 '+ids+' 的留言吗？该操作将不能恢复！',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("rest/words/delete",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','删除商品成功!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },'-',{
        text:'留言降权',
        iconCls:'icon-edit',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','您应该至少选中一条用户留言!');
        		return ;
        	}
        	$.messager.confirm('确认','确定下降ID为 '+ids+' 的留言权重吗？选中的留言将被收进留言回收站，近期不再展示！',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("rest/words/reduce",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','留言降权成功！你可以在留言回收站找到它(们)！',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'通过审核',
        iconCls:'icon-remove',
        handler:function(){
        	var ids = getSelectionsIds();
        	if(ids.length == 0){
        		$.messager.alert('提示','您应该至少选中一条用户留言!');
        		return ;
        	}
        	$.messager.confirm('确认','确定通过ID为 '+ids+' 的留言审核吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("rest/words/pass",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','留言已经审核通过!',undefined,function(){
            					$("#itemList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>