<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<script src="http://code.jquery.com/jquery-1.7.js"></script>
	<script>
		var index = 0;
		$(document).ready(function () {
			$('button').click(function () {
				var queryString = $('form[name = ajaxForm]').serialize();
				console.log(queryString);
				$.ajax({
					type: 'post',
					url: 'nameCity.jsp',
					data: queryString,
					error: function (xhr, status, error) {
						alert(error);
					},
					success: function (data) {
						//alert('Data: ' + data + '\nStatus: ' + status);
						//$('#view').html(data);
						$('#view').prepend((++index) + " : " + data);
					}
				});
			});
		});
	</script>
</head>
<body>
	<form name="ajaxForm">
		<input type="text" name="name">
		<input type="text" name="city">
		<input type="text" name="cccc">
		<textarea name="content" cols="80" rows="10"></textarea>
	</form>
	<button>POST request</button>
	<div></div>
	<div id="view"></div>
</body>
</html>