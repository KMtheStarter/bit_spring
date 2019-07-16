<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
	var httpRequest = null;
	function getXMLHttpRequest(){
		if (window.XMLHttpRequest) return new XMLHttpRequest();
		if (window.ActiveXObject) return new ActiveXObject("microsoft.XMLHTTP");
		return null;
	}
	function sendProcess(){
		// 1단계
		httpRequest = getXMLHttpRequest();
		// 2단계
		httpRequest.onreadystatechange = callbackFunc;
		// 3단계
		httpRequest.open("GET", "/ajax/exam01/hellod.html", true);
		httpRequest.send();
	}
	function callbackFunc(){
		var debug = document.getElementById("debug");
		/*
			readyState
			0: open() 호출 전.
			1: open() 호출 후, send() 호출 전.
			2: send() 호출 후, 서버 응답 전
			3: 서버응답중, header 전송, body 미전송
			4: 서버응답완료, body 전송완료
			
			status(상태코드)
			200: 성공(OK)
			403: 액세스 거부
			404: FILE NOT FOUND
			405: servlet 에러
			500: 내부서버에러
		*/
		switch(httpRequest.readyState){
		case 1:
			debug.value += 'Loading...\n'
			break;
		case 2:
			debug.value += 'Loaded...\n'
			break;
		case 3:
			debug.value += 'Interactive...\n'
			break;
		case 4:
			debug.value += 'Complete...\n'
			if(httpRequest.status == 200){
				debug.value += '정상처리\n\n';
			} else debug.value += '오류발생 :' + httpRequest.status + '\n\n';
			// httpRequest.statusText라는 상태 이름을 표기하는 방법은 tomcat8까지 지원.
			break;
		}
		
	}
</script>
</head>
<body>
	<textarea rows="10" cols="80" id="debug"></textarea><br>
	<input type="button" value="서버호출" onclick="sendProcess()">
	<input type="button" value="초기화" onclick="javascript:document.getElementById('debug').value=''">
	
</body>
</html>