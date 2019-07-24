<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/layout.css">
<link rel="stylesheet" href="${ pageContext.request.contextPath }/resources/css/board.css">
<style>
a:hover{
	text-decoration: none;
}
</style>
</head>
<body>
	<header>
		<jsp:include page="/WEB-INF/jsp/include/header.jsp" />
	</header>
	<section>
		<div align="center">
			<br><hr>
			<h2>회원가입</h2>
			<hr><br>
			<form:form method="post" commandName="memberVO">
				<table>
					<tr>
						<th width="20%">아이디</th>
						<td><form:input path="id" size="30"/><form:errors path="id" class="error" /></td>
					</tr>
					<tr>
						<th width="20%">비밀번호</th>
						<td><form:input type="password" path="password" size="30"/><form:errors path="password" class="error" /></td>
					</tr>
					<tr>
						<th width="20%">이름</th>
						<td><form:input path="name" size="30"/><form:errors path="name" class="error" /></td>
					</tr>
					<tr>
						<th width="20%">이메일</th>
						<td><form:input path="emailId" size="30"/>&nbsp;&#64;&nbsp;<form:input path="emailDomain" size="30"/></td>
					</tr>
					<tr>
						<th width="20%">전화번호</th>
						<td>
							<form:input path="tel1" size="10"/>&nbsp;-&nbsp;
							<form:input path="tel2" size="10"/>&nbsp;-&nbsp;
							<form:input path="tel3" size="10"/>
						</td>
					</tr>
					<tr>
						<th width="20%" rowspan="2">주소</th>
						<td>
							<a onclick="sample4_execDaumPostcode()">
							<form:input path="basicAddr" size="40" readonly="true" id="address"/>&nbsp;
							<form:input path="post" size="8" readonly="true" id="zipcode"/>
							</a>
							<input type="button" onclick="sample4_execDaumPostcode()" value="검색">
						</td>
					</tr>
					<tr>
						<td><form:input path="detailAddr" size="50" placeholder="상세주소"/></td>
					</tr>
				</table>
				<br>
				<button type="submit">가입</button>
			</form:form>
		</div>
	</section>
	<footer>
		<%@ include file="/WEB-INF/jsp/include/footer.jsp" %>
	</footer>
</body>
<script src="http://dmaps.daum.net/map_js_init/postcode.v2.js"></script>
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script>
	//본 예제에서는 도로명 주소 표기 방식에 대한 법령에 따라, 내려오는 데이터를 조합하여 올바른 주소를 구성하는 방법을 설명합니다.
	function sample4_execDaumPostcode() {
		new daum.Postcode({
			oncomplete : function(data) {
				// 팝업에서 검색결과 항목을 클릭했을때 실행할 코드를 작성하는 부분.
				// 도로명 주소의 노출 규칙에 따라 주소를 표시한다.
				// 내려오는 변수가 값이 없는 경우엔 공백('')값을 가지므로, 이를 참고하여 분기 한다.
				var roadAddr = data.roadAddress; // 도로명 주소 변수
				var extraRoadAddr = ''; // 참고 항목 변수
				// 법정동명이 있을 경우 추가한다. (법정리는 제외)
				// 법정동의 경우 마지막 문자가 "동/로/가"로 끝난다.
				if (data.bname !== '' && /[동|로|가]$/g.test(data.bname)) {
					extraRoadAddr += data.bname;
				}
				// 건물명이 있고, 공동주택일 경우 추가한다.
				if (data.buildingName !== '' && data.apartment === 'Y') {
					extraRoadAddr += (extraRoadAddr !== '' ? ', '
							+ data.buildingName : data.buildingName);
				}
				// 표시할 참고항목이 있을 경우, 괄호까지 추가한 최종 문자열을 만든다.
				if (extraRoadAddr !== '') {
					extraRoadAddr = ' (' + extraRoadAddr + ')';
				}
				// 우편번호와 주소 정보를 해당 필드에 넣는다.
				document.getElementById('zipcode').value = data.zonecode;
				document.getElementById('address').value = roadAddr;
			}
		}).open();
	}
</script>
</html>