<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" title="Nested Panel" data-options="width:'100%',minHeight:500,noheader:true,border:false" style="padding:10px;">
    <div class="easyui-layout" data-options="fit:true">
        <div data-options="region:'west',split:true" style="width:200px;padding:5px">
            <ul id="contentCategoryTree" class="easyui-tree" data-options="url:'content/category/list',animate: true,method : 'GET'">
            </ul>
        </div>
        <div data-options="region:'center'" style="padding:5px">
            <table class="easyui-datagrid" id="contentList" data-options="toolbar:contentListToolbar,singleSelect:false,collapsible:true,pagination:true,method:'get',pageSize:20,url:'content/query/list',queryParams:{categoryId:0}">
		    <thead>
		        <tr>
		           <!--  <th data-options="field:'id',width:100">ID</th> -->
		            <th data-options="field:'title',width:220">文章标题</th>
		            <th data-options="field:'category',width:100">类型</th>
		            <th data-options="field:'author',width:60">作者</th>
		            <th data-options="field:'status',width:60,align:'center'">文章状态</th>
		            <th data-options="field:'browse',width:50,align:'center'">浏览量</th>
		            <th data-options="field:'admire',width:50,align:'center'">点赞数</th>
		            <th data-options="field:'created',width:130,align:'center',formatter:TAOTAO.formatDateTime">创建日期</th>
		            <th data-options="field:'updated',width:130,align:'center',formatter:TAOTAO.formatDateTime">更新日期</th>
		        </tr>
		    </thead>
		</table>
        </div>
    </div>
</div>
<script type="text/javascript">
$(function(){
	var tree = $("#contentCategoryTree");
	var datagrid = $("#contentList");
	tree.tree({
		onClick : function(node){
			if(tree.tree("isLeaf",node.target)){
				datagrid.datagrid('reload', {
					category :node.category
		        });
			}
		}
	});
});
var contentListToolbar = [{
    text:'新增',
    iconCls:'icon-add',
    handler:function(){
    	var node = $("#contentCategoryTree").tree("getSelected");
    	if(!node || !$("#contentCategoryTree").tree("isLeaf",node.target)){
    		$.messager.alert('提示','新增内容必须选择一个内容分类!');
    		return ;
    	}
    	TT.createWindow({
			url : "content-add"
		}); 
    }
},{
    text:'编辑',
    iconCls:'icon-edit',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','必须选择一个内容才能编辑!');
    		return ;
    	}
    	if(ids.indexOf(',') > 0){
    		$.messager.alert('提示','只能选择一个内容!');
    		return ;
    	}
		TT.createWindow({
			url : "content-edit",
			onLoad : function(){
				var data = $("#contentList").datagrid("getSelections")[0];
				$("#contentEditForm").form("load",data);
				
				// 实现图片
				if(data.pic){
					$("#contentEditForm [name=pic]").after("<a href='"+data.pic+"' target='_blank'><img src='"+data.pic+"' width='80' height='50'/></a>");	
				}
				if(data.pic2){
					$("#contentEditForm [name=pic2]").after("<a href='"+data.pic2+"' target='_blank'><img src='"+data.pic2+"' width='80' height='50'/></a>");					
				}
				
				contentEditEditor.html(data.content);
			}
		});    	
    }
},{
    text:'删除',
    iconCls:'icon-cancel',
    handler:function(){
    	var ids = TT.getSelectionsIds("#contentList");
    	if(ids.length == 0){
    		$.messager.alert('提示','未选中文章!');
    		return ;
    	}
    	$.messager.confirm('确认','确定删除ID为 '+ids+' 的内容吗？',function(r){
    	    if (r){
    	    	var params = {"ids":ids};
            	$.post("rest/item/delete",params, function(data){
        			if(data.status == 200){
        				$.messager.alert('提示','删除内容成功!',undefined,function(){
        					$("#contentList").datagrid("reload");
        				});
        			}
        		});
    	    }
    	});
    }
},'-',{
        text:'撤回文章',
        iconCls:'icon-undo',
        handler:function(){
        	var ids = TT.getSelectionsIds("#contentList");
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中文章!');
        		return ;
        	}
        	$.messager.confirm('确认','确定撤回ID为 '+ids+' 的文章吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("rest/item/instock",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','撤回文章成功!',undefined,function(){
            					$("#contentList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    },{
        text:'发布文章',
        iconCls:'icon-redo',
        handler:function(){
        	var ids = TT.getSelectionsIds("#contentList");
        	if(ids.length == 0){
        		$.messager.alert('提示','未选中文章!');
        		return ;
        	}
        	$.messager.confirm('确认','确定发布ID为 '+ids+' 的文章吗？',function(r){
        	    if (r){
        	    	var params = {"ids":ids};
                	$.post("rest/item/reshelf",params, function(data){
            			if(data.status == 200){
            				$.messager.alert('提示','发布文章成功!',undefined,function(){
            					$("#contentList").datagrid("reload");
            				});
            			}
            		});
        	    }
        	});
        }
    }];
</script>