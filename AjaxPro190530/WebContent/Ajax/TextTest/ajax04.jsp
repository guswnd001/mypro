<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<script src="http://code.jquery.com/jquery-1.7.js"></script>
	<script>
		$(document).ready(function () {
			$('button').click(function () {
				$('#div1').load('test04.txt?aaa=' + Math.random());
			});
		});
	</script>
</head>
<body>
	<div id="div1">
		<h2>나나나나ㅏ하하하하하하</h2>
	</div>
	<button>get</button>
</body>
</html>