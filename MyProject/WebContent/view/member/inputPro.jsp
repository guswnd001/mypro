<%@page import="member.MemberDBBeanMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<% request.setCharacterEncoding("utf-8"); %>

<jsp:useBean id="member" class="member.MemberDataBean">
	<jsp:setProperty name="member" property="*" />
</jsp:useBean>

<%
	MemberDBBeanMysql manager = MemberDBBeanMysql.getInstance();
	
	manager.insertMember(member);
%>

<script>
	alert("회원 가입되었습니다.");
	location.href = "<%= request.getContextPath() %>/view/member/loginForm.jsp";
</script>

</body>
</html>