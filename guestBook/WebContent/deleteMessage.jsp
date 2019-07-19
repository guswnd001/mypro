<%@ page import="service.DeleteMessageService"%>
<%@ page import="exception.InvalidPassowrdException" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	int messageId = Integer.parseInt(request.getParameter("messageId"));
	String password = request.getParameter("password");
	boolean invalidPassword = false;
	
	try {
		DeleteMessageService deleteService = DeleteMessageService.getInstance(); 
		deleteService.deleteMessage(messageId, password);
	} catch (InvalidPassowrdException ex) { 
		invalidPassword = true;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록 메세지 삭제함</title>
</head>
<body>

<% if (!invalidPassword) { %>
메세지를 삭제하였습니다.
<% } else { %>
입력한 암호가 올바르지 않습니다. 암호를 확인해주세요.
<% } %>

</body>
</html>