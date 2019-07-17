<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%-- /ajax/exam03/httpRequest.js 도 가능! --%>
<script src="jquery-3.4.1.min.js"></script>
<script src="../exam03/httpRequest.js"></script>
<script>
	function debugTrace(msg) {
		var debug = document.getElementById("debug");
		debug.value += msg;
	}

	function sendOnClick() {
		sendProcess("GET", "sample.xml", null, callback);
	}

	function callback() {
		if (httpRequest.readyState == 4) {
			if (httpRequest.status == 200) {
				// var xmlDoc = $.parseXML(httpRequest.responseText);
				var xmlDoc = httpRequest.responseXML;
				var memberList = $(xmlDoc).find("member"); // jQuery 객체!
				var msg = "회원수: " + memberList.length + "명\n";
				
				memberList.each(function(index) {
					var id = $(this).find("id").html();
					var name = $(this).find("name").html();
					msg += id + "(" + name + ")\n";
				});
				
				/*
				for(var i = 0; i < memberList.length; i++){
					// console.log("1: " + memberList);
					// console.log("2: " + memberList[0].innerHTML); // javascript 객체이므로 innerHTML으로 내용 확인
					// console.log("3: " + memberList.eq(0).html()); // jQuery 객체이므로 html()로 내용 확인
					// console.log("4: " + memberList.eq(0).find("id").html());
					var member = memberList.eq(i);
					var id = $(member).find("id").html();
					var name = $(member).find("name").text();
					msg += id + "(" + name + ")\n";
				}
				*/
				
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