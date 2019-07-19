<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>I LOVE Google!!</title>
	<script src="http://code.jquery.com/jquery-1.7.js"></script>
	<script type="text/javascript">
		function sendKeyword() {
			if ($("#keyword").val() == '') {
				$("#suggest").hide();
			} else {
				$.ajax({
					type: 'post',
					url: 'command.jsp',
					data: "keyword=" + $("#keyword").val(),
					error: function (xhr, status, error) {	},
					success: function (data) {
						$("#suggestList").html(data);
						$("#suggest").show();
					}
				});
			}
		}
		
		function submitOk(str) {
				$("#keyword").val(str);
		}
		
		$(document).ready(function () {
			$("#keyword").keydown(function () {
				setTimeout("sendKeyword();", 400);
			});
		});
	</script>
	<style>
		.center { position: relative; left: 25%; }
		.input { size: 300px; }
		#view { border: 1px solid #999; }
		#keywordbox { float: left; margin: 10px; width: 25%;
					  padding: 20px; border-radius: 20px; text-decoration: none;
					  border: 0px; box-shadow: 1px 2px 4px rgba(0, 0, 0, .5); }
		#keyword { padding: 5px; text-decoration: none; border: 0px; }
		#button { position: relative; top: 15px; padding: 15px;
				  border-radius: 10px; text-decoration: none; }
		input: focus { outline: none; }
		a { text-decoration: none; }
		#suggest { margin-top: 10px; border-top: 1px solid #E1DEDD; }
		#suggestList > a { color: black; font-weight: 900; }
	</style>
	
</head>
<body>
	<br>
	<br>
	<br>
	<br>
	<br>
	<div class="center">
		<img src="https://www.google.com/images/branding/googlelogo/2x/googlelogo_color_272x92dp.png"
			 width= "30%" />
		<br>
		<br>
		<form name="search" method="post">
			<div id="keywordbox">
				<input type="text" name="keyword" id="keyword" size="25%" />
				<div id="suggest">
					<div id="suggestList"></div>
				</div>
			</div>
			<input type="submit" value="검색" id="button" />
		</form>
	</div>
</body>
</html>