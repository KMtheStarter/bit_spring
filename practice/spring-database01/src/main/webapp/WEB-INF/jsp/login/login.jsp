<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<script src="${ pageContext.request.contextPath }/resources/js/checkForm.js"></script>
<script>

	if("${ param.msg }") alert("${ param.msg }");
	
	function checkVal(){
		let form = document.loginForm;
		
		/* if(!form.id.value){
			alert("아이디를 입력하세요.");
			f.id.focus();
			return false;
		} */
		/* if(!form.password.value){
			alert("비밀번호를 입력하세요.");
			f.password.focus();
			return false;
		} */
		if (isNull(form.id, "아이디를 입력하세요.")) return false;
		if (isNull(form.password, "패스워드를 입력하세요.")) return false;
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
			<jsp:include page="/WEB-INF/jsp/include/line.jsp">
			<jsp:param value="로그인" name="title"/>
			</jsp:include>
			
			<!-- action이 없어도 해당 url로 post가 날라간다. -->
			<form method="post" action="${ pageContext.request.contextPath }/login"
			name="loginForm" onsubmit="return checkVal()">
				<table style="width: 40%">
					<tr>
						<th>아이디</th>
						<td><input type="text" name="id"></td>
					</tr>
					<tr>
						<th>패스워드</th>
						<td><input type="password" name="password"></td>
					</tr>
				</table>
				<br>
				<button type="submit">로그인</button>
			</form>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
</html>