<%@page import="dao.MemberDBBeanMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

<% 
	request.setCharacterEncoding("utf-8"); 
	String id = (String)session.getAttribute("memId");
%>

<jsp:useBean id="member" class="model.MemberDataBean">
	<jsp:setProperty name="member" property="*" />
</jsp:useBean>

<%
	MemberDBBeanMysql manager = MemberDBBeanMysql.getInstance();
	
	member.setId(id);
	manager.updateMember(member);
%>
<script>
	alert("정보 수정 완료되었습니다.");
	location.href = "<%=request.getContextPath()%>/amado/pages/loginForm2.jsp";
</script>

</body>
</html>