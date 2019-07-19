<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>choose 태그</title>T
</head>
<body>

<ul>
<c:choose>
	<c:when test="${param.name == '김현중'}">
		<li>당신의 이름은 ${param.name}입니다.
	</c:when>
	<c:when test="${param.age > 20}">
		<li>당신은 ${param.age}세 입니다.
	</c:when>
	<c:otherwise>
		<li>당신은 '김현중'도 아니고 20세 이상도 아닙니다. 당신 대체 누구야!!
	</c:otherwise>
</c:choose>
</ul>

</body>
</html>