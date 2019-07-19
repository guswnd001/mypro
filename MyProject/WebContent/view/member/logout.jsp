<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	session.invalidate();
	/* response.sendRedirect(request.getContextPath() + "/view/member/loginForm.jsp"); */
%>

<script>
	alert("로그아웃 되었습니다.");
	location.href = "<%= request.getContextPath() %>/view/member/loginForm.jsp";
</script>

</body>
</html>