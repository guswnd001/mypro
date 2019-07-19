<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script>

	function checkIt() {
		var userInput = eval("document.userInput");
		
		if(!userInput.id.value) { alert("ID를 입력하세요."); return false; }
		if(!userInput.password.value) { alert("비밀번호를 입력하세요."); return false; }
		if(userInput.password.value != userInput.pchk.value) 
			{ alert("비밀번호를 동일하게 입력하세요."); return false; }
		if(!userInput.name.value) { alert("이름을 입력하세요."); return false; }
		if(!userInput.jumin1.value) { alert("주민번호 앞자리를 입력하세요."); return false; }
		if(!userInput.jumin2.value) { alert("주민번호 뒷자리를 입력하세요."); return false; }
		if(!userInput.email.value) { alert("E-mail을 입력하세요."); return false; }
		if(!userInput.blog.value) { alert("Blog 주소를 입력하세요."); return false; }
	}
	
</script>
</head>
<body>

<div class="w3-container">
	<p>회원가입 ></p>
	<form action="inputPro.jsp" method="post" onsubmit="return checkIt()" name="userInput">
		<table class="w3-table-all w3-center" style="width: 70%; margin: auto;" border="1">
			<tr>
				<td colspan="2" style="font-size: 24pt; text-align: center;">
					<b>회원가입</b>
				</td>
			</tr>
			<tr>
				<td colspan="2"><b>아이디 입력</b></td>
			</tr>
			<tr>
				<td>사용자 ID</td>
				<td><input type="text" name="id" size="10">
					<input type="button" value="ID 중복확인"></td>
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
				<td><input type="text" name="name" size="10"></td>
			</tr>
			<tr>
				<td>주민등록번호</td>
				<td><input type="text" name="jumin1" size="7"> - <input type="text" 
					name="jumin2" size="7"></td>
			</tr>
			<tr>
				<td>E-mail</td>
				<td><input type="text" name="email" size="30"></td>
			</tr>
			<tr>
				<td>Blog</td>
				<td><input type="text" name="blog" size="30"></td>
			</tr>
			<tr>
				<td colspan="2" style="text-align: center;">
					<input type="submit" value="가입할래">
					<input type="submit" value="다시입력">
					<input type="button" value="가입안할래"
						   onclick="javascript:window.location='loginForm.jsp'">
				</td>
			</tr>
		</table>
	</form>
</div>

</body>
</html>