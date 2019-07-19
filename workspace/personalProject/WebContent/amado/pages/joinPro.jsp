<%@page import="dao.MemberDBBeanMysql"%>
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
	request.setCharacterEncoding("utf-8");
%>


</div>
<script>
	alert("회원가입이 완료되었습니다.2222");
	location.href = "<%=request.getContextPath()%>/amado/pages/loginForm2.jsp";
</script>

</body>
</html>
