<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<%
		response.setHeader("cache-control","no-store");
	%>
</head>
<body>
	此页面b.jsp采用服务器端的方式设置了不缓存
	<input type="text" name="xyz">
	<a href="c.jsp">c.jsp</a>
</body>
</html>