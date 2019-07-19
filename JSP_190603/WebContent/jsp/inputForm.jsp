<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>회원가입 해볼까</title>
	<script>
		function checkIt() {
			//return true;
			var userinput = eval("document.userinput"); // = document.userinput
			
			if (!userinput.passwd.value) {
				alert('비밀번호를 입력하세요.');
				return false;
			}
			if (userinput.passwd.value != userinput.passwd2.value) {
				alert('비밀번호를 동일하게 입력하세요.');
				return false;
			}
			
			if (!userinput.jumin1.value || !userinput.jumin2.value) {
				alert('주민번호를 입력해주세요.');
				return false;
			}
			
			var chk = 0;
			for (var i = 0; i < userinput.hobby.length; i++) {
				if (userinput.hobby[i].checked) {
					chk += 1;
				}
			}
			if (chk == 0) {
				alert('취미를 한개 이상 선택해주세요.');
				return false;
			}
		}
	</script>
</head>
<body>
	<form action="inputPro.jsp" method="post" name="userinput" onsubmit="return checkIt()">
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
					maxlength="12" required="required"></td>
			</tr>
			<tr>
				<td width="200">비밀번호</td>
				<td width="400"><input type="password" name="passwd" size="15"
					maxlength="12"></td>
			</tr>
			<tr>
				<td width="200">비밀번호 확인</td>
				<td width="400"><input type="password" name="passwd2" size="15"
					maxlength="12"></td>
			</tr>
			<tr>
				<td width="200" colspan="2"><b>개인정보 입력</b></td>
			</tr>
			<tr>
				<td width="200">사용자 이름</td>
				<td width="400"><input type="text" name="name" size="15"
					maxlength="10"></td>
			</tr>
			<tr>
				<td width="200">주민등록번호</td>
				<td width="400"><input type="text" name="jumin1" size="7"
					maxlength="6"> - <input type="text" name="jumin2" size="7"
					maxlength="7"></td>
			</tr>
			<tr>
				<td width="200">자기소개</td>
				<td><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
			<tr>
				<td width="200">성별</td>
				<td width="400">
					여자:<input type="radio" name="gender" value="여자" id="여자">
					남자:<input type="radio" name="gender" value="남자" id="남자"></td> 
			</tr>
			<tr>
				<td width="200">국가</td>
				<td width="400"><select name="nation">
						<option value="대한민국" selected="selected" id="대한민국">대한민국</option>
						<option value="미국" id="미국">미국</option>
						<option value="일본" id="일본">일본</option>
						<option value="북한" id="북한">북한</option>
					</select></td>
			</tr>
			<tr>
				<td width="200">취미</td>
				<td width="400">
					여행:<input type="checkbox" name="hobby" value="여행" id="여행">
					음악:<input type="checkbox" name="hobby" value="음악" id="음악">
					독서:<input type="checkbox" name="hobby" value="독서" id="독서">
					운동:<input type="checkbox" name="hobby" value="운동" id="운동">
					총검술:<input type="checkbox" name="hobby" value="총검술" id="총검술"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit"
					name="confirm" value="등     록"> <input type="reset"
					name="reset" value="다시 입력"> <input type="button"
					value="가입안함" onclick="javascript:window.location='main.jsp'">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>