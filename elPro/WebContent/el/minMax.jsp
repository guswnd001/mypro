<%@page import="java.util.Arrays"%>
<%@page import="el.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EL min, max</title>
</head>
<body>

<!-- EL은 리터값이 꼭 있어야 하기 때문에 값을 할당할 때에는 ;뒤에 ''를 꼭 주어야 한다!!! -->
${ vals = [20, 17, 30, 2, 9, 23]; '' }
${ vals.stream().min().get() }
<hr>
<%
	List<Member> memberList = Arrays.asList(
			new Member("김현중", 28), new Member("김주호", 26),
			new Member("조혜빈", 24), new Member("이승주", 27) );
	
	request.setAttribute("members", memberList);
%>
${ maxAgeMemOpt = members.stream().max((m1, m2) -> m1.age.compareTo(m2.age)); '' }
${ maxAgeMemOpt.get().name } (${ maxAgeMemOpt.get().age }세)
<hr>
${ minAgeMemOpt = members.stream().min((m1, m2) -> m1.age.compareTo(m2.age)); '' }
${ minAgeMemOpt.get().name } (${ minAgeMemOpt.get().age }세)

</body>
</html>