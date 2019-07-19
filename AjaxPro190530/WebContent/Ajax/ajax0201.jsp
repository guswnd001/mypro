<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="/AjaxPro190530/Ajax/httpRequest.js"></script>
</head>
<body>
	<form name="f" method="post">
		<input type="text" name="name" />
		<input type="button" value="입력" onclick="helloToServer()"/>
	</form>
	<div id="demo"></div>
	<script>
		function helloToServer() {
			//var params = '?name=' + encodeURIComponent(document.f.name.value); 
			var params = 'name=' + document.f.name.value;
			sendRequest('test02.jsp', params, callBack, 'post');
		}
		
		function callBack() {
			if (this.readyState == 4 && this.status == 200) {
				document.getElementById('demo').innerHTML
					= this.responseText;
			}
		}
	</script>
</body>
</html>