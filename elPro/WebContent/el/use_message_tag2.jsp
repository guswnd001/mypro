<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setBundle basename="resource.message" var="message"></fmt:setBundle>
<fmt:message bundle="${ message }" key="TITLE" var="title"></fmt:message>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${ title }</title>
</head>
<body>

<fmt:message bundle="${ message }" key="GREETING"></fmt:message>
<br>
<c:if test="${ !empty param.id }">
	<fmt:message bundle="${ message }" key="VISITOR">
		<fmt:param value="${ param.id }"></fmt:param>
	</fmt:message>
</c:if>

</body>
</html>