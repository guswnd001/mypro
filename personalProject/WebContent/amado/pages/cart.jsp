<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div class="cart-table-area section-padding-100">
	<div class="container-fluid">
		<div class="row">
			<div class="col-12 col-lg-8">
				<div class="cart-title mt-50">
					<h2>Shopping Cart</h2>
				</div>

				<div class="cart-table clearfix">
					<table class="table table-responsive">
						<thead>
							<tr>
								<th></th>
								<th>Name</th>
								<th>Price</th>
								<th>Quantity</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td class="cart_product_img"><a href="#"><img
										src="../img/bg-img/pro-big-1.jpg" alt="Product"></a></td>
								<td class="cart_product_desc">
									<h5>White Modern Chair</h5>
								</td>
								<td class="price"><span>$130</span></td>
								<td class="qty">
									<div class="qty-btn d-flex">
										<p>Qty</p>
										<div class="quantity">
											<span class="qty-minus"
												onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i
												class="fa fa-minus" aria-hidden="true"></i></span> <input
												type="number" class="qty-text" id="qty" step="1" min="1"
												max="300" name="quantity" value="1"> <span
												class="qty-plus"
												onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i
												class="fa fa-plus" aria-hidden="true"></i></span>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="cart_product_img"><a href="#"><img
										src="../img/bg-img/cart2.jpg" alt="Product"></a></td>
								<td class="cart_product_desc">
									<h5>Minimal Plant Pot</h5>
								</td>
								<td class="price"><span>$10</span></td>
								<td class="qty">
									<div class="qty-btn d-flex">
										<p>Qty</p>
										<div class="quantity">
											<span class="qty-minus"
												onclick="var effect = document.getElementById('qty2'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i
												class="fa fa-minus" aria-hidden="true"></i></span> <input
												type="number" class="qty-text" id="qty2" step="1" min="1"
												max="300" name="quantity" value="1"> <span
												class="qty-plus"
												onclick="var effect = document.getElementById('qty2'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i
												class="fa fa-plus" aria-hidden="true"></i></span>
										</div>
									</div>
								</td>
							</tr>
							<tr>
								<td class="cart_product_img"><a href="#"><img
										src="../img/bg-img/cart3.jpg" alt="Product"></a></td>
								<td class="cart_product_desc">
									<h5>Minimal Plant Pot</h5>
								</td>
								<td class="price"><span>$10</span></td>
								<td class="qty">
									<div class="qty-btn d-flex">
										<p>Qty</p>
										<div class="quantity">
											<span class="qty-minus"
												onclick="var effect = document.getElementById('qty3'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i
												class="fa fa-minus" aria-hidden="true"></i></span> <input
												type="number" class="qty-text" id="qty3" step="1" min="1"
												max="300" name="quantity" value="1"> <span
												class="qty-plus"
												onclick="var effect = document.getElementById('qty3'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i
												class="fa fa-plus" aria-hidden="true"></i></span>
										</div>
									</div>
								</td>
							</tr>
						</tbody>
					</table>
				</div>
			</div>
			<div class="col-12 col-lg-4">
				<div class="cart-summary">
					<h5>Cart Total</h5>
					<ul class="summary-table">
						<li><span>subtotal:</span> <span>$140.00</span></li>
						<li><span>delivery:</span> <span>Free</span></li>
						<li><span>total:</span> <span>$140.00</span></li>
					</ul>
					<div class="cart-btn mt-100">
						<a href="cart.html" class="btn amado-btn w-100">Checkout</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>
</div>
<!-- ##### Main Content Wrapper End ##### -->

<!-- ##### Newsletter Area Start ##### -->
<section class="newsletter-area section-padding-100-0">
	<div class="container">
		<div class="row align-items-center">
			<!-- Newsletter Text -->
			<div class="col-12 col-lg-6 col-xl-7">
				<div class="newsletter-text mb-100">
					<h2>
						회원가입 <span>15% 세일</span>
					</h2>
					<p>회원 가입을 하시면 결제 및 배송 정보 저장, 주문 내역 조회, 반품 요청 및 배송 조회,</p>
					<p>위시리스트 공유하기 등의 다양한 기능을 더욱 편리하게 이용하실 수 있습니다.</p>
				</div>
			</div>
			<!-- Newsletter Form -->
			<div class="col-12 col-lg-6 col-xl-5">
				<div class="newsletter-form mb-100">
					<form action="#" method="post">
						<input type="email" name="email" class="nl-email"
							placeholder="당신의 E-mail"> <input type="submit"
							value="가입하기">
					</form>
				</div>
			</div>
		</div>
	</div>
</section>
<!-- ##### Newsletter Area End ##### -->
