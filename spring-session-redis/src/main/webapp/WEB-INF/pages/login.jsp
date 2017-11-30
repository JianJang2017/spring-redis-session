<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录界面</title>
</head>
<body>
	<div align="center">
		<form action="<%=pageContext.getServletContext().getContextPath()%>/login" method="post">
			<table width="500px" border="1">
				<thead>
					<tr>
						<th colspan="2">登录测试</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td align="left">用户名：</td>
						<td><input type="text" id="name" name="username"></td>
					</tr>
					<tr>
						<td align="left">密码：</td>
						<td><input type="password" id="password" name="password"></td>
					</tr>
					<tr align="center">
						<td colspan="2"><input type="submit" value="登录" /><input type="reset"
							value="重置" /></td>
					</tr>
				</tbody>
			</table>

		</form>
	</div>
	<div align="center">
		<span>登录用户：${username }</span> <span>服务端口：${server }</span> <br />
		<a href="<%=pageContext.getServletContext().getContextPath()%>/buy">购买</a>
		<br/><span style="font-weight: bold; font-size: 16px; color: red;">${message }</span>
	</div>
</body>
</html>