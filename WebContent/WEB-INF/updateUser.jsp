<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
<form method="post" action="${pageContext.request.contextPath}/UpdateUserServlet">
<table border="1"  cellpadding=5  cellspacing=0  align="center">
<caption>修改用户</caption>
<tr><th>用户编号</th><td><input type="text"name="id"value="${userFormServer.userId }"readonly></td></tr>
<tr><th>用户名</th><td><input type="text"name="user"value="${userFormServer.userName }"></td></tr>
<tr><th>密码</th><td><input type="password"name="pwd"value="${userFormServer.password }"></td></tr>
<tr><th>余额</th><td><input type="text"name="balan"value="${userFormServer.balance}"></td></tr>
<tr><th><input type="reset"value="重置"></th><th><input type="submit"value="修改"></th></tr>

</table>
</form>
</body>
</html>