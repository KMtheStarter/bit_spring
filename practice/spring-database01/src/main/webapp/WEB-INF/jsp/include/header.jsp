<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script>
	function addFavorite(){
		try{
			window.external.AddFavorite(
					'http://localhost:7777${pageContext.request.contextPath}',
					'MyMissionSpring');	
		} catch(e){
			alert("현재 사용중인 브라우저에서는 사용할 수 없습니다.\nctrl+d를 사용해주세요.");
		}
			
	}
</script>
<table>
	<tr>
		<td rowspan="2" style="width: 100px; height: 100px;">
			<a href="${ pageContext.request.contextPath }/">
				<img src="${ pageContext.request.contextPath }/resources/images/logo.png"
					width="100px" height="100px">
			</a>
		</td>
		<td align="right">
			<a href="#" onclick="addFavorite()">
				즐겨찾기 추가
			</a>
		</td>
	</tr>
	<tr>
		<td>
			<a href="${ pageContext.request.contextPath }/member">회원관리</a> ||
			<a href="${ pageContext.request.contextPath }/board">게시판</a> ||
			<a href="${ pageContext.request.contextPath }/join">회원가입</a> ||
			로그인 || 마이페이지 || 로그아웃
		</td>
	</tr>
</table>