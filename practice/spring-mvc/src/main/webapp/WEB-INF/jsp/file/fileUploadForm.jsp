<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>파일 업로드 테스트</h2>
	<h4>파일 업로드를 위해선 apache commons fileupload dependency 추가해야 함.</h4>
	<form action="<%= request.getContextPath() %>/file/upload.do"
		method="post" enctype="multipart/form-data">
	아이디: <input type="text" name="id" value="test"><br>
	파일1: <input type="file" name="attachfile1"><br>
	파일2: <input type="file" name="attachfile2"><br>
	<input type="submit" value="업로드"><br>
	</form>
</body>
</html>