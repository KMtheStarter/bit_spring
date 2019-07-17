<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- /ajax/exam03/httpRequest.js 도 가능! --%>
<script src="../exam03/httpRequest.js"></script>
<script>
	function debugTrace(msg) {
		var debug = document.getElementById("debug");
		debug.value += msg;
	}

	function sendOnClick() {
		sendProcess("GET", "sample.jsp", null, callback);
	}

	function callback() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				var data = httpRequest.responseText;
				// data = JSON.parse(data);
				memberList = eval(data);
				
				var msg = "회원수: " + memberList.length + "명\n";
				/*
				for (var i = 0; i < memberList.length; i++){
					var member = memberList[i];
					var id = member.id;
					var name = member.name;
					msg += id + "(" + name + ")\n"; 
				}
				*/
				memberList.forEach(function (data){
					var id = data.id;
					var name = data.name;
					msg += id + "(" + name + ")\n"; 
				})
				
				debugTrace(msg);
			}
		}
	}
</script>
</head>
<body>
	<h2>JSON DATA 예제</h2>
	<textarea rows="10" cols="80" id="debug"></textarea>
	<br>
	<input type="button" value="서버에 자료요청" onclick="sendOnClick()">
</body>
</html>