<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="elfunc" uri="/WEB-INF/tlds/el-functions.tld"%>
<%
	request.setAttribute("price", 12345);
	request.setAttribute("date", new Date());
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL 함수 호출</title>
</head>
<body>

가격은 <b>${elfunc:formatNumber(price, '#,##0')}</b>원 입니다.<br> 
오늘은 <b>${elfunc:formatDate(date, 'yy/MM/dd')}</b>원 입니다. 

</body>
</html>