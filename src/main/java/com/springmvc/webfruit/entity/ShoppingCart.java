package com.springmvc.webfruit.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name = "shoppingcart")
public class ShoppingCart {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@OneToOne
	  @JoinColumn(name = "userId")
	  private User user ;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "shoppingCart")
	  private Set<CartItem> cartItems = new HashSet<CartItem>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItem> cartItems) {
		this.cartItems = cartItems;
	}
	
	public Double getTotal() {
		Double total = 0.0;
		for (CartItem item : cartItems) {
			total += item.getSubtotal();
		}
		return total;
	}
	
	public Integer getTotalItems() {
		Integer total = 0;
		for (CartItem item : cartItems) {
			total += item.getQuantity();
		}
		return total;
	}
}
