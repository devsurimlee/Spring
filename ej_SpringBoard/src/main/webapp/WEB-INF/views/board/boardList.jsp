<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<table border="1">
		<c:forEach items="${list}" var="list">
			<tr>
				<td>${list.seq}</td>
				<td>${list.title}</td>
				<td>${list.writer}</td>
				<td>${list.cnt}</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>