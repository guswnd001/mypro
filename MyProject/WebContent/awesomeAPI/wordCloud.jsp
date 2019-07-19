<%@page import="visualChart.WordCloud"%>
<%@page import="java.util.Set"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!doctype html>
<!--[if lt IE 7]><html class="no-js lt-ie9 lt-ie8 lt-ie7" lang="en"><![endif]-->
<!--[if IE 7]><html class="no-js lt-ie9 lt-ie8" lang="en"><![endif]-->
<!--[if IE 8]><html class="no-js lt-ie9" lang="en"><![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js" lang="en">
<!--<![endif]-->
<head>

<%
	String url = null;
	String selector = null;
	
	if (url == null) {
		//url = "http://news.naver.com/main/history/mainnews/index.nhn";
		url = "https://news.naver.com/main/home.nhn";
	}
	if (selector == null) {
	 selector = "div[class~=section]";
	}
	
	Map<String, Long> map = WordCloud.getInstance().map(url, selector, 30);
	Set<Map.Entry<String, Long>> set = map.entrySet();
	request.setAttribute("set", set);
%>

<meta charset="utf-8">
<title>jQuery awesomeCloud Plugin Demos</title>
<meta name="description" content="A Word Cloud plugin for jQuery.">
<meta name="viewport" content="width=device-width,initial-scale=1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.0/jquery.min.js"></script>
<script src="jquery.awesomeCloud-0.2.js"></script>
<style type="text/css">
.wordcloud {
border: 1px solid #036;
height: 7in;
margin: 0.5in auto;
padding: 0;
page-break-after: always;
page-break-inside: avoid;
width: 7in;
}
</style>
<link href="http://www.jqueryscript.net/css/jquerysctipttop.css" rel="stylesheet" type="text/css">
</head>
<body>

<header style="margin-top:150px;">
<h1>jQuery awesomeCloud Plugin Demos</h1>
</header>

<div role="main">
<p>Square, automatic scaling, print-ready, randomized word order</p>
<div id="wordcloud1" class="wordcloud">

	<c:forEach var="m" items="${set }">
		<c:if test="${m.value > 1 }">
			<span data-weight="${m.value*10 }">${m.key }</span>
		</c:if>
	</c:forEach>
 
</div>


<p>Circle, manual scaling, normalized weighting</p>
<div id="wordcloud2" class="wordcloud">

	<c:forEach var="m" items="${set }">
		<c:if test="${m.value > 1 }">
			<span data-weight="${m.value*10 }">${m.key }</span>
		</c:if>
	</c:forEach>

</div>


<p>Star, densely packed, manual scaling, normalized weighting, print-ready</p>
<div id="wordcloud3" class="wordcloud"> 

	<c:forEach var="m" items="${set }">
		<c:if test="${m.value > 1 }">
			<span data-weight="${m.value*10 }">${m.key }</span>
		</c:if>
	</c:forEach>

</div>

</div>

<footer>
	<p>Licensed under the <a href="http://www.gnu.org/licenses/gpl.html">GPL v3</a></p>
</footer>
<script>
			$(document).ready(function(){
				$("#wordcloud1").awesomeCloud({
					"size" : {
						"grid" : 16,
						"normalize" : false
					},
					"options" : {
						"color" : "random-dark",
						"rotationRatio" : 0.35,
						"printMultiplier" : 3,
						"sort" : "random"
					},
					"font" : "'Times New Roman', Times, serif",
					"shape" : "square"
				});
				$("#wordcloud2").awesomeCloud({
					"size" : {
						"grid" : 9,
						"factor" : 1
					},
					"options" : {
						"color" : "random-dark",
						"rotationRatio" : 0.35
					},
					"font" : "'Times New Roman', Times, serif",
					"shape" : "circle"
				});
				$("#wordcloud3").awesomeCloud({
					"size" : {
						"grid" : 1,
						"factor" : 3
					},
					"color" : {
						"background" : "#036"
					},
					"options" : {
						"color" : "random-light",
						"rotationRatio" : 0.5,
						"printMultiplier" : 3
					},
					"font" : "'Times New Roman', Times, serif",
					"shape" : "star"
				});
			});
		</script> 
<!--[if lt IE 7 ]>
		<script src="//ajax.googleapis.com/ajax/libs/chrome-frame/1.0.3/CFInstall.min.js"></script>
		<script>window.attachEvent('onload',function(){CFInstall.check({mode:'overlay'})})</script>
		<![endif]-->
        
<script type="text/javascript">

  var _gaq = _gaq || [];
  _gaq.push(['_setAccount', 'UA-36251023-1']);
  _gaq.push(['_setDomainName', 'jqueryscript.net']);
  _gaq.push(['_trackPageview']);

  (function() {
    var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
    ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
  })();

</script>
</body>
</html>
