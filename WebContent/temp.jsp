<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<%@ include file="/public/head.jspf"%>
<title>Insert title here</title>
</head>
<body>
	<div id="chart_container">Loading chart...</div>
	<script type="text/javascript">
		var myChart = new JSChart('chart_container', 'bar', '');
		myChart.setDataArray([ [ 'Jun-04', 22.5 ], [ 'Oct-04', 28 ],
				[ 'Feb-05', 32 ], [ 'Jun-05', 29 ], [ 'Oct-05', 36 ],
				[ 'Feb-06', 42 ], [ 'Jun-06', 47 ], [ 'Oct-06', 44 ],
				[ 'Feb-07', 49 ] ]);
		myChart.colorize([ '#44A622', '#A7B629', '#CAD857', '#E4DB7B',
				'#ECDE49', '#ECC049', '#EC9649', '#D97431', '#D95531' ]);
		myChart.setSize(600, 400);
		myChart.setBarValues(false);
		myChart.setBarSpacingRatio(45);
		myChart.setBarOpacity(1);
		myChart.setBarBorderWidth(0);
		myChart.setTitle('商品销售报表');
		myChart.setTitleFontSize(10);
		myChart.setTitleColor('#607985');
		myChart.setAxisValuesColor('#607985');
		myChart.setAxisNameX('月份', false);
		myChart.setAxisNameY('数量', false);
		myChart.setGridOpacity(0.8);
		myChart.setAxisPaddingLeft(50);
		myChart.setAxisPaddingBottom(40);
		myChart.draw();
	</script>
</body>
</html>