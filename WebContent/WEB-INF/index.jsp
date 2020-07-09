<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>用户信息页面</title>
</head>
<body>
<table  border="1"  cellpadding=3  cellspacing=0 align="right">
<tr><td><a href="${pageContext.request.contextPath}/SelectUserServlet">用户管理</a></td>
<td><a href="${pageContext.request.contextPath}/SelectUserServlet?cz=emp">员工管理</a></td></tr>

</table>
<h3>欢迎 ${sessionScope.user}</h3>

<form action="FindLikeServlet" method="post"  align="center">
	编号: <input type="text" name="id" placeholder="根据编号精确查询"/>&nbsp;&nbsp;&nbsp;&nbsp;
   	 用户名：<input type="text" name="username" placeholder="根据姓名模糊查询"/>&nbsp;&nbsp;&nbsp;&nbsp;
   	 余额：<input type="text" name="username" placeholder="请输入最小值" />--<input type="text" name="username" placeholder="请输入最大值"/>
    &nbsp;&nbsp;<input type="submit" value="查询"/>	
  &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="${pageContext.request.contextPath}/RouterServlet?page=newUser">新增用户</a>
</form>

<br/>
<br/>
<table border="1"  cellpadding=5  cellspacing=0  align="center" width=500>
	<tr  align=center>
		<td>编号</td>
		<td>用户名</td>
		<td>密码</td>
		<td>余额</td>
		<td colspan=2 >操作</td>		
	</tr>
	
	<c:forEach items="${userListFromServer}" var="user">
	<tr>
		<td>${user.userId }</td>
		<td>${user.userName }</td>
		<td>${user.password }</td>
		<td>${user.balance }</td>
		<td align="center">
			<a href="${pageContext.request.contextPath}/FindByIdServlet?id=${user.userId}">&nbsp;&nbsp;⇵&nbsp;&nbsp;  </a>
		</td>
		<td align="center">
		<a href="${pageContext.request.contextPath}/DeleteUserServlet?id=${user.userId}">&nbsp;&nbsp;╳&nbsp;&nbsp; </a>
		</td>
	</tr>
	</c:forEach>
</table>

</body>
</html>
