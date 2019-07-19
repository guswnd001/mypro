<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Timestamp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<script>
	alert("게시글이 작성되었습니다.");
</script>
<meta http-equiv="Refresh" content="0;url=<%= request.getContextPath() %>/board/list.do?pageNum=${pageNum}">

</body>
</html>