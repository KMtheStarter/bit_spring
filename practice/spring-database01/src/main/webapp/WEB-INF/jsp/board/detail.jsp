<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#delBtn").click(function(){
			if(confirm("${boardVO.no}번 게시물을 삭제하시겠습니까?")){
				// 동기식 삭제
				// location.href = "${ pageContext.request.contextPath }/board/remove/${ boardVO.no }";
				
				// 비동기식 삭제
				$.ajax({
					type: "delete",
					url: "${ pageContext.request.contextPath }/board/${ boardVO.no }",
					success: function(data){
						let jsonData = JSON.parse(data);
						if (jsonData.flag){
							location.href = "${ pageContext.request.contextPath }/board";
						}
					}
				});
			}
		});
	});
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp" />
	</header>
	<section>
		<div align="center">
			<jsp:include page="/WEB-INF/jsp/include/line.jsp">
			<jsp:param value="게시판 상세" name="title"/>
			</jsp:include>
			<table>
				<tr>
					<th width="25%">글 번호</th>
					<td>${ boardVO.no }</td>
				</tr>
				<tr>
					<th width="25%">작성 날짜</th>
					<td>${ boardVO.regDate }</td>
				</tr>
				<tr>
					<th width="25%">조회수</th>
					<td>${ boardVO.viewCnt }</td>
				</tr>
				<tr>
					<th width="25%">글 제목</th>
					<td>${ boardVO.title }</td>
				</tr>
				<tr>
					<th width="25%">글쓴이</th>
					<td>${ boardVO.writer }</td>
				</tr>
				<tr>
					<th width="25%">내용</th>
					<td>${ boardVO.content }</td>
				</tr>
			</table>
			<br>
			<button id="updateBtn">수정</button>&nbsp;&nbsp;&nbsp;
			<button id="delBtn">삭제</button>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>