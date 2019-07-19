<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-1.7.js"></script>
	<script>
		$(document).ready(function () {
			$('button').click(function () {
				$.get('test05.jsp', function (data, status) {
					alert('Data: ' + data + '\nStatus: ' + status);
					$('#view').html(data);
				});
			});
		});
	</script>
</head>
<body>
	<button>GET Request</button>
</body>
</html>