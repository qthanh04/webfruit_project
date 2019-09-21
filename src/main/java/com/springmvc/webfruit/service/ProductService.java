package com.springmvc.webfruit.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IProductDAO;
import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.service.impl.IProductService;

@Service
@Transactional
public class ProductService implements IProductService  {

	@Autowired
	private IProductDAO productDAO;
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Override
	public Product enter() {
		// TODO Auto-generated method stub
		return null;
	}
	


	@Override
	public boolean checkExist(Product u) {
		// TODO Auto-generated method stub
		return false;
	}
	
	@Override
	@Transactional
	public List<Product> getList() {
		
		return productDAO.getList();
	}

	@Override
	public void save(Product product) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean update(Product u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Product u) {
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
		return productDAO.searchById(id);
	}
	

}
