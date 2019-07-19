<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴</title>
</head>
<body>

	<div class="w3-container">
		<p>회원탈퇴 ></p>
		<form action="deletePro.jsp" name="userDelete" method="post"
			onsubmit="return checkIt()">
			<table class="w3-table-all w3-center"
				style="width: 40%; margin: auto;">
				<tr>
					<td colspan="2" style="text-align: center;"><font size="+1"><b>회원탈퇴</b></font>
					</td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td align="center"><input type="password" name="password"
						size="15" maxlength="12"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;"><input
						type="submit" value="탈퇴할래"> <input type="button"
						value="취소" onclick="javascript:window:location='loginForm.jsp'">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>