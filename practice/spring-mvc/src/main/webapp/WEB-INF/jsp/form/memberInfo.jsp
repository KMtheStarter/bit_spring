<%@page import="kr.co.mlec.form.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
	<h2>회원정보</h2>
	<strong>어차피 requestScope에 속한 변수기 때문에 requestScope.를 앞에 안붙여도 된다.</strong><br>
	id: ${member.id }<br>
	password: ${member.password }<br>
	name: ${member.name }<br>
</body>
<script>
	if ("${msg }"){
		alert("${msg}");
	}
</script>
</html>