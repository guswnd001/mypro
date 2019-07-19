<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setAttribute("name", "김현중");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL Object</title>
</head>
<body>

요청URI: ${pageContext.request.requestURI}<br>
request의 name속성: ${requestScope.name}<br>
code 파라미터: ${param.code} 

</body>
</html>