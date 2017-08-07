<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<%@ include file="/public/head.jspf"%>
	<title>Insert title here</title>
	<script type="text/javascript">
		$(function(){
			var colorArr = [ '#44A622', '#A7B629', '#CAD857', '#E4DB7B',
								'#ECDE49', '#ECC049', '#EC9649', '#D97431', '#D95531' ,'#A7B629'];
			$("#submit").click(function(){
				$.post($("#sale").val(),{number:$("#number").val()},function(data){
					var myChart = new JSChart('chart_container', $("#type").val(), '');
					myChart.setDataArray(data);
					myChart.colorize(colorArr.slice(0,data.length));
					myChart.setSize(100*$("#number").val(), 400);
					myChart.setBarValues(false);
					myChart.setBarSpacingRatio(45);
					myChart.setBarOpacity(1);
					myChart.setBarBorderWidth(0);
					myChart.setTitle('商品销售报表');
					myChart.setTitleFontSize(10);
					myChart.setTitleColor('#607985');
					myChart.setAxisValuesColor('#607985');
					myChart.setAxisNameX('商品类型', false);
					myChart.setAxisNameY('数量', false);
					myChart.setGridOpacity(0.8);
					myChart.setAxisPaddingLeft(50);
					myChart.setAxisPaddingBottom(40);
					myChart.draw();
				},"json");
			});
		});
	</script>
</head>
<body>
	请选择报表类型：
	<select id="sale">
		<option value="sorder_querySale.action">年度销售报表</option>
	</select>
	查询的数量：
	<select id="number">
		<option value="5">5</option>
		<option value="7">7</option>
		<option value="10">10</option>
	</select>
	报表类型：
	<select id="type">
		<option value="line">线形图</option>
		<option value="bar">柱状图</option>
		<option value="pie">饼图</option>
	</select>
	
	<input type="submit" id="submit" />

	<div id="chart_container">Loading chart...</div>
	
</body>
</html>