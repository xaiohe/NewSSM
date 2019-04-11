<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<meta http-equiv="Context-Type" content="ttext/html; charset=UTF-8">
<title>标题</title>
</head>
<body>
	${msg}
	<form action="${pageContext.request.contextPath}/login" method="post">
		用户名:<input type="text" name="name"/><br>
		密码:<input type="password" name=password/><br>
		<input type="submit" name="登录"/>
	</form>
</body>
</html>