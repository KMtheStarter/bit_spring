<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% if(request.getMethod().equalsIgnoreCase("POST")) {
	// post일 경우, 요청한 객체의 body를 인코딩해야함.
		request.setCharacterEncoding("UTF-8");
	}
%>
name=${param.name}
name=<%= request.getParameter("name") %>