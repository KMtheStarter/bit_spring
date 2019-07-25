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
			<jsp:include page="/WEB-INF/jsp/include/line.jsp">
			<jsp:param value="상세 정보 조회" name="title"/>
			</jsp:include>
			<table>
				<tr>
					<th width="20%">아이디</th>
					<td>${ member.id }</td>
				</tr>
				<tr>
					<th width="20%">이름</th>
					<td>${ member.name }</td>
				</tr>
				<tr>
					<th width="20%">이메일</th>
					<td>${ member.emailId }</td>
				</tr>
				<tr>
					<th width="20%">전화번호</th>
					<td>${ member.tel1 }</td>
				</tr>
				<tr>
					<th width="20%">주소</th>
					<td>${ member.detailAddr }</td>
				</tr>
				<tr>
					<th width="20%">가입일</th>
					<td>${ member.regDate }</td>
				</tr>
			</table>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>