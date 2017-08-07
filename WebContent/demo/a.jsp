<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Insert title here</title>
	<!-- 
		pragma:设置页面是否缓存，用于HTTP1.0协议
		cache-control:设置页面是否缓存，用于HTTP1.1协议
		expires:如果支持缓存，则有效期
		并不是所有的容器都只是meta，列如tomcat就不解析，所以设置无效
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		no-cache:仅仅支持IE不支持火狐，和google浏览器，no-store支持所有浏览器，但是Chrome浏览器get方法不支持
		当前访问缓存页面的请求为post请求时，返回时候会出现“页面过期”，当时get方式访问b.jsp返回时，直接到服务器加载新页面，而不会提示“页面过期”
	 -->
</head>
<body>
	<a href="b.jsp">get方式到b.jsp</a>
	<form action="b.jsp" method="post">
		<input type="submit" value="post方式到b.jsp" />
	</form>
</body>
</html>