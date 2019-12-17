<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<html>
<head></head>
<body>
Hello ${username}!<br>

<a href="<c:out value="/admin/home"/>">관리자페이지로</a>


<a href="<%= request.getContextPath() %>/j_spring_security_logout">[로그아웃]</a>
</body>
</html>