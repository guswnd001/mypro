<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<c:if test="${check == 1 }">
	<script>
		alert("게시글이 수정되었습니다.");
	</script>
	<meta http-equiv="Refresh" content="0;url=<%= request.getContextPath() %>/board/content.do?num=${num }&pageNum=${pageNum}">
</c:if>
<c:if test="${check < 1 }">
	<script>
		alert("비밀번호가 맞지 않습니다.");
		history.go(-1);
	</script>
</c:if>

<%-- <script>
	alert("게시글이 수정되었습니다.");
	location.href = "<%= request.getContextPath() %>/view/board/list.jsp";
</script> --%>

</body>
</html>