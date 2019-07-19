<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String memberId = (String)session.getAttribute("MEMBER_ID");
	boolean login = memberId == null? false : true;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인여부 검사</title>
</head>
<body>

<%
	if (login) {
%>
아이디 "<%= memberId %>"로 로그인 한 상태
<form action="<%= request.getContextPath()%>/session/sessionLogout.jsp">
<input type="submit" value="로그아웃">
</form>
<%
	} else {
%> 
로그인 하지 않은 상태
<%
	}
%>

</body>
</html>