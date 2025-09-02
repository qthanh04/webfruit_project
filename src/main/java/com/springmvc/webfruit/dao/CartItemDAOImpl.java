package com.springmvc.webfruit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.webfruit.dao.impl.ICartItemDAO;
import com.springmvc.webfruit.entity.CartItem;

@Repository
public class CartItemDAOImpl implements ICartItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public void addCartItem(CartItem cartItem) {
		getCurrentSession().save(cartItem);
	}

	@Override
	public void updateCartItem(CartItem cartItem) {
		getCurrentSession().update(cartItem);
	}

	@Override
	public void deleteCartItem(Integer cartItemId) {
		CartItem cartItem = getCartItemById(cartItemId);
		if (cartItem != null) {
			getCurrentSession().delete(cartItem);
		}
	}

	@Override
	public CartItem getCartItemById(Integer cartItemId) {
		return (CartItem) getCurrentSession().get(CartItem.class, cartItemId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<CartItem> getCartItemsByShoppingCartId(Integer shoppingCartId) {
		return getCurrentSession()
				.createQuery("from CartItem ci JOIN FETCH ci.product where ci.shoppingCart.id = :shoppingCartId")
				.setParameter("shoppingCartId", shoppingCartId)
				.list();
	}

	@Override
	public CartItem getCartItemByProductAndCart(Integer productId, Integer shoppingCartId) {
		return (CartItem) getCurrentSession()
				.createQuery("from CartItem where product.id = :productId and shoppingCart.id = :shoppingCartId")
				.setParameter("productId", productId)
				.setParameter("shoppingCartId", shoppingCartId)
				.uniqueResult();
	}

	@Override
	public void deleteAllCartItems(Integer shoppingCartId) {
		getCurrentSession()
				.createQuery("delete from CartItem where shoppingCart.id = :shoppingCartId")
				.setParameter("shoppingCartId", shoppingCartId)
				.executeUpdate();
	}
}
