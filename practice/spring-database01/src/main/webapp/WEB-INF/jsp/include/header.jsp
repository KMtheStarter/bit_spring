<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
			<c:if test="${ not empty loginVO }">
				[${ sessionScope.loginVO.id }님 환영합니다.]
			</c:if>
			<a href="#" onclick="addFavorite()">
				즐겨찾기 추가
			</a>
		</td>
	</tr>
	<tr>
		<td>
			<c:if test="${ loginVO.type == 'S'}">
				<a href="${ pageContext.request.contextPath }/member">회원관리</a> ||
			</c:if>
			<a href="${ pageContext.request.contextPath }/board">게시판</a> ||
			<c:choose>
				<c:when test="${ empty loginVO }">
					<a href="${ pageContext.request.contextPath }/join">회원가입</a> ||
					<a href="${ pageContext.request.contextPath }/login">로그인</a> ||
				</c:when>
				<c:otherwise>
					마이페이지 ||
					<a href="${ pageContext.request.contextPath }/logout">로그아웃</a>
				</c:otherwise>
			</c:choose>
		</td>
	</tr>
</table>