<%@ page import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>절대 경로 사용하여 자원 읽기</title>
</head>
<body>

<%
	char[] buff = new char[128];
	int len = -1;
	
	String filePath = "D:/Hyeonjoong/Java_H2/Java_H/JSP_190603/WebContent/JSP/notice.txt";
	try (InputStreamReader fr
			= new InputStreamReader(new FileInputStream(filePath), "utf-8")) {
		while ((len = fr.read(buff)) != -1) {
			out.print(new String(buff, 0, len));
		}
	} catch (IOException ex) {
		out.println("익셉션 발생: " + ex.getMessage());
	}
%>

</body>
</html>