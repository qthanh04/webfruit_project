package com.springmvc.webfruit.service.impl;

import java.util.List;

import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.entity.ShoppingCart;

public interface IShoppingCartService {
	
	public void save(ShoppingCart shoppingCart);
	 
	 public boolean update(ShoppingCart u);
	 
	 public boolean delete(Integer shoppingCart);
	  
	  public List<Product> search(String name );//by id, name 
	  
	  public Product searchById(Integer id );

	List<ShoppingCart> getList();
	
	public List<Product> getListProductSale(String saleCode);
	
	public ShoppingCart getShoppingCartByUserId(Integer userId);
}
