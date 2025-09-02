<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- Top Bar -->
<div class="py-1 bg-primary">
    <div class="container">
        <div class="row no-gutters d-flex align-items-center">
            <div class="col-lg-12 d-block">
                <div class="row d-flex">
                    <div class="col-md-3 pr-4 d-flex topper align-items-center">
                        <div class="icon mr-2 d-flex justify-content-center align-items-center">
                            <span class="icon-phone2"></span>
                        </div>
                        <span class="text">+ 1235 2355 98</span>
                    </div>
                    <div class="col-md-4 pr-4 d-flex topper align-items-center">
                        <div class="icon mr-2 d-flex justify-content-center align-items-center">
                            <span class="icon-paper-plane"></span>
                        </div>
                        <span class="text">youremail@email.com</span>
                    </div>
                    <div class="col-md-5 pr-4 d-flex topper align-items-center text-lg-right">
                        <span class="text">3-5 Business days delivery &amp; Free Returns</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- Navigation Bar -->
<nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
    <div class="container">
        <a class="navbar-brand" href="${pageContext.request.contextPath}/">
            <i class="icon-leaf mr-2"></i>Vegefoods
        </a>
        
        <button class="navbar-toggler" type="button" data-toggle="collapse"
            data-target="#ftco-nav" aria-controls="ftco-nav"
            aria-expanded="false" aria-label="Toggle navigation">
            <span class="oi oi-menu"></span> Menu
        </button>

        <div class="collapse navbar-collapse" id="ftco-nav">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/" class="nav-link">
                        <i class="icon-home mr-1"></i>Home
                    </a>
                </li>
                <li class="nav-item dropdown">
                    <a class="nav-link dropdown-toggle" href="#" id="dropdown04"
                        data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        <i class="icon-shopping-bag mr-1"></i>Shop
                    </a>
                    <div class="dropdown-menu" aria-labelledby="dropdown04">
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/shop">
                            <i class="icon-shopping-bag mr-2"></i>Shop
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="icon-heart mr-2"></i>Wishlist
                        </a>
                        <a class="dropdown-item" href="#">
                            <i class="icon-star mr-2"></i>Single Product
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/cart/view">
                            <i class="icon-shopping_cart mr-2"></i>Cart
                        </a>
                        <a class="dropdown-item" href="${pageContext.request.contextPath}/checkout">
                            <i class="icon-credit-card mr-2"></i>Checkout
                        </a>
                    </div>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="icon-info mr-1"></i>About
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="icon-document-text mr-1"></i>Blog
                    </a>
                </li>
                <li class="nav-item">
                    <a href="#" class="nav-link">
                        <i class="icon-location mr-1"></i>Contact
                    </a>
                </li>
                <li class="nav-item">
                    <a href="${pageContext.request.contextPath}/login" class="nav-link">
                        <i class="icon-user mr-1"></i>Login
                    </a>
                </li>
                <li class="nav-item cta cta-colored">
                    <a href="${pageContext.request.contextPath}/cart/view" class="nav-link">
                        <span class="icon-shopping_cart"></span>
                        <span class="cart-badge">[<span id="cart-count">${totalItems != null ? totalItems : 0}</span>]</span>
                    </a>
                </li>
            </ul>
        </div>
    </div>
</nav>
