<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript">
		var httpRequest = null;
		
		function load(url) {
			httpRequest = new XMLHttpRequest();
			httpRequest.onreadystatechange = CallBack;
			httpRequest.open('get', url, true);
			httpRequest.send();
		}
		
		function CallBack() {
			if (httpRequest.readyState == 4) {
				if (httpRequest.status == 200) {
					alert(httpRequest.responseText);
					var item = JSON.parse(httpRequest.responseText);
					var willOut = '';
					
					for (var i = 0; i < item.length; i++) {
						willOut += '<table class="w3-table-all"><tr>';
						willOut += '<td>' + item[i].author.book + '</td><td>'
								   + item[i].author.pubDate + '</td>';
						willOut += '</tr></table>';
					}
					
					document.getElementById('area').innerHTML = willOut;
				} else {
					alert('실패: ' + httpRequest.status);
				}
			}
		}
	</script>
</head>
<body>
	<input type="button" value="Json read" onclick="load('test03.json')"/>
	<div id="area" class="w3-container"></div>
</body>
</html>