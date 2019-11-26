<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<form action="boardWrite.do" method="post" id="frm" name="frm">
			<table>
				<tr>
					<td>제목</td>
					<td><input type="text" id="title" name="title"></td>
				</tr>
				<tr>
					<td>내용</td>
					<td><input type="text" id="content" name="content"></td>
				</tr>
				<tr>
					<td>작성자</td>
					<td><input type="text" id="writer" name="writer"></td>
				</tr>
				<tr>
					<td>작성일자</td>
					<td><input type="date" id="regDate" name="regDate"></td>
				</tr>
			</table>
			<br>
			<button type="submit">완료</button>
			<button type="reset">초기화</button>
			<input type="button" value="취소" onclick="location.href='/web/'">
		</form>
	</div>
</body>
</html>