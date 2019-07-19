<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>
<body>
	<h2>The XMLHttpRequest Object</h2>
	
	<button type="button" onclick="loadJsp()">Request Data</button>
	
	<p id="demo"></p>
	
	<script>
		function loadJsp() {
			var xhttp = new XMLHttpRequest();
			xhttp.open('GET', 'test01.jsp', true);
			xhttp.send();
			//callback
			xhttp.onreadystatechange = function () { 
				if (this.readyState == 4 && this.status == 200) {
					document.getElementById('demo').innerHTML
						= this.responseText;
				}
			};
		}
	</script>
</body>
</html>