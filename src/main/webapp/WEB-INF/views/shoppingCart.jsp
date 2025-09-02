<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Shopping Cart - Vegefoods</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Google Fonts -->
    <link href="https://fonts.googleapis.com/css?family=Poppins:200,300,400,500,600,700,800&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Lora:400,400i,700,700i&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Amatic+SC:400,700&display=swap" rel="stylesheet">

    <!-- Bootstrap CSS -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.0/css/bootstrap.min.css" rel="stylesheet">
    
    <!-- Font Awesome Icons -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css" rel="stylesheet">

    <!-- Custom CSS - Inline để tránh lỗi file không tải được -->
    <style>
        body {
            font-family: 'Poppins', sans-serif;
            background-color: #f8f9fa;
        }

        /* Navigation Styles */
        .navbar {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            padding: 15px 0;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }

        .navbar-brand {
            color: white !important;
            font-weight: 700;
            font-size: 24px;
        }

        .navbar-nav .nav-link {
            color: white !important;
            font-weight: 500;
            margin: 0 10px;
            transition: all 0.3s ease;
        }

        .navbar-nav .nav-link:hover {
            color: #f8f9fa !important;
            transform: translateY(-2px);
        }

        /* Hero Section */
        .hero-wrap {
            background: linear-gradient(rgba(0,0,0,0.5), rgba(0,0,0,0.5)), url('https://images.unsplash.com/photo-1542838132-92c53300491e?ixlib=rb-4.0.3');
            background-size: cover;
            background-position: center;
            height: 300px;
            display: flex;
            align-items: center;
            justify-content: center;
            color: white;
            text-align: center;
        }

        .breadcrumb {
            background: transparent;
            padding: 0;
            margin: 0;
        }

        .breadcrumb-item a {
            color: #28a745;
            text-decoration: none;
            font-weight: 600;
        }

        .breadcrumb-item.active {
            color: #6c757d;
        }

        /* Cart Container */
        .cart-container {
            background: white;
            border-radius: 20px;
            box-shadow: 0 15px 40px rgba(0,0,0,0.12);
            padding: 50px;
            margin: 50px 0;
            min-height: 600px;
        }

        .cart-header {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
            padding: 35px;
            border-radius: 15px;
            margin-bottom: 40px;
            text-align: center;
            font-size: 20px;
        }

        .cart-header h3 {
            margin: 0;
            font-weight: 700;
        }

        /* Cart Items */
        .cart-item {
            background: #f8f9fa;
            border-radius: 15px;
            padding: 35px;
            margin-bottom: 30px;
            border: 2px solid transparent;
            transition: all 0.3s ease;
            min-height: 150px;
        }

        .cart-item:hover {
            border-color: #28a745;
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.2);
            transform: translateY(-2px);
        }

        .product-image {
            width: 120px;
            height: 120px;
            object-fit: cover;
            border-radius: 12px;
            border: 3px solid #e9ecef;
        }

        .product-info h5 {
            color: #2c3e50;
            font-weight: 600;
            margin-bottom: 10px;
            font-size: 22px;
        }

        .product-info p {
            color: #6c757d;
            font-size: 16px;
            margin: 0;
            line-height: 1.6;
        }

        .price {
            font-size: 24px;
            font-weight: 700;
            color: #28a745;
        }

        .subtotal {
            font-size: 24px;
            font-weight: 700;
            color: #2c3e50;
        }

        /* Quantity Controls */
        .quantity-controls {
            display: flex;
            align-items: center;
            justify-content: center;
            gap: 8px;
            background: white;
            padding: 8px;
            border-radius: 12px;
            border: 2px solid #e9ecef;
            max-width: 160px;
            margin: 0 auto;
        }

        .quantity-btn {
            width: 40px;
            height: 40px;
            border: 2px solid #28a745;
            background: white;
            color: #28a745;
            border-radius: 50%;
            cursor: pointer;
            font-weight: bold;
            font-size: 16px;
            transition: all 0.3s ease;
            display: flex;
            align-items: center;
            justify-content: center;
            flex-shrink: 0;
        }

        .quantity-btn:hover {
            background: #28a745;
            color: white;
            transform: scale(1.05);
        }

        .quantity-btn:disabled {
            opacity: 0.5;
            cursor: not-allowed;
            transform: none;
        }

        .quantity-input {
            width: 60px;
            text-align: center;
            border: 2px solid #e9ecef;
            border-radius: 8px;
            padding: 8px 4px;
            font-weight: 600;
            font-size: 16px;
            flex-shrink: 0;
        }

        .quantity-input:focus {
            border-color: #28a745;
            outline: none;
            box-shadow: 0 0 0 2px rgba(40, 167, 69, 0.2);
        }

        .remove-btn {
            background: #dc3545;
            color: white;
            border: none;
            border-radius: 50%;
            width: 45px;
            height: 45px;
            cursor: pointer;
            transition: all 0.3s ease;
            font-size: 16px;
            display: flex;
            align-items: center;
            justify-content: center;
            margin: 0 auto;
        }

        .remove-btn:hover {
            background: #c82333;
            transform: scale(1.1) rotate(10deg);
        }

        /* Cart Summary */
        .cart-summary {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
            border-radius: 20px;
            padding: 40px;
            position: sticky;
            top: 20px;
            min-height: 400px;
        }

        .cart-summary h4 {
            color: white;
            margin-bottom: 30px;
            font-weight: 700;
            font-size: 24px;
        }

        .summary-item {
            display: flex;
            justify-content: space-between;
            margin-bottom: 20px;
            padding: 15px 0;
            border-bottom: 1px solid rgba(255,255,255,0.2);
            font-size: 18px;
        }

        .summary-item:last-child {
            border-bottom: none;
            font-size: 22px;
            font-weight: 700;
            margin-top: 20px;
            padding-top: 20px;
            border-top: 2px solid rgba(255,255,255,0.3);
        }

        .checkout-btn {
            background: white;
            color: #28a745;
            border: none;
            padding: 20px 40px;
            border-radius: 12px;
            font-weight: 700;
            font-size: 18px;
            width: 100%;
            margin-top: 30px;
            transition: all 0.3s ease;
            text-transform: uppercase;
            letter-spacing: 1px;
        }

        .checkout-btn:hover {
            background: #f8f9fa;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(0,0,0,0.2);
        }

        .clear-cart-btn {
            background: #6c757d;
            color: white;
            border: none;
            padding: 15px 30px;
            border-radius: 10px;
            font-weight: 600;
            font-size: 16px;
            transition: all 0.3s ease;
        }

        .clear-cart-btn:hover {
            background: #5a6268;
            transform: translateY(-2px);
        }

        /* Empty Cart */
        .empty-cart {
            text-align: center;
            padding: 60px 20px;
            background: white;
            border-radius: 15px;
            box-shadow: 0 10px 30px rgba(0,0,0,0.1);
        }

        .empty-cart i {
            font-size: 4rem;
            color: #6c757d;
            margin-bottom: 20px;
        }

        .empty-cart h3 {
            color: #2c3e50;
            margin-bottom: 15px;
            font-weight: 700;
        }

        .empty-cart p {
            color: #6c757d;
            margin-bottom: 30px;
        }

        .continue-shopping-btn {
            background: linear-gradient(135deg, #28a745 0%, #20c997 100%);
            color: white;
            border: none;
            padding: 12px 30px;
            border-radius: 8px;
            font-weight: 600;
            text-decoration: none;
            transition: all 0.3s ease;
        }

        .continue-shopping-btn:hover {
            color: white;
            text-decoration: none;
            transform: translateY(-2px);
            box-shadow: 0 5px 15px rgba(40, 167, 69, 0.3);
        }

        /* Responsive */
        @media (max-width: 768px) {
            .cart-container {
                padding: 30px 20px;
                margin: 20px 10px;
            }
            
            .cart-item {
                padding: 25px 20px;
                min-height: auto;
            }
            
            .product-image {
                width: 100px;
                height: 100px;
                margin: 0 auto;
                display: block;
            }
            
            .cart-summary {
                margin-top: 30px;
                position: static;
                padding: 30px 20px;
            }
            
            .product-info h5 {
                font-size: 18px;
                text-align: center;
            }
            
            .product-info p {
                text-align: center;
                font-size: 14px;
            }
            
            .price, .subtotal {
                font-size: 20px;
            }
            
            .quantity-controls {
                max-width: 140px;
            }
            
            .quantity-btn {
                width: 35px;
                height: 35px;
                font-size: 14px;
            }
            
            .quantity-input {
                width: 50px;
                font-size: 14px;
            }
            
            .remove-btn {
                width: 40px;
                height: 40px;
            }
        }

        @media (max-width: 576px) {
            .cart-item .row > div {
                margin-bottom: 15px;
            }
            
            .cart-item .row > div:last-child {
                margin-bottom: 0;
            }
        }
    </style>
</head>

<body>
    <!-- Navigation -->
    <nav class="navbar navbar-expand-lg navbar-dark">
        <div class="container">
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">
                <i class="fas fa-leaf"></i> Vegefoods
            </a>
            
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav">
                <span class="navbar-toggler-icon"></span>
            </button>
            
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ml-auto">
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/">
                            <i class="fas fa-home"></i> Home
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/shop">
                            <i class="fas fa-store"></i> Shop
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/about">
                            <i class="fas fa-info-circle"></i> About
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/contact">
                            <i class="fas fa-envelope"></i> Contact
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/cart">
                            <i class="fas fa-shopping-cart"></i> Cart
                        </a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Hero Section -->
    <div class="hero-wrap">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-md-8 text-center">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb justify-content-center">
                            <li class="breadcrumb-item">
                                <a href="${pageContext.request.contextPath}/"><i class="fas fa-home"></i> Home</a>
                            </li>
                            <li class="breadcrumb-item active">Shopping Cart</li>
                        </ol>
                    </nav>
                    <h1 class="display-4 mb-0">Shopping Cart</h1>
                </div>
            </div>
        </div>
    </div>

    <!-- Main Content -->
    <section class="py-5">
        <div class="container">
            <c:choose>
                <c:when test="${empty cartItems}">
                    <!-- Empty Cart -->
                    <div class="empty-cart">
                        <i class="fas fa-shopping-cart"></i>
                        <h3>Your cart is empty</h3>
                        <p>Looks like you haven't added any products to your cart yet.</p>
                        <a href="${pageContext.request.contextPath}/shop" class="continue-shopping-btn">
                            <i class="fas fa-arrow-left"></i> Continue Shopping
                        </a>
                    </div>
                </c:when>
                <c:otherwise>
                    <!-- Cart with Items -->
                    <div class="cart-container">
                        <div class="cart-header">
                            <h3>
                                <i class="fas fa-shopping-cart"></i> 
                                Shopping Cart (${totalItems != null ? totalItems : 0} items)
                            </h3>
                        </div>
                        
                        <div class="row">
                            <div class="col-lg-8">
                                <!-- Cart Items -->
                                <c:forEach var="item" items="${cartItems}" varStatus="status">
                                    <div class="cart-item" data-cart-item-id="${item.id}">
                                        <div class="row align-items-center">
                                            <div class="col-lg-2 col-md-3 col-sm-4 mb-3 mb-md-0">
                                                <img src="${item.product.imageProduct != null ? item.product.imageProduct : 'https://via.placeholder.com/120x120?text=Product'}" 
                                                     alt="${item.product.name}" class="product-image img-fluid">
                                            </div>
                                            <div class="col-lg-3 col-md-4 col-sm-8 product-info mb-3 mb-md-0">
                                                <h5>${item.product.name != null ? item.product.name : 'Unknown Product'}</h5>
                                                <p>${item.product.description != null ? item.product.description : 'No description available'}</p>
                                            </div>
                                            <div class="col-lg-2 col-md-2 col-6 text-center mb-3 mb-lg-0">
                                                <div class="price">${item.price != null ? item.price : '0.00'}</div>
                                                <small class="text-muted">Unit Price</small>
                                            </div>
                                            <div class="col-lg-3 col-md-3 col-6 text-center mb-3 mb-lg-0">
                                                <div class="quantity-controls">
                                                    <button class="quantity-btn" onclick="updateQuantity(${item.id}, ${item.quantity - 1})" 
                                                            ${item.quantity <= 1 ? 'disabled' : ''}>
                                                        <i class="fas fa-minus"></i>
                                                    </button>
                                                    <input type="number" class="quantity-input" value="${item.quantity}" 
                                                           min="1" onchange="updateQuantity(${item.id}, this.value)">
                                                    <button class="quantity-btn" onclick="updateQuantity(${item.id}, ${item.quantity + 1})">
                                                        <i class="fas fa-plus"></i>
                                                    </button>
                                                </div>
                                                <small class="text-muted d-block mt-1">Quantity</small>
                                            </div>
                                            <div class="col-lg-1 col-md-6 col-6 text-center mb-3 mb-lg-0">
                                                <div class="subtotal">${item.subtotal != null ? item.subtotal : '0.00'}</div>
                                                <small class="text-muted">Total</small>
                                            </div>
                                            <div class="col-lg-1 col-md-6 col-6 text-center">
                                                <button class="remove-btn" onclick="removeFromCart(${item.id})" 
                                                        title="Remove item">
                                                    <i class="fas fa-trash"></i>
                                                </button>
                                            </div>
                                        </div>
                                    </div>
                                </c:forEach>
                                
                                <!-- Clear Cart Button -->
                                <div class="text-right mt-4">
                                    <button class="clear-cart-btn" onclick="clearCart()">
                                        <i class="fas fa-trash"></i> Clear Cart
                                    </button>
                                </div>
                            </div>
                            
                            <!-- Cart Summary -->
                            <div class="col-lg-4">
                                <div class="cart-summary">
                                    <h4><i class="fas fa-receipt"></i> Order Summary</h4>
                                    
                                    <div class="summary-item">
                                        <span>Subtotal:</span>
                                        <span>$${total != null ? total : '0.00'}</span>
                                    </div>
                                    <div class="summary-item">
                                        <span>Shipping:</span>
                                        <span>Free</span>
                                    </div>
                                    <div class="summary-item">
                                        <span>Total:</span>
                                        <span>$${total != null ? total : '0.00'}</span>
                                    </div>
                                    
                                    <button class="checkout-btn" onclick="checkout()">
                                        <i class="fas fa-credit-card"></i> Proceed to Checkout
                                    </button>
                                    
                                    <div class="text-center mt-3">
                                        <a href="${pageContext.request.contextPath}/shop" class="text-white">
                                            <i class="fas fa-arrow-left"></i> Continue Shopping
                                        </a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </div>
    </section>

    <!-- Scripts -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/4.6.0/js/bootstrap.bundle.min.js"></script>

    <script>
        function updateQuantity(cartItemId, quantity) {
            if (quantity < 1) {
                alert('Quantity cannot be less than 1');
                return;
            }
            
            $.ajax({
                url: '${pageContext.request.contextPath}/cart/update',
                type: 'POST',
                data: {
                    cartItemId: cartItemId,
                    quantity: quantity
                },
                success: function(response) {
                    try {
                        const result = JSON.parse(response);
                        if (result.success) {
                            location.reload();
                        } else {
                            alert(result.message || 'Error updating quantity');
                        }
                    } catch (e) {
                        console.error('Error parsing response:', e);
                        location.reload(); // Fallback: reload the page
                    }
                },
                error: function(xhr, status, error) {
                    console.error('AJAX Error:', error);
                    alert('Error updating quantity. Please try again.');
                }
            });
        }

        function removeFromCart(cartItemId) {
            if (confirm('Are you sure you want to remove this item from your cart?')) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/cart/remove',
                    type: 'POST',
                    data: {
                        cartItemId: cartItemId
                    },
                    success: function(response) {
                        try {
                            const result = JSON.parse(response);
                            if (result.success) {
                                location.reload();
                            } else {
                                alert(result.message || 'Error removing item');
                            }
                        } catch (e) {
                            console.error('Error parsing response:', e);
                            location.reload(); // Fallback: reload the page
                        }
                    },
                    error: function(xhr, status, error) {
                        console.error('AJAX Error:', error);
                        alert('Error removing item from cart. Please try again.');
                    }
                });
            }
        }

        function clearCart() {
            if (confirm('Are you sure you want to clear your entire cart?')) {
                $.ajax({
                    url: '${pageContext.request.contextPath}/cart/clear',
                    type: 'POST',
                    success: function(response) {
                        try {
                            const result = JSON.parse(response);
                            if (result.success) {
                                location.reload();
                            } else {
                                alert(result.message || 'Error clearing cart');
                            }
                        } catch (e) {
                            console.error('Error parsing response:', e);
                            location.reload(); // Fallback: reload the page
                        }
                    },
                    error: function(xhr, status, error) {
                        console.error('AJAX Error:', error);
                        alert('Error clearing cart. Please try again.');
                    }
                });
            }
        }

        function checkout() {
            window.location.href = '${pageContext.request.contextPath}/checkout';
        }

        // Form validation and error handling
        $(document).ready(function() {
            // Handle quantity input validation
            $('.quantity-input').on('input', function() {
                let value = parseInt($(this).val());
                if (isNaN(value) || value < 1) {
                    $(this).val(1);
                }
            });

            // Add loading state for buttons
            $('.quantity-btn, .remove-btn, .clear-cart-btn, .checkout-btn').on('click', function() {
                $(this).prop('disabled', true);
                setTimeout(() => {
                    $(this).prop('disabled', false);
                }, 2000);
            });
        });
    </script>
</body>
</html>