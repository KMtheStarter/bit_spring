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
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp" />
	</header>
	<section>
		<div align="center">
			<jsp:include page="/WEB-INF/jsp/include/line.jsp">
			<jsp:param value="회원 정보 조회" name="title"/>
			</jsp:include>
			<table>
				<c:forEach items="${ memberList }" var="e">
					<tr style="height:4px"></tr>
					<tr>
						<th width="20%">아이디</th>
						<td>
							<a href="${ pageContext.request.contextPath }/member/${ e.id }">
								${ e.id }
							</a>
						</td>
					</tr>
					<tr>
						<th width="20%">이름</th>
						<td>${ e.name }</td>
					</tr>
					<tr>
						<th width="20%">이메일</th>
						<td>${ e.emailId }</td>
					</tr>
					<tr>
						<th width="20%">전화번호</th>
						<td>${ e.tel1 }</td>
					</tr>
					<tr>
						<th width="20%">가입일</th>
						<td>${ e.regDate }</td>
					</tr>
					<tr>
						<th width="20%">회원유형</th>
						<td>${ e.type }</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>