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
				url:'category_queryJoinAccount.action',
				loadMsg:'请等待.......',
				queryParams:{type:''},
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
					text:'添加类别',
					handler:function(){
						parent.$("#win").window({
							title:'添加类别',
							width:280,
							height:200,
							content:'<iframe src="send_category_save.action" frameborder="0" width="100%" height="100%" />'
						});
					}
					},'-',{
						iconCls:'icon-edit',
						text:'更新类别',
						handler:function(){
							//1:判断是否有选中行记录
							var rows = $("#dg").datagrid("getSelections");
							//rows返回被选中的行，没有任何行被选中，则返回空数组
							if(rows.length == 0){
								$.messager.show({
									title:'错误提示',
									msg:'请选中一条记录更新',
									timeout:2000,
									showType:'slide'
								});
							}else if(rows.length != 1){
								$.messager.show({
									title:'错误提示',
									msg:'只能更新一条记录',
									timeout:2000,
									showType:'slide'
								});
							}else{
								//1.弹出更新页面
								parent.$("#win").window({
									title:'更新类别',
									width:320,
									height:250,
									content:'<iframe src="send_category_update.action" frameborder="0" width="100%" height="100%" />'
								});
							}
						}
					},'-',{
						iconCls:'icon-remove',
						text:'删除类别',
						handler:function(){
							//1:判断是否有选中行记录
							var rows = $("#dg").datagrid("getSelections");
							//rows返回被选中的行，没有任何行被选中，则返回空数组
							if(rows.length == 0){
								$.messager.show({
									title:'错误提示',
									msg:'至少选中一条记录',
									timeout:2000,
									showType:'slide'
								});
							}else{
								//提示是否确认删除，如果确认则执行删除的逻辑
								$.messager.confirm ('删除确认对话框','是否要删除选中的记录！',function(r){
									if(r){
										//1：获取被选中的记录，然后从记录中获取相应的id
										var ids = "";
										for(var i = 0;i < rows.length;i++){
											ids += rows[i].id + ",";
										}
										//2：拼接id的值，然后发送后台
										ids = ids.substring(0,ids.lastIndexOf(","));
										//3：发送ajax请求
										$.post("category_deleteByIds.action",{ids:ids},function(result){
											if(result=="true"){
												//取消选中的所有行
												$("#dg").datagrid("uncheckAll");
												//重新刷新当前页面
												$("#dg").datagrid("reload");
											}else{
												$.messager.show({
													title:'删除异常',
													msg:'删除失败，请检查操作',
													timeout:2000,
													showType:'slide'
												});
											}
										},"text");
									}
								});
							}
						}
				},'-',{
					text:"<input id='ss' type='text' name='luo' />",
			}],
				/*rowStyler:function(index,row){
					console.info("index: " + index + "," +row);
				},*/
				frozenColumns:[[
					{field:'xyz',checkbox:true},          
					{field:'id',title:'编号',width:100},          
				]],
				columns:[[
					{field:'type',title:'类别名称',width:100,
						formatter:function(value,row,index){
							return "<span title=" + value + ">" + value + "</span>";
						}
					},       
					{field:'hot',title:'热点',width:100,align:'right',
						formatter:function(value,row,index){
							if(value){
								return "<input type='checkbox' checked='true' disabled='true'";
							}else{
								return "<input type='checkbox' disabled='true'";
							}
							
						}
						/*设置当前单元格的样式，返回的字符串直接交给style属性
						styler:function(value,row,index){
							if(value < 20){
								return 'color:#f00';
							}
						}*/
					},
					{field:'account.login',title:'所属管理员',width:100,
						formatter:function(value,row,index){
							if(row.account != null && row.account.login != null){
								return row.account.login;
							}
						}
					}
				]]
			});
			//把普通的文本框转化为搜索文本框
			$("#ss").searchbox({
				//触发查询事件
				searcher:function(value,name){
					$("#dg").datagrid('load',{type:value});
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