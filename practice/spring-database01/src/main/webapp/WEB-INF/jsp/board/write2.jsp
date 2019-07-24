<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<script>
	function checkForm(){
		var form = document.inputForm;

		if(!form.title.value){
			alert("제목은 필수항목입니다.");
			form.title.focus();
			return false;
		} else if (!form.writer.value){
			alert("글쓴이는 필수항목입니다.");
			form.writer.focus();
			return false;
		}
		return true;
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
		<h2>글 작성 폼</h2>
		<hr><br>
		<form method="post" action="${ pageContext.request.contextPath }/board/write2"
			name="inputForm" onsubmit="return checkForm()"> <!-- return true / false에 따라 submit 되고 안되고... -->
			<table>
				<tr>
					<th width="23%">제목</th>
					<td><input type="text" name="title" size="80" autofocus="autofocus"></td>
				</tr>
				<tr>
					<th width="23%">글쓴이</th>
					<td><input type="text" name="writer" size="80"></td>
				</tr>
				<tr>
					<th width="23%">내용</th>
					<td><textarea rows="8" cols="80" name="content"></textarea></td>
				</tr>
			</table>
		<button type="submit">등록</button>
		</form>
	</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>
