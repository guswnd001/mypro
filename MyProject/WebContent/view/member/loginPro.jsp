<%@page import="javax.el.ELClass"%>
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
	request.setCharacterEncoding("UTF-8");

	String id = request.getParameter("id"); 
	String password = request.getParameter("password");
	
	MemberDBBeanMysql manager = MemberDBBeanMysql.getInstance(); 
	
	int x = manager.userCheck(id, password);
	
	if (x == 1) {
		session.setAttribute("memId", id);
	%>
		<script>
			alert("로그인 되었습니다.");
			location.href = "<%=request.getContextPath()%>/view/member/loginForm.jsp";
		</script>
	<%
	} else if (x == 0) {
	%>
		<script>
			alert("비밀번호가 맞지 않습니다.")
			history.go(-1);
		</script>
	<% } else { %>
		<script>
			alert("아이디가 맞지 않습니다.")
			history.go(-1);
		</script>
	<% }%>



</body>
</html>