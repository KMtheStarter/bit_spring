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
	
	function doAction(bno){
		<c:if test="${ empty loginVO }">
			if(confirm("로그인이 필요합니다. 로그인 하시겠습니까?"))
				location.href="${ pageContext.request.contextPath}/login";
		</c:if>
		<c:if test="${ not empty loginVO }">
			location.href = "board/" + bno;
		</c:if>
	}
</script>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp" />
	</header>
	<section>
		<div align="center">
			<jsp:include page="/WEB-INF/jsp/include/line.jsp">
			<jsp:param value="전체 게시글 조회" name="title"/>
			</jsp:include>
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
							<a href="#" onclick="doAction(${ board.no })">
								<%-- ${ board.title } --%>
								<%-- 보안상의 이유로 특수문자들을 일반 문자열로 치환해준다. escapeXml은 c:out 태그를 쓰면 따로 안적어도 true가 된다. --%>
								<c:out value="${ board.title }" escapeXml="true" />
							</a>
						</td>
						<td>${ board.writer }</td>
						<td>${ board.regDate }</td>
					</tr>
				</c:forEach>
			</table>
			<br>
			<c:if test="${ not empty loginVO }">
			<!-- <button onclick="goWrite()">새 글 등록</button> -->
			<button id="writeBtn">새 글 등록</button>
			</c:if>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>