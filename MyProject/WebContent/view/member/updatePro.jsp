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

<% 
	request.setCharacterEncoding("utf-8"); 
	String id = (String)session.getAttribute("memId");
%>

<!-- 여러 정보를 한번에 저장할 때 useBean 액션 태그를 사용한다. -->
<jsp:useBean id="member" class="member.MemberDataBean">
	<jsp:setProperty name="member" property="*" />
</jsp:useBean>

<%
	MemberDBBeanMysql manager = MemberDBBeanMysql.getInstance();
	
	member.setId(id);
	manager.updateMember(member);
%>
<script>
	alert("정보 수정 완료되었습니다.");
	location.href = "<%= request.getContextPath() %>/view/member/loginForm.jsp";
</script>

</body>
</html>