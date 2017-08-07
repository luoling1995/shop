<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<%@ include file="/public/head.jspf" %>
	<style type="text/css">
		form div{
			margin:10px;
		}
	</style>
	<script type="text/javascript">
		$(function(){
			//自定义验证方法向validatebox.defaults.rules中注册新函数
			$.extend($.fn.validatebox.defaults.rules,{
				//函数的名称：函数实现体（又是一个json对象，里面包括函数的实现，和错误消息设置）
				format:{
					//函数实现，如果返回为false，则验证失败
					validator:function(value,param){
						//获取当前文件的后缀名
						var ext = value.substring(value.lastIndexOf(".") + 1);
						var arr = param[0].split(",");
						for(var i = 0;i < arr.length;i++){
							if(arr[i] == ext){
								return true;
							}
						}
						//alert(value + "," + param);
						return false;
					},
					//错误消息
					message:'文件必须为:{0}'
				}
			});
			
			//对管理员的下拉列表框进行远程加载
			$("#cc").combobox({
				url:'category_query.action',
				valueField:'id',
				textField:'type',
				panelHeight:'auto',
				panelWidth:120,
				width:120,
				editable:false,
				required:true,
				missingMessage:'请选择商品类别'
			});
			
			$("input[name=name]").validatebox({
				required:true,
				missingMessage:'请输入商品名称'
			});
			
			$("input[name=price]").numberbox({
				required:true,
				missingMessage:'请输入商品价格',
				min:0,
				precision:2,
				prefix:'$'
			});
			
			$("input[name='fileImage.upload']").validatebox({
				required:true,
				missingMessage:'请上传商品图片',
				//设置自定义方法
				validType:"format['gif,jpg,jpeg,png']"
			});
			
			$("input[name='fileImage.upload']").change(function(){
				$(this).validatebox("validate");
			});
			
			$("textarea[name=remark]").validatebox({
				required:true,
				missingMessage:'请输入商品简单描述'
			});
			
			//窗体弹出默认时禁用验证
			$("#ff").form("disableValidation");
			//注册button事件
			$("#submit").click(function(){
				//开启验证
				$("#ff").form("enableValidation");
				//如果验证成功，则提交数据
				if($("#ff").form("validate")){
					//调用submit方法，提交数据
					$("#ff").form('submit',{
						url:'product_save.action',
						success:function(){
							//关闭当前窗体
							parent.$("#win").window("close");
							//刷新页面 获取aindex--->iframe--->dg
							//parent.$("iframe[title='类别管理']").contents().find("#dg").datagrid("reload");
							parent.$("iframe[title='商品管理']").get(0).contentWindow.$("#dg").datagrid("reload");
						}
					});
				}
			});
			$("#reset").click(function(){
				$("#ff").form("reset");
			});
		});
	</script>
</head>
<body>
	<form title="添加商品" id="ff" method="post" enctype="multipart/form-data">
		<div>
			<label>商品名称:</label>
			<input type="text" name="name" />
		</div>
		<div>
			<label>商品价格:</label>
			<input type="text" name="price" />
		</div>
		<div>
			<label>图片上传:</label>
			<input type="file" name="fileImage.upload" />
		</div>
		<div>
			<label>所属类别:</label>
			<input id="cc" name="category.id" />
		</div>
		<div>
			<label>加入推荐:</label>
			推荐:<input type="radio" name="commend" value="true" checked="checked" />
			不推荐:<input type="radio" name="commend" value="false" />
		</div>
		<div>
			<label>是否有效:</label>
			上架:<input type="radio" name="open" value="true" checked="checked" />
			下架:<input type="radio" name="open" value="false" />
		</div>
		<div>
			<label>简单描述:</label>
			<textarea rows="4" cols="40" name="remark"></textarea>
		</div>
		<div>
			<label>详细描述:</label>
			<textarea rows="8" cols="40" name="xremark"></textarea>
		</div>
		<div>
			<a id="submit" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">添加</a>
			<a id="reset" href="#" class="easyui-linkbutton" data-options="iconCls:'icon-add'">重置</a>
		</div>
	</form>
</body>
</html>