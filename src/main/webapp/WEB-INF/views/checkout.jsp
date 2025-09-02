<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Checkout - Vegefoods</title>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="resources/css/open-iconic-bootstrap.min.css">
<link rel="stylesheet" href="resources/css/animate.css">
<link rel="stylesheet" href="resources/css/owl.carousel.min.css">
<link rel="stylesheet" href="resources/css/owl.theme.default.min.css">
<link rel="stylesheet" href="resources/css/magnific-popup.css">
<link rel="stylesheet" href="resources/css/aos.css">
<link rel="stylesheet" href="resources/css/ionicons.min.css">
<link rel="stylesheet" href="resources/css/bootstrap-datepicker.css">
<link rel="stylesheet" href="resources/css/jquery.timepicker.css">
<link rel="stylesheet" href="resources/css/flaticon.css">
<link rel="stylesheet" href="resources/css/icomoon.css">
<link rel="stylesheet" href="resources/css/style.css">

<style>
.checkout-form {
    background: white;
    border-radius: 8px;
    padding: 30px;
    box-shadow: 0 2px 10px rgba(0,0,0,0.1);
    margin-bottom: 30px;
}

.order-summary {
    background: #f8f9fa;
    border-radius: 8px;
    padding: 20px;
    position: sticky;
    top: 20px;
}

.product-image {
    width: 60px;
    height: 60px;
    object-fit: cover;
    border-radius: 4px;
}

.form-group label {
    font-weight: 600;
    margin-bottom: 8px;
}

.form-control {
    border-radius: 6px;
    border: 1px solid #ddd;
    padding: 12px;
}

.form-control:focus {
    border-color: #28a745;
    box-shadow: 0 0 0 0.2rem rgba(40, 167, 69, 0.25);
}

.btn-checkout {
    background: #28a745;
    color: white;
    border: none;
    padding: 15px 30px;
    border-radius: 6px;
    font-weight: 600;
    font-size: 16px;
    transition: all 0.3s;
}

