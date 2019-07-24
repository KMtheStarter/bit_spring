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
		<a href="${ pageContext.request.contextPath }/board">게시판</a><br>
		<a href="${ pageContext.request.contextPath }/board/write2">기존 방식의 새 글 등록</a><br>
		<a href="${ pageContext.request.contextPath }/board/write">spring form 새 글 등록</a><br>
		<a href="${ pageContext.request.contextPath }/join">회원가입</a><br>
		<a href="${ pageContext.request.contextPath }/member">가입된 회원정보</a><br>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>