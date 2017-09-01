<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Hello Word!</h1>
	<div>
		<form action="login.do">
			<span style="font-size: 12px">用户名：</span> <input type="text"
				name="loginName" /><br /> <span style="font-size: 12px">密&nbsp;&nbsp;&nbsp;码：</span>
			<input type="password" name="password" /><br />
			<input type="submit"  value="登录"/>
			<span>${message }</span>
		</form>
	</div>
</body>
</html>