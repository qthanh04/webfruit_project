package com.springmvc.webfruit.dao.impl;

import java.util.List;

import com.springmvc.webfruit.entity.CartItem;

public interface ICartItemDAO {
	
	public void addCartItem(CartItem cartItem);
	
	public void updateCartItem(CartItem cartItem);
	
	public void deleteCartItem(Integer cartItemId);
	
	public CartItem getCartItemById(Integer cartItemId);
	
	public List<CartItem> getCartItemsByShoppingCartId(Integer shoppingCartId);
	
	public CartItem getCartItemByProductAndCart(Integer productId, Integer shoppingCartId);
	
	public void deleteAllCartItems(Integer shoppingCartId);
}
