<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	#searchResult{
		border: 3px solid red;
		width: 70%;
		height: 980px;
		
	}
</style>
<script src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	$(document).ready(function() {
		$("#searchBtn").click(function() {
			
			// $("#searchResult").text("");
			$("#searchResult").empty(); // 이 태그의 자식태그를 삭제.
			
			/*
			var date = $("#searchDate").val().split("-");
			var datev = "";
			date.forEach(function(data){
				datev += data;
			});
			*/
			
			// 축약형
			var datev = $("#searchDate").val().split("-").join("");
			
			$.ajax({
				type: "get",
				url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
				data: {
					key:"cc5719c7f849a6c4769f3baff33a8c18",
					targetDt:datev
				},
				datatype: "jsonp",
				success: callback,
				fail: function(){
					alert("실패;;;");
				}
			});
		});
	});
	
	function callback(data){
		var list = data.boxOfficeResult.dailyBoxOfficeList;
		list.forEach(function (data){
			var info = data;
			var rank = info.rank;
			var name = info.movieNm;
			var audiCnt = info.audiCnt;
			
			$("#searchResult").append("<hr>");
			$("#searchResult").append("<h4>" + rank + "위</h4>");
			$("#searchResult").append("<strong>" + name + "</strong>(" + audiCnt + "명) - ");
			
			var movieCd = info.movieCd;
			var actorList = "";
			$.ajax({
				type: "get",
				url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json",
				data: {
					key: "cc5719c7f849a6c4769f3baff33a8c18",
					movieCd: movieCd
				},
				datatype: "jsonp",
				success: function (data){
					var actors = data.movieInfoResult.movieInfo.actors;
					actors.forEach(function(data){
						if (actorList) actorList += ", ";
						actorList += data.peopleNm;
					});
				},
				fail: function(){
					alert("실패;;;");
				},
				async: false
			});
			$("#searchResult").append(actorList + "<br>");
		});
	}
	
</script>
</head>
<body>
	<h2>일일 박스오피스 조회서비스</h2>
	검색일: <input type="date" id="searchDate">
	<button id="searchBtn">검색</button><br>
	
	<h4>검색결과</h4>
	<div id="searchResult"></div>
</body>
</html>