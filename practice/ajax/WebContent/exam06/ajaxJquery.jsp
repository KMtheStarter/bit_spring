<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
#msgView {
	border: 1px solid red;
	height: 200px;
	width: 500px;
}
</style>
<script src="https://code.jquery.com/jquery-3.4.1.js"></script>
<!-- <script src="https://code.jquery.com/jquery-latest.js"></script> -->
<script>
	$(document).ready(function() {
		// :button 이렇게 쓰면 태그에 상관없이 타입이 버튼인 것들에 대해. <button>태그도 해당.
		// button 이렇게 쓰면 태그 자체가 button인 것에 대해. <button>태그만 해당.
		$('input:button').click(function(){
			/*
				ajax의 주요 key
				- type    : 메소드. 문자열(get/post)
				- url     : 요청주소. 문자열
				- data    : 파라미터. 문자열, 객체
				- success : 요청시 응답성공. 함수
				- error   : 요청시 응답실패. 함수
				- async   : 비동기 / 동기 설정. bool
			*/
			$.ajax({
				type: "get", // 타입을 설정하지 않으면 get방식.
				url: "hello.html",
				success: function(data) {
					// document.getElementById("msgView").innerHTML += data;
					$("#msgView").append(data);
				},
				error: function() {
					alert("실패");
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>서버에서 받은 메세지</h1>
	<div id="msgView"></div>
	<input type="button" value="서버에 자료 요청">
	<input type="text" value="서버에 자료 요청">
	<button>새로운태그</button>
</body>
</html>