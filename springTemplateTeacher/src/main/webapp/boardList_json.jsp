<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="./resources/scripts/json.min.js"></script>

<script>
///page ready event
	$( function() {
		getBoardList(); //게시판 목록 조회
		insertBoard();  //게시판글 등록
		deleteBoard(); //게시판글 삭제
	});
	
	//목록 조회
	function getBoardList() {
		$.ajax({
			url: "ajax/getBoardList.json", 
			dataType: "json",
			success: getBoardListHandler
			
		});
	}
	
	//목로조회 결과처리
	function getBoardListHandler(datas) {
		for(i=0; i<datas.length; i++) {
			$("<div>").append($("<span>").html(datas[i].seq))
					  .append(datas[i].title)
					  .append(datas[i].content)
					  .append($("<button id = 'btnDel'>").html("삭제"))
			 		  .appendTo($("#boardList")).attr("name", datas[i].seq);
		}
	}
	
	//등록 기능
	function insertBoard() {
		$("#btnIns").click( function () {
			//var param = $("#frm").serialize(); //form 객체 한번에 담음
			var param = JSON.stringify($("#frm").serializeObject());
			$.ajax({
				//var param = "writer=" + $('[name=writer]').val() + ..
				url: "ajax/insertBoard.json",
				method: "post",
				dataType: "json",	//서버에서 받은 데이터타입
				data: param,	//서버로 보낼 파라미터
				contentType: "application/json",
				success: insertBoardHandler
			})				
		});
	}
	
	//등록한 글 즉시 출력
	function insertBoardHandler(datas) {
		$("<div>").append(datas.seq)
				  .append(datas.title)
				  .append(datas.content)
				  .appendTo($("#boardList"));
		console.log(JSON.stringify($("#frm").serializeObject()) );
	}
	
	//삭제 요청
 	function deleteBoard() {
		$("#boardList").on("click", "#btnDel", function() {
			var seq = $(this).parent().find("span").eq(0).html();
			$.ajax({
				url: "board/" + seq, //deleteBoard?seq=10
				method: "delete",
				success: deleteBoardHandler
			});
		});
	} 
	
	//삭제 처리결과
	function deleteBoardHandler(seq) {
		$("[name='"+seq+"']").remove();		
	}
	
	
</script>

</head>
<body>
	<h1>글작성</h1>
	<form id="frm">
		작성자 <input name="writer"><br>
		제목 <input name="title"><br>
		내용 <input name="content"><br>
		<button type="button" id="btnIns">등록</button>
		<button type="reset">초기화</button>
	</form>
	<br>
	<h1>게시판 목록 </h1>
	<div id="boardList"></div>


</body>
</html>