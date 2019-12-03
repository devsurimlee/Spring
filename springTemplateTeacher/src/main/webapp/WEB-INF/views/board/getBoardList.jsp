<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>    
<%@taglib prefix="my" tagdir="/WEB-INF/tags/" %> <!-- 내가만든 태그 가져옴 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script>
	function go_page(p) {
		document.boardForm.page.value = p;
		document.boardForm.submit();
	}
</script>

</head>
<body>
<div>
<!-- 검색폼 시작 -->
	<form action="getBoardList" name="boardForm">
		<input type="hidden" name="page" value="1"/>
		<select name="searchCondition">
			<option value="">선택</option>
			<option value="title" <c:if test="${BoardSearchVO.searchCondition == 'title' }">selected</c:if>  >제목</option>  
			<option value="content" <c:if test="${BoardSearchVO.searchCondition == 'content' }">selected</c:if> >내용</option>
		</select>
		<input name="keyword" value="${BoardSearchVO.keyword}">
		<button>검색</button>
	</form>
<!-- 검색폼 끝 -->
	<form action="insertBoardForm">
	<button>글쓰기</button>
	</form>
</div>

<!-- 목록시작 -->
<h1>게시판</h1>
<c:forEach items="${boardList }" var="board">
	${board.seq } )
	${board.title } 
	${board.content }
	${board.regDate }
	<a href = "download/${board.uploadFilename }">${board.uploadFilename }</a>
	
	<br>
</c:forEach>
<!-- 목록끝 -->

<!-- 페이징시작 -->
<my:paging paging="${paging }"></my:paging>
<!-- 페이징 끝 -->

<br>

</body>
</html>