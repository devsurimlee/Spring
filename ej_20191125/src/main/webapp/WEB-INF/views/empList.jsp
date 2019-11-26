<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<table border="1">
			<c:forEach items="${list}" var="emp">
				<tr>
					<td>${emp.employeeId}</td>
					<td>${emp.firstName }</td>
					<td>${emp.jobId }</td>
					<td>${emp.salary }</td>
					<td>${emp.departmentId }</td>
				</tr>
			</c:forEach>
		</table>
	</div>
	
	<a herf="/"> Home</a>
	
</body>
</html>