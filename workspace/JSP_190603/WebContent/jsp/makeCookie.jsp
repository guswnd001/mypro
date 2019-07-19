<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.net.URLEncoder" %>
<% 
	Cookie cookie1 = 
		new Cookie("name1", URLEncoder.encode("최범균", "utf-8"));
	response.addCookie(cookie1);
	Cookie cookie2 = 
			new Cookie("name2", URLEncoder.encode("김현중", "utf-8"));
		response.addCookie(cookie2);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 생성</title>
</head>
<body>

<%= cookie1.getName() %> 쿠키1의 값 = "<%= cookie1.getValue() %>"<br>
<%= cookie2.getName() %> 쿠키2의 값 = "<%= cookie2.getValue() %>"

</body>
</html>