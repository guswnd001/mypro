<%@page import="java.util.Arrays"%>
<%@page import="el.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL sort</title>
</head>
<body>

${ vals = [20, 17, 30, 2, 9, 23];
   sortedVals = vals.stream().sorted().toList() } <!-- 오름차순 -->
<hr>
${ vals = [20, 17, 30, 2, 9, 23];
   sortedVals = vals.stream().sorted((x1, x2) -> x1 < x2 ? 1 : -1).toList() } <!-- 내림차순 -->
<hr>
<%
	List<Member> memberList = Arrays.asList(
			new Member("김현중", 28), new Member("김주호", 26),
			new Member("조혜빈", 24), new Member("이승주", 27) );
	
	request.setAttribute("members", memberList);
%>
${ sortedMem = members.stream().sorted((m1, m2) -> m1.age.compareTo(m2.age)).toList() }

</body>
</html>