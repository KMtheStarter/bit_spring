<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp" />
	</header>
	<section>
		<div align="center">
			<br><hr>
			<h2>게시판 상세</h2>
			<hr><br>
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
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>