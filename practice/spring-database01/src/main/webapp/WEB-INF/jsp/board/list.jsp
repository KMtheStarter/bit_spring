<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#writeBtn").click(function(){
			location.href = "${ pageContext.request.contextPath }/board/write";
		});
	});
	
	function goWrite(){
		location.href = "${ pageContext.request.contextPath }/board/write";
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp" />
	</header>
	<section>
	<div align="center">
	<br><hr>
	<h2>전체 게시글 조회</h2>
	<hr><br>
	<table class="list">
		<tr>
			<th style="width: 7%;">번호</th>
			<th>제목</th>
			<th style="width: 16%;">작성자</th>
			<th style="width: 20%;">등록일</th>
		</tr>
		<c:forEach items="${ boardList }" var="board">
			<tr>
				<td>${ board.no }</td>
				<td>
					<a href="${ pageContext.request.contextPath }/board/${ board.no }">
						${ board.title }
					</a>
				</td>
				<td>${ board.writer }</td>
				<td>${ board.regDate }</td>
			</tr>
		</c:forEach>
	</table>
	<!-- <button onclick="goWrite()">새 글 등록</button> -->
	<button id="writeBtn">새 글 등록</button>
	</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>