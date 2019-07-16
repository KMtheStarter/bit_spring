<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#msgView{
		border: 1px solid red;
		height: 200px;
		width: 500px;
	}
</style>
<script>
	var httpRequest = null;
	function requestMsg(){
		// 1. XMLHttpRequest 객체 생성
		// 브라우저의 버전이 낮으면 생성되지 않을 수 있음. 따라서 여러가지 처리 함께해 줌.
		if (window.XMLHttpRequest){
			httpRequest = new XMLHttpRequest();
				
		} else if (window.ActiveXObject) {
			httpRequest = new ActiveXObject("microsoft.XMLHTTP");
		}

		// 2. callback함수 설정
		// 서버에서 상태가 바뀔 때 마다 실행되는 함수 설정.
		httpRequest.onreadystatechange = responseMsg;
		
		// 3. 서버에 비동기 요청
		httpRequest.open("GET", "hello.html", true) // 마지막 인자는 async/sync 여부. 비동기/동기.
		httpRequest.send(null); // httpRequest.send(); 와 동일.
	}
	
	function responseMsg(){
		if (httpRequest.readyState == 4){ // 0 -> 1 -> 2 -> 3 -> 4. 4는 전송완료
			// 전송 받은 응답의 코드가 200(성공), 404(not found), 500(서버처리 오류)
			if (httpRequest.status == 200){
				var msgView = document.getElementById("msgView");
				msgView.innerHTML+=httpRequest.responseText;
			}
		}
		//console.log("responseMsg 호출..."); // 4번호출됨
	}
</script>
</head>
<body>
	<h1>서버에서 받은 메세지</h1>
	<div id="msgView"></div>
	<input type="button" value="서버에 자료 요청" onclick="requestMsg()">
</body>
</html>