package com.springmvc.webfruit.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IShoppingCartDAO;
import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.entity.ShoppingCart;
import com.springmvc.webfruit.service.impl.IShoppingCartService;

@Service
@Transactional
public class ShoppingCartService implements IShoppingCartService {

	@Autowired
	private IShoppingCartDAO shoppingCartDAO;

	@Override
	public void save(ShoppingCart shoppingCart) {
		shoppingCartDAO.save(shoppingCart);

	}

	@Override
	public boolean update(ShoppingCart u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer shoppingCart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Product> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingCart> getList() {

		return shoppingCartDAO.getList();
	}

	@Override
	public List<Product> getListProductSale(String saleCode) {
		List<Product> listProductSale = new ArrayList<Product>();
		listProductSale = shoppingCartDAO.getListProductSale(saleCode);
		for (Product product : listProductSale) {
			Double price = product.getPrice() * product.getSalePercent();
			product.setPrice(price);
		}
		return listProductSale;
	}

}
