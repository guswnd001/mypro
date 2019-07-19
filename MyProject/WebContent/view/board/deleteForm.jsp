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
	int num = Integer.parseInt(request.getParameter("num"));
	String pageNum = request.getParameter("pageNum");
%>

	<div class="w3-container">
		<p>게시글 삭제 ></p>
		<form action="deletePro.jsp" name="deleteForm" method="post">
			<input type="hidden" name="num" value="<%=num%>">
			<input type="hidden" name="pageNum" value="<%=pageNum%>">
			<table class="w3-table-all w3-center"
				style="width: 40%; margin: auto;">
				<tr>
					<td colspan="2" style="text-align: center;"><font size="+1"><b>글 삭제</b></font>
					</td>
				</tr>
				<tr>
					<td align="center">비밀번호</td>
					<td align="center"><input type="password" name="passwd"
						size="15" maxlength="12"></td>
				</tr>
				<tr>
					<td colspan="2" style="text-align: center;">
						<input type="submit" value="글 삭제"> 
						<input type="button" value="취소" 
							   onclick="document.location.href='list.jsp?pageNum=<%=pageNum%>'">
					</td>
				</tr>
			</table>
		</form>
	</div>

</body>
</html>