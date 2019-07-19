<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="util.Cookies" %>
<%
	response.addCookie(Cookies.createCookie("name", "김현중"));
	response.addCookie(Cookies.createCookie("id", "madvirus", "/JSP_190603", -1));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookies 사용 예</title>
</head>
<body>

Cookies를 사용해서 쿠키 생성

</body>
</html>