<%@page import="member.MemberDataBean"%>
<%@page import="java.util.List"%>
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

	MemberDBBeanMysql manager = MemberDBBeanMysql.getInstance();
	
	List<MemberDataBean> li = manager.getMemberList();
%>
<p class="w3-left" style="padding-left: 30px;">회원정보 조회 ></p>
<div class="w3-container" align="center">
	<table class="w3-table-all" style="width: 70%;">
		<tr>
			<th>&nbsp;ID</th>
			<th>&nbsp;이름</th>
			<th>&nbsp;생년월일</th>
			<th>&nbsp;E-mail</th>
			<th>&nbsp;Blog</th>
			<th>&nbsp;가입일</th>
		</tr>
		<%
			for (int i = 0; i < li.size(); i++) {
				MemberDataBean member = li.get(i);
		%>
		<tr>
			<td>&nbsp;<%= member.getId() %></td>
			<td>&nbsp;<%= member.getName() %></td>
			<td>&nbsp;<%= member.getJumin1() %></td>
			<td>&nbsp;<%= member.getEmail() %></td>
			<td>&nbsp;<%= member.getBlog() %></td>
			<td>&nbsp;<%= member.getReg_date() %></td>
		</tr>
		<%
			}
		%>
	</table>
</div>

</body>
</html>