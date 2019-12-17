<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>톱 페이지</title>
</head>
<body>

<h1> 톱 페이지입니다.</h1>

<ul>
  <li><a href="user/user.jsp">일반 사용자용 페이지로</a></li>
  <li><a href="admin/admin.jsp">관리자 전용 페이지로</a></li>
  <li><a href="getBoardList">게시판으로</a>
</ul>
<form action="logout" method="post">
  <button>로그아웃</button>
</form>

</body>
</html>
