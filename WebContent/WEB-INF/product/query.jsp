<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		body{
			margin:1px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			$("#dg").datagrid({
				url:'product_queryJoinProduct.action',
				loadMsg:'请等待.......',
				queryParams:{name:''},
				//指定id为标识字段，在删除，更新的时候有用，如果配置此字段，在翻页的时候被选中的记录是不会丢失的
				idField:'id',
				//显示斑马线
				striped:true,
				//数据显示同行，默认就是true
				nowrap:true,
				fitColumns:true,
				//单行显示
				singleSelect:false,
				pagination:true,
				pageSize:5,
				pageList:[5,10,15],
				toolbar:[{
					iconCls:'icon-add',
					text:'添加商品',
					handler:function(){
						parent.$("#win").window({
							title:'添加商品',
							width:550,
							height:600,
							content:'<iframe src="send_product_save.action" frameborder="0" width="100%" height="100%" />'
						});
					}
					},'-',{
						iconCls:'icon-edit',
						text:'更新商品',
						handler:function(){
							alert("更新");
						}
					},'-',{
						iconCls:'icon-remove',
						text:'删除商品',
						handler:function(){
							alert("删除");
						}
				},'-',{
					text:"<input id='ss' type='text' name='luo' />",
			}],
				frozenColumns:[[
					{field:'xyz',checkbox:true},          
					{field:'id',title:'商品编号',width:100},          
				]],
				columns:[[
					{field:'name',title:'商品名称',width:200},       
					{field:'remark',title:'简单介绍',width:300},
					{field:'category.type',title:'所属类别',width:100,
						formatter:function(value,row,index){
							if(row.category != null && row.category.type != null){
								return row.category.type;
							}
						}
					}
				]]
			});
			//把普通的文本框转化为搜索文本框
			$("#ss").searchbox({
				//触发查询事件
				searcher:function(value,name){
					$("#dg").datagrid('load',{name:value});
				},
				prompt:"luoling"
			});
		});
	</script>
</head>
<body>
	<table id="dg"></table>
</body>
</html>