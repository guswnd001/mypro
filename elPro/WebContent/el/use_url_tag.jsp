<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>URL 태그</title>
</head>
<body>

<c:url value="http://search.naver.com/search.naver" var="searchUrl">
	<c:param name="where" value="post"></c:param>
	<c:param name="query" value="공원"></c:param>
</c:url>

<ul>
	<li>${ searchUrl }</li>
	<li><c:url value="/use_if_tag.jsp"></c:url></li>
	<li><c:url value="./use_if_tag.jsp"></c:url></li>
</ul>

</body>
</html>