<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.io.*" %>
<%@ page import="java.net.URL" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 기본 객체 사용하여 자원 읽기2</title>
</head>
<body>

<%
	String resourcePath = "/JSP/notice.txt";
	char[] buff = new char[128];
	int len = -1;
	//URL url = application.getResource(resourcePath);
	URL url = new URL("https://www.daum.net/");
	
	try (InputStreamReader br =
				new InputStreamReader(url.openStream(), "UTF-8")) {
		while ((len = br.read(buff)) != -1) {
			//out.print(new String(buff, 0, len));
			String temp = new String(buff, 0, len);
			out.print(temp);
			System.out.println(temp);
		}
	} catch (IOException ex) {
		out.println("익셉션 발생" + ex.getMessage());
	}
%>

</body>
</html>