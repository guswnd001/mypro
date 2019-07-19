<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<form name="f" method="post">
		<input type="text" name="name" />
		<input type="button" value="입력" onclick="helloToServer()"/>
	</form>
	<div id="demo"></div>
	
	<script>
		function helloToServer() {
			var xhttp = new XMLHttpRequest();
			
			xhttp.onreadystatechange = function () {
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById('demo').innerHTML
						= this.responseText;
				}
			};
			
			//한글 인코딩시 문제를 예방하기 위해 encodeURIComponent를 사용한다.
			var params = '?name=' + encodeURIComponent(document.f.name.value); 
			
			xhttp.open('get', 'test02.jsp' + params, true);
			xhttp.send();
		}
	</script>
</body>
</html>