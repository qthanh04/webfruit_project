package com.springmvc.webfruit.service.impl;

import java.util.List;

import com.springmvc.webfruit.entity.CartItem;

public interface ICartItemService {
	
	public void addCartItem(CartItem cartItem);
	
	public void updateCartItem(CartItem cartItem);
	
	public void deleteCartItem(Integer cartItemId);
	
	public CartItem getCartItemById(Integer cartItemId);
	
	public List<CartItem> getCartItemsByShoppingCartId(Integer shoppingCartId);
	
	public CartItem getCartItemByProductAndCart(Integer productId, Integer shoppingCartId);
	
	public void deleteAllCartItems(Integer shoppingCartId);
	
	public void addToCart(Integer productId, Integer shoppingCartId, Integer quantity);
	
	public void updateQuantity(Integer cartItemId, Integer quantity);
}
