<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Cookies" %>
<% Cookies cookies = new Cookies(request); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 여부 검사</title>
</head>
<body>

<%
	if (cookies.exists("AUTH")) {
%>
아이디 "<%= cookies.getValue("AUTH") %>"로 로그인한 상태 <br>
<form action="<%= request.getContextPath() %>/JSP/logOut.jsp">
<input type="submit" value="로그아웃">
</form>
<%
	} else {
%>
로그인하지 않은 상태 <br>
<%
	}
%>

</body>
</html>