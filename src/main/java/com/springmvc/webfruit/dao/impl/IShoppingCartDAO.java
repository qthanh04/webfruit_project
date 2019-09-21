package com.springmvc.webfruit.dao.impl;

import java.util.List;

import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.entity.ShoppingCart;

public interface IShoppingCartDAO {

	public void save(ShoppingCart shoppingCart);

	public boolean update(ShoppingCart u);

	public boolean delete(Integer shoppingCart);

	public List<ShoppingCart> search(String name);// by id, name

	public Product searchById(Integer id);

	public List<ShoppingCart> getList();
	
	public List<Product> getListProduct(Integer idUSer );
	
	public List<Product> getListProductSale(String saleCode) ;
}

