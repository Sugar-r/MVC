<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
	</head>
	<body >
<form action=""method="post" action="${pageContext.request.contextPath}/UpdateEmpServlet">
	<table border="1" align="center" style="border: 3px #00FFFF;width:300px;border-radius: 20%;border-style:   dashed solid" >
		<caption>员工信息详情</caption>
		<tr >
			<td >员工号</td>
			<td><span id="a">${userFormServer.empno}</span>
				<input type="text" size="8" id="o" readonly="true" value="${userFormServer.empno}" style="display: none "></td>
		</tr>
		<tr>
			<td width="30%">员工名</td>
			<td><span id="b">${userFormServer.ename}</span>
				<input type="text" size="8" id="p" style="background-color: bisque ; color:  brown; display: none ;border-color:white"value="${userFormServer.ename}";></td>
		</tr>
		<tr>
			<td width="30%">职位</td>
			<td><span >${userFormServer.job}</span>
			<input type="text" size="8" value="${userFormServer.job}" style="display: none "></td>
		</tr>
		<tr>
			<td width="30%">工资</td>
			<td><span >${userFormServer.sal}</span>
			<input type="text" size="8" value="${userFormServer.sal}" style="display: none "></td>
		</tr>
		<tr>
			<td width="30%">入职时间</td>
			<td><span >${userFormServer.hiredate}</span>
			<input type="text" size="8" value="${userFormServer.hiredate}" style="display: none "></td>
		</tr>
		
		<tr>
			<td width="40%">部门编号</td>
			<td width="60%"><span >${userFormServer.deptno}</span>
			<input type="text" size="8" value="${userFormServer.deptno}" style="display: none "></td>
		</tr>
		<tr>
			<td >领导</td>
			<td><span >${userFormServer.mgr}</span>
			<input type="text" size="8" value="${userFormServer.mgr}" style="display: none "></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center"><input  type="button" id="s" value="修改" onclick="exit()"style="display: inline">
			<input  type="button" value="提交" id="r" style="display: none"></td>
		</tr>
	</table>
</form>


<script type="text/javascript">
		function exit(){
			
			document.getElementById("s").style.display = 'none';
		
			document.getElementById("r").style.display = 'inline';
			var input=document.getElementsByTagName("input");
			for(var i =0;i< input.length;i++){
				input[i].style.display = 'inline';
				}
			var span =	document.getElementsByTagName("span");
			for(var i =0;i< span.length;i++){
			span[i].style.display = 'none';
			}
			
				
		}
	</script>

	</body>
</html>
