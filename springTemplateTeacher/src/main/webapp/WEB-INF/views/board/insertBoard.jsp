<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시글 등록</h1>
<form action="insertBoard">
	작성자<input name="writer"></br>
	제목<input name="title"><br>
	내용<input name="content"><br>
	<button>등록</button>
</form>
	
</body>
</html>