<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script type="text/javascript" src="httpRequest.js"></script>
	<script>
		function loadList() {
			sendRequest('maxTemperature.jsp', null, loadedList, 'get');
		}
		
		function loadedList() {
			if (httpRequest.readyState == 4) {
				if (httpRequest.status == 200) {
					var csvStr = httpRequest.responseText;
					//콤마로 이어온 값을 분리
					var temperatureStrs = csvStr.split(',');
					var temperatures = new Array(temperatureStrs.length);
					
					for (var i = 0; i < temperatureStrs.length; i++) {
						temperatures[i] = parseFloat(temperatureStrs[i]);
					}
					
					var max = temperatures[0];
					
					for (var i = 0; i < temperatures.length; i++) {
						if (max < temperatures[i]) {
							max = temperatures[i];
						}
					}
					
					var maxtemp = document.getElementById('maxtemp');
					maxtemp.innerHTML = '<strong>' + max + '</strong>';
				} else {
					alert(httpRequest.status);
				}
			}
		}
		
		window.onload = function () {
			loadList();
		}
	</script>
</head>
<body>
	최근 4일간 최고기온: <span id="maxtemp"></span>
</body>
</html>