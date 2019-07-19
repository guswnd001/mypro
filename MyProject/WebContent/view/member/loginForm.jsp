<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<html>
<head>
<title>로그인</title>

<script language="javascript">
	function begin() {
		document.myform.id.focus();
	}
	function checkIt() {
		if (!document.myform.id.value) {
			alert("아이디을 입력하지 않으셨습니다.");
			document.myform.id.focus();
			return false;
		}
		if (!document.myform.passwd.value) {
			alert("비밀번호를 입력하지 않으셨습니다.");
			document.myform.passwd.focus();
			return false;
		}

	}
</script>
</head>
<BODY>
	
<%
	if (session.getAttribute("memId") == null) {
%>
		<p class="w3-left" style="padding-left: 30px;">로그인 ></p>
		<div class="w3-container">
			<form name="myform" action="loginPro.jsp" method="post"
				onSubmit="return checkIt()">
				<TABLE class="w3-table-all" style="width: 50%; margin: auto;">

					<TR height="30">
						<TD colspan="2" style="text-align: center;"><STRONG>회원로그인</STRONG></TD>
					</TR>

					<TR height="30">
						<TD width="110" align=center>아이디</TD>
						<TD width="150" align=center><INPUT type="text" name="id"
							size="15" maxlength="12"></TD>
					</TR>
					<TR height="30">
						<TD width="110" align=center>비밀번호</TD>
						<TD width="150" align=center><INPUT type=password
							name="password" size="15" maxlength="12"></TD>
					</TR>
					<TR height="30">
						<TD colspan="2" align="middle" style="text-align: center;">
						<INPUT type="submit" value="로그인"> 
						<INPUT type="reset" value="다시입력">
						<input type="button" value="회원가입"
							onclick="javascript:window.location='inputForm.jsp'"></TD>
					</TR>
				</TABLE>
			</form>
		</div>
<% } else { %>
<div align="center">
	<p><%= session.getAttribute("memId") %>님이 방문하셨습니다.</p>
	<input type="button" value="로그아웃"
		onclick="location.href='<%= request.getContextPath() %>/view/member/logout.jsp'">
	<input type="button" value="회원정보수정"
		onclick="location.href='<%= request.getContextPath() %>/view/member/updateForm.jsp'">
	<input type="button" value="회원탈퇴"
		onclick="location.href='<%= request.getContextPath() %>/view/member/deleteForm.jsp'">
</div>
<%
	}
%>
	
</BODY>
</HTML>