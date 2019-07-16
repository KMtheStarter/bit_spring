<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="httpRequest.js"></script>
<script>
	function debugTrace(msg) {
		var debug = document.getElementById("debug");
		debug.value += msg;
	}

	function onBtnClick() {
		// sendProcess("GET", "sample.jsp", "name=hong&age=25", callbackFunc);

		var namev = document.getElementById("name").value;
		var agev = document.getElementById("age").value;
		var addrv = document.getElementById("addr").value;
		var methodv = document.getElementById("method").value;
		var params = {
			name : namev,
			age : agev,
			addr : addrv
		};
		if (methodv == "2"){
			methodv = "POST";
		} else methodv == "GET";
		
		sendProcess(methodv, "sample.jsp", params, callbackFunc);
	}

	function callbackFunc() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				debugTrace(httpRequest.responseText + "\n");
			}
		}
	}
</script>
</head>
<body>
	<h2>XMLHttpRequest 모듈을 사용한 예제</h2>
	<textarea rows="10" cols="120" id="debug"></textarea>
	<form name="inputForm">
		이름:<input type="text" name="name" id="name"> 나이:<input
			type="text" name="age" id="age"> 주소:<input type="text"
			name="addr" id="addr"> 방식: <select id="method"><option
				value="1">GET</option>
			<option value="2">POST</option></select>
		<%-- 원래 동기통신방식인 form을 비동기로 사용하기 위해 onclick을 사용. --%>
		<input type="button" value="서버에 자료전송" onclick="onBtnClick()">
	</form>
</body>
</html>