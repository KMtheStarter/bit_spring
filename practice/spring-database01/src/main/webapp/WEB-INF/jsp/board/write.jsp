<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
		<jsp:param value="spring 글 작성 폼" name="title"/>
		</jsp:include>
		action태그가 없어도 자기 자신한테 post방식으로 요청을 날립니다.
		<form:form method="post" commandName="boardVO">
			<form:input path="writer" type="hidden" value="${ loginVO.id }" />
			<table>
				<tr>
					<th width="23%">제목</th>
					<td><form:input path="title" size="80"/><form:errors path="title" class="error" /></td>
				</tr>
				<tr>
					<th width="23%">작성자</th>
					<td>${ loginVO.id }</td>
				</tr>
				<tr>
					<th width="23%">내용</th>
					<td><form:textarea path="content" rows="8" cols="80"/></td>
				</tr>
			</table>
		<button type="submit">등록</button>
		</form:form>
	</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>