.btn-checkout:hover {
    background: #218838;
    transform: translateY(-2px);
}
</style>
</head>
<body class="goto-here">
	<div class="py-1 bg-primary">
		<div class="container">
			<div
				class="row no-gutters d-flex align-items-start align-items-center px-md-0">
				<div class="col-lg-12 d-block">
					<div class="row d-flex">
						<div class="col-md pr-4 d-flex topper align-items-center">
							<div
								class="icon mr-2 d-flex justify-content-center align-items-center">
								<span class="icon-phone2"></span>
							</div>
							<span class="text">+ 1235 2355 98</span>
						</div>
						<div class="col-md pr-4 d-flex topper align-items-center">
							<div
								class="icon mr-2 d-flex justify-content-center align-items-center">
								<span class="icon-paper-plane"></span>
							</div>
							<span class="text">youremail@email.com</span>
						</div>
						<div
							class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
							<span class="text">3-5 Business days delivery &amp; Free
								Returns</span>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	
	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/">Vegefoods</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item"><a href="${pageContext.request.contextPath}/" class="nav-link">Home</a></li>
					<li class="nav-item"><a href="${pageContext.request.contextPath}/shop" class="nav-link">Shop</a></li>
					<li class="nav-item"><a href="about.html" class="nav-link">About</a></li>
					<li class="nav-item"><a href="blog.html" class="nav-link">Blog</a></li>
					<li class="nav-item"><a href="contact.html" class="nav-link">Contact</a></li>
					<li class="nav-item cta cta-colored"><a href="${pageContext.request.contextPath}/cart/view"
						class="nav-link"><span class="icon-shopping_cart"></span>[<span id="cart-count">${totalItems}</span>]</a></li>
				</ul>
			</div>
		</div>
	</nav>

	<div class="hero-wrap hero-bread"
		style="background-image: url('resources/images/bg_1.jpg');">
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-center justify-content-center">
				<div class="col-md-9 ftco-animate text-center">
					<p class="breadcrumbs">
						<span class="mr-2"><a href="${pageContext.request.contextPath}/">Home</a></span> 
						<span class="mr-2"><a href="${pageContext.request.contextPath}/cart/view">Cart</a></span> 
						<span>Checkout</span>
					</p>
					<h1 class="mb-0 bread">Checkout</h1>
				</div>
			</div>
		</div>
	</div>

	<section class="ftco-section">
		<div class="container">
			<div class="row">
				<div class="col-lg-8">
					<div class="checkout-form">
						<h3>Shipping Information</h3>
						<hr>
						<form id="checkout-form">
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="firstName">First Name</label>
										<input type="text" class="form-control" id="firstName" name="firstName" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="lastName">Last Name</label>
										<input type="text" class="form-control" id="lastName" name="lastName" required>
									</div>
								</div>
							</div>
							
							<div class="form-group">
								<label for="email">Email</label>
								<input type="email" class="form-control" id="email" name="email" required>
							</div>
							
							<div class="form-group">
								<label for="phone">Phone</label>
								<input type="tel" class="form-control" id="phone" name="phone" required>
							</div>
							
							<div class="form-group">
								<label for="shippingAddress">Shipping Address</label>
								<textarea class="form-control" id="shippingAddress" name="shippingAddress" rows="3" required></textarea>
							</div>
							
							<div class="row">
								<div class="col-md-6">
									<div class="form-group">
										<label for="city">City</label>
										<input type="text" class="form-control" id="city" name="city" required>
									</div>
								</div>
								<div class="col-md-6">
									<div class="form-group">
										<label for="zipCode">ZIP Code</label>
										<input type="text" class="form-control" id="zipCode" name="zipCode" required>
									</div>
								</div>
							</div>
							
							<h3 class="mt-4">Payment Method</h3>
							<hr>
							
							<div class="form-group">
								<div class="form-check">
									<input class="form-check-input" type="radio" name="paymentMethod" id="creditCard" value="creditCard" checked>
									<label class="form-check-label" for="creditCard">
										Credit Card
									</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="paymentMethod" id="paypal" value="paypal">
									<label class="form-check-label" for="paypal">
										PayPal
									</label>
								</div>
								<div class="form-check">
									<input class="form-check-input" type="radio" name="paymentMethod" id="cashOnDelivery" value="cashOnDelivery">
									<label class="form-check-label" for="cashOnDelivery">
										Cash on Delivery
									</label>
								</div>
							</div>
							
							<div id="creditCardFields">
								<div class="row">
									<div class="col-md-6">
										<div class="form-group">
											<label for="cardNumber">Card Number</label>
											<input type="text" class="form-control" id="cardNumber" name="cardNumber" placeholder="1234 5678 9012 3456">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="expiryDate">Expiry Date</label>
											<input type="text" class="form-control" id="expiryDate" name="expiryDate" placeholder="MM/YY">
										</div>
									</div>
									<div class="col-md-3">
										<div class="form-group">
											<label for="cvv">CVV</label>
											<input type="text" class="form-control" id="cvv" name="cvv" placeholder="123">
										</div>
									</div>
								</div>
							</div>
						</form>
					</div>
				</div>
				
				<div class="col-lg-4">
					<div class="order-summary">
						<h4>Order Summary</h4>
						<hr>
						
						<c:forEach var="item" items="${cartItems}">
							<div class="d-flex align-items-center mb-3">
								<img src="${item.product.imageProduct}" alt="${item.product.name}" class="product-image mr-3">
								<div class="flex-grow-1">
									<h6 class="mb-0">${item.product.name}</h6>
									<small class="text-muted">Qty: ${item.quantity}</small>
								</div>
								<div class="text-right">
									<span class="font-weight-bold">$${item.subtotal}</span>
								</div>
							</div>
						</c:forEach>
						
						<hr>
						<div class="d-flex justify-content-between mb-2">
							<span>Subtotal:</span>
							<span>$${total}</span>
						</div>
						<div class="d-flex justify-content-between mb-2">
							<span>Shipping:</span>
							<span>Free</span>
						</div>
						<hr>
						<div class="d-flex justify-content-between mb-3">
							<strong>Total:</strong>
							<strong>$${total}</strong>
						</div>
						
						<button class="btn btn-checkout btn-block" onclick="placeOrder()">
							Place Order
						</button>
						
						<div class="text-center mt-3">
							<a href="${pageContext.request.contextPath}/cart/view" class="text-muted">Back to Cart</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<script src="resources/js/jquery.min.js"></script>
	<script src="resources/js/jquery-migrate-3.0.1.min.js"></script>
	<script src="resources/js/popper.min.js"></script>
	<script src="resources/js/bootstrap.min.js"></script>
	<script src="resources/js/jquery.easing.1.3.js"></script>
	<script src="resources/js/jquery.waypoints.min.js"></script>
	<script src="resources/js/jquery.stellar.min.js"></script>
	<script src="resources/js/owl.carousel.min.js"></script>
	<script src="resources/js/jquery.magnific-popup.min.js"></script>
	<script src="resources/js/aos.js"></script>
	<script src="resources/js/jquery.animateNumber.min.js"></script>
	<script src="resources/js/bootstrap-datepicker.js"></script>
	<script src="resources/js/scrollax.min.js"></script>
	<script src="resources/js/main.js"></script>

	<script>
	$(document).ready(function() {
		// Show/hide credit card fields based on payment method
		$('input[name="paymentMethod"]').change(function() {
			if ($(this).val() === 'creditCard') {
				$('#creditCardFields').show();
			} else {
				$('#creditCardFields').hide();
			}
		});
	});

	function placeOrder() {
		// Validate form
		if (!$('#checkout-form')[0].checkValidity()) {
			$('#checkout-form')[0].reportValidity();
			return;
		}
		
		const formData = new FormData($('#checkout-form')[0]);
		formData.append('shippingAddress', $('#shippingAddress').val());
		formData.append('paymentMethod', $('input[name="paymentMethod"]:checked').val());
		
		$.ajax({
			url: '${pageContext.request.contextPath}/checkout/place-order',
			type: 'POST',
			data: formData,
			processData: false,
			contentType: false,
			success: function(response) {
				const result = JSON.parse(response);
				if (result.success) {
					alert('Order placed successfully!');
					window.location.href = '${pageContext.request.contextPath}/';
				} else {
					alert(result.message);
				}
			},
			error: function() {
				alert('Error placing order');
			}
		});
	}
	</script>
</body>
</html>
