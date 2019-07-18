<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	div {
		text-overflow:ellipsis;
		white-space:nowrap;
		word-wrap:normal;
		overflow:hidden;
	}

	#searchResult {
		border: 1px solid red;
		width : 70%;
		height: 600px;
	}
	
	#searchResult div {
		height : 200px;
		border : 1px solid blue;
		display : none;
	}
</style>
<script src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function() {
		$('button').click(function() {
			
			var date = $('#searchDate').val();	// '2018-06-01'
			
			// '2018-06-1' => '20180601'
			//var searchDate = date.split('-').join('/');	// ['2018', '06', '01'] ==> '2018/06/01'
			var searchDate = date.split('-').join('');	// ['2018', '06', '01'] ==> '20180601'
			//console.log(searchDate);
			
			$.ajax({
				url : "http://www.kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json",
				type : "get",
//				data : "key=a81b41c63e131f95e52a0e22a3ba55f5&targetDt=20180601&itemPerPage=3".
				data : {
					key : 'a81b41c63e131f95e52a0e22a3ba55f5',
					targetDt : searchDate,
					itemPerPage : '3'
				},
				datatype : 'jsonp',
				success : callback,
				error : function() {
					alert('error');
				}
			});
		});
		
		$(document).on('click', '#searchResult  button', function() {
		
			 var movieCd = $(this).attr('id').substr(3);
	
			
			$.ajax({
				url : 'http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json',
				data : {key : 'a81b41c63e131f95e52a0e22a3ba55f5', movieCd : movieCd},
				success : detailMovie
			}) 
	
		});
	});
	
	function detailMovie(data) {
		var movieInfo = data.movieInfoResult.movieInfo;
		console.log(movieInfo);
		var director  = movieInfo.directors[0].peopleNm;
		console.log(director);
		
		var genre = '';
		movieInfo.genres.forEach(function(data, i) {
			genre += data.genreNm + ' ';
		});
		
		console.log(genre);
		
		var actors = '';
		console.log(movieInfo)
		movieInfo.actors.forEach(function(data, i) {
			actors += data.peopleNm + '(' + data.cast + '역)<br>';
		});
		console.log(actors);
		
		
		console.log('#detail' + movieInfo.movieCd);
		$('#detail' + movieInfo.movieCd).toggle(); 
		$('#detail' + movieInfo.movieCd).append('감독 : ' + director + '<br>');
		$('#detail' + movieInfo.movieCd).append('장르 : ' + genre + '<br>');
		$('#detail' + movieInfo.movieCd).append('배우정보<br>');
		$('#detail' + movieInfo.movieCd).append(actors); 
	}
	
	function callback(data) {
		var list = data.boxOfficeResult.dailyBoxOfficeList;
		for(var i = 0; i < list.length; i++) {
			var info = list[i];
			var rank = info.rank;
			var name = info.movieNm;
			var audiAcc = info.audiAcc;
			var movieCd = info.movieCd;

			$('#searchResult').append('<hr>');
			$('#searchResult').append('<h4>' + rank + '위</h4>');
			$('#searchResult').append('<b>' + name + '</b>(' + audiAcc + '명)<br>');
			$('#searchResult').append('<button id=' + ('btn' + movieCd) + '>상세보기</button>');
			$('#searchResult').append('<div id="detail' + movieCd + '"></div>') 
			$('#searchResult').append('<hr>');
		}
	}
</script>
</head>
<body>
	<h2>일일 박스오피스 조회서비스 </h2>
	검색일 : <input type="date" id="searchDate"><br>
	<button>검색</button>
	<br>
	<h4>검색결과</h4>
	<div id="searchResult"></div>
</body>
</html>










