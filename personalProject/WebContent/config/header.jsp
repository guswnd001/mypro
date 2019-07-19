<%@page import="com.sun.xml.internal.txw2.Document"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Header Area Start -->
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title  -->
    <title>Libido | Home</title>

    <!-- Favicon  -->
    <link rel="icon" href="../img/core-img/favicon.ico">

    <!-- Core Style CSS -->
    <link rel="stylesheet" href="../css/core-style.css">
    <link rel="stylesheet" href="../style.css">


</head>

<body>
    <!-- Search Wrapper Area Start -->
    <div class="search-wrapper section-padding-100">
        <div class="search-close" style="padding-top: 13px;">
            <i class="fa fa-close" aria-hidden="true"></i>
        </div>
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="search-content">
                        <form action="#" method="get">
                            <input type="search" name="search" id="search" placeholder="키워드를 입력하세요.">
                            <button type="submit"><img src="../img/core-img/search.png" alt=""></button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Search Wrapper Area End -->

    <!-- ##### Main Content Wrapper Start ##### -->
    <div class="main-content-wrapper d-flex clearfix">

        <!-- Mobile Nav (max width 767px)-->
        <div class="mobile-nav">
            <!-- Navbar Brand -->
            <div class="amado-navbar-brand">
                <a href="index.jsp"><img src="../img/core-img/libido_logo4.png" alt=""></a>
            </div>
            <!-- Navbar Toggler -->
            <div class="amado-navbar-toggler">
                <span></span><span></span><span></span>
            </div>
        </div>

<header class="header-area clearfix">
	<!-- Close Icon -->
	<div class="nav-close" style="padding-top: 13px;">
		<i class="fa fa-close" aria-hidden="true"></i>
	</div>
	<!-- Logo -->
	<div class="logo">
		<a href="index.jsp"><img src="../img/core-img/libido_logo.png" alt=""></a>
	</div>
	<!-- Amado Nav -->
	<nav class="amado-nav">
		<ul>
			<li name = "list"><a href="index.jsp">쇼핑</a></li>
			<li name = "list"><a href="shop.jsp">디자이너</a></li>
			<li name = "list"><a href="product-details.jsp">코디 북</a></li>
			<li name = "list"><a href="cart.jsp">장바구니</a></li>
			<li name = "list"><a href="checkout.jsp">바로 결제</a></li>
			
			<script>
				(function(){
					document.getElementsByName("list")[0].addEventListener("click",test);
				})();
				function test(e){
					e.target.setAttribute("class","active")
				}
			</script>
		</ul>
	</nav>
	<!-- Button Group -->
	<div class="amado-btn-group mt-30 mb-100">
		<a href="sale.jsp" class="btn amado-btn mb-15">%세일%</a> 
		<a href="#"	class="btn amado-btn active">신상품</a>
	</div>
	<!-- Cart Menu -->
	<div class="cart-fav-search mb-100">
		<a href="cart.jsp" class="cart-nav"><img src="../img/core-img/cart.png" alt=""> 
			장바구니 <span>(0)</span></a> 
		<a href="#" class="fav-nav"><img src="../img/core-img/favorites.png" alt=""> 
			위시리스트</a> 
		<a href="#" class="search-nav"><img	src="../img/core-img/search.png" alt=""> 
			검색하기</a>
		<a href="#" class="search-nav"><img	src="../img/core-img/join.png" width="21px" height="21px" alt=""> 
			회원가입</a>	
	</div>
	<!-- Social Button -->
	<div class="social-info d-flex justify-content-between">
		<a href="#"><i class="fa fa-pinterest" aria-hidden="true"></i></a> <a
			href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a> <a
			href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a> <a
			href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
	</div>
</header>
<!-- Header Area End -->