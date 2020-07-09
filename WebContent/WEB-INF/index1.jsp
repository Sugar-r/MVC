<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@page import="service.iservice.*,service.impl.*,entity.*,java.util.*" %>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
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
   	 入职时间: <input type="date" name="time1" value="2019-10-22" size="8">-<input type="date" name="time2" value="2020-10-22" size="8">
    <input type="submit" value="查询"/>	
  &nbsp; &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
<a href="#">新增员工</a>
</form>

<br/>
<br/>
<table border="1" align="center" cellpadding=5  cellspacing=0  width=300>
	 <tr>
		 <td> 员工编号 </td>
		 <td> 姓名 </td>
		 <td> 入职时间 </td>
		 <td colspan=2 align="center">操作</td>		
	 </tr>

<c:forEach items="${userListFromServer}" var="user">
	<tr>
		<td>${user.empno}</td>
		<td>${user.ename }</td>
		<td>${user.sal }</td>
		<td align="center"><a href="${pageContext.request.contextPath}/FindByIdServlet1?id=${user.empno}">&nbsp;&nbsp;>&nbsp;&nbsp; </a></td>
		<td align="center"><a href="#">&nbsp;&nbsp;╳&nbsp;&nbsp;</a></td>
		
	</tr>
</c:forEach>
</table>
</body>
</html>