<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
	request.setCharacterEncoding("utf-8");
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table width="600" border="1" cellspacing="0" cellpadding="3"
		align="center">
		<tr>
			<td colspan="2" height="39" align="center"><font size="+1"><b>회원가입</b></font>
			</td>
		</tr>
		<tr>
			<td width="200" colspan="2"><b>아이디 입력</b></td>
		</tr>
		<tr>
			<td width="200">사용자 ID</td>
			<td width="400"><input type="text" name="id" size="10"
				maxlength="12" value='<%=request.getParameter("id")%>'></td>
		</tr>
		<tr>
			<td width="200">비밀번호</td>
			<td width="400"><input type="password" name="passwd" size="15"
				maxlength="12" value='<%=request.getParameter("passwd")%>'></td>
		</tr>
		<tr>
			<td width="200">비밀번호 확인</td>
			<td width="400"><input type="password" name="passwd2" size="15"
				maxlength="12" value='<%=request.getParameter("passwd2")%>'></td>
		</tr>
		<tr>
			<td width="200" colspan="2"><b>개인정보 입력</b></td>
		</tr>
		<tr>
			<td width="200">사용자 이름</td>
			<td width="400"><input type="text" name="name" size="15"
				maxlength="10" value='<%=request.getParameter("name")%>'></td>
		</tr>
		<tr>
			<td width="200">주민등록번호</td>
			<td width="400"><input type="text" name="jumin1" size="7"
				maxlength="6" value='<%=request.getParameter("jumin1")%>'> -
				<input type="text" name="jumin2" size="7" maxlength="7"
				value='<%=request.getParameter("jumin2")%>'></td>
		</tr>
		<tr>
			<td width="200">자기소개</td>
			<td><textarea rows="10" cols="50" name="content"><%=request.getParameter("content")%>
				</textarea></td>
		</tr>
		<tr>
			<td width="200">성별</td>
			<td width="400">
				여자:<input type="radio" name="gender" value="여자" id="여자">
				남자:<input type="radio" name="gender" value="남자"id="남자">
				<script>
					document.getElementById('<%=request.getParameter("gender")%>').checked = true;	
				</script></td>
		</tr>
		<tr>
			<td width="200">국가</td>
			<td width="400"><select name="nation">
					<option value="대한민국" id="대한민국">대한민국</option>
					<option value="미국" id="미국">미국</option>
					<option value="일본" id="일본">일본</option>
					<option value="북한" id="북한">북한</option>
				</select>
				<script>
					document.getElementById('<%=request.getParameter("nation")%>').selected = true;	
				</script></td>
		</tr>
		<tr>
			<td width="200">취미</td>
			<td width="400">
				여행:<input type="checkbox" name="hobby" value="여행" id="여행"> 
				음악:<input type="checkbox" name="hobby" value="음악" id="음악"> 
				독서:<input type="checkbox" name="hobby" value="독서" id="독서"> 
				총검술:<input type="checkbox" name="hobby" value="총검술" id="총검술">	
				<script>
					<%
						String[] hobbys = request.getParameterValues("hobby");
						
							for (String str : hobbys) {
								%> document.getElementById('<%=str%>').checked = true; <%
							}
					%>
				</script>
			</td>
		</tr>
	</table>
</body>
</html>