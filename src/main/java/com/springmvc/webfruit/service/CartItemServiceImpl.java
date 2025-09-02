package com.springmvc.webfruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.ICartItemDAO;
import com.springmvc.webfruit.dao.impl.IProductDAO;
import com.springmvc.webfruit.dao.impl.IShoppingCartDAO;
import com.springmvc.webfruit.service.impl.ICartItemService;
import com.springmvc.webfruit.entity.CartItem;
import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.entity.ShoppingCart;

@Service
@Transactional
public class CartItemServiceImpl implements ICartItemService {

	@Autowired
	private ICartItemDAO cartItemDAO;
	
	@Autowired
	private IProductDAO productDAO;
	
	@Autowired
	private IShoppingCartDAO shoppingCartDAO;

	@Override
	public void addCartItem(CartItem cartItem) {
		cartItemDAO.addCartItem(cartItem);
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		cartItemDAO.updateCartItem(cartItem);
	}

	@Override
	public void deleteCartItem(Integer cartItemId) {
		cartItemDAO.deleteCartItem(cartItemId);
	}

	@Override
	public CartItem getCartItemById(Integer cartItemId) {
		return cartItemDAO.getCartItemById(cartItemId);
	}

	@Override
	public List<CartItem> getCartItemsByShoppingCartId(Integer shoppingCartId) {
		return cartItemDAO.getCartItemsByShoppingCartId(shoppingCartId);
	}

	@Override
	public CartItem getCartItemByProductAndCart(Integer productId, Integer shoppingCartId) {
		return cartItemDAO.getCartItemByProductAndCart(productId, shoppingCartId);
	}

	@Override
	public void deleteAllCartItems(Integer shoppingCartId) {
		cartItemDAO.deleteAllCartItems(shoppingCartId);
	}

	@Override
	public void addToCart(Integer productId, Integer shoppingCartId, Integer quantity) {
		Product product = productDAO.searchById(productId);
		ShoppingCart shoppingCart = shoppingCartDAO.getShoppingCartById(shoppingCartId);
		
		if (product != null && shoppingCart != null) {
			CartItem existingItem = getCartItemByProductAndCart(productId, shoppingCartId);
			
			if (existingItem != null) {
				// Update quantity if item already exists
				existingItem.setQuantity(existingItem.getQuantity() + quantity);
				updateCartItem(existingItem);
			} else {
				// Create new cart item
				CartItem cartItem = new CartItem();
				cartItem.setProduct(product);
				cartItem.setShoppingCart(shoppingCart);
				cartItem.setQuantity(quantity);
				cartItem.setPrice(product.getPriceSaled() != null ? product.getPriceSaled() : product.getPrice());
				addCartItem(cartItem);
			}
		}
	}

	@Override
	public void updateQuantity(Integer cartItemId, Integer quantity) {
		CartItem cartItem = getCartItemById(cartItemId);
		if (cartItem != null) {
			if (quantity <= 0) {
				deleteCartItem(cartItemId);
			} else {
				cartItem.setQuantity(quantity);
				updateCartItem(cartItem);
			}
		}
	}
}
