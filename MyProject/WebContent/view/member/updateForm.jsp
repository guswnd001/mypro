<%@page import="member.MemberDataBean"%>
<%@page import="member.MemberDBBeanMysql"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>

<!-- 서버 부분 -->
<%
	String id = (String)session.getAttribute("memId"); //session은 로그인되어서 저장되어 있는 정보
	MemberDBBeanMysql manager = MemberDBBeanMysql.getInstance();
	
	MemberDataBean member = manager.getMember(id);
%>

<body>

<div class="w3-container">
	<p>회원정보수정 ></p>
	<form action="updatePro.jsp" method="post" onsubmit="return checkIt()" name="userInput">
		<table class="w3-table-all w3-center" style="width: 70%; margin: auto;" border="1">
			<tr>
				<td colspan="2" style="font-size: 24pt; text-align: center;"><b>회원정보수정</b></td>
			</tr>
			<tr>
				<td colspan="2"><b>아이디 입력</b></td>
			</tr>
			<tr>
				<td>사용자 ID</td>
				<td><%=id %></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="password" size="10"></td>
			</tr>
			<tr>
				<td>비밀번호 확인</td>
				<td><input type="password" name="pChk" size="10"></td>
			</tr>
			<tr>
				<td colspan="2"><b>개인정보 입력</b></td>
			</tr>
			<tr>
				<td>사용자 이름</td>
				<td><input type="text" name="name" size="10" value="<%=member.getName()%>"></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="jumin1" size="7" value="<%=member.getJumin1()%>"> - 
					<input type="text" name="jumin2" size="7" value="<%=member.getJumin2()%>"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" size="30" value="<%=member.getEmail()%>"></td>
			</tr>
			<tr>
				<td>Blog</td>
				<td><input type="text" name="blog" size="30" value="<%=member.getBlog()%>"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" name="confirm" value="수정할래">
					<input type="button" name="reset" value="다시입력"
						   onclick="location.href='<%= request.getContextPath() %>/view/member/updateForm.jsp'">
					<input type="button" name="cancle" value="취소할래"
						   onclick="location.href='<%= request.getContextPath() %>/view/member/loginForm.jsp'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>