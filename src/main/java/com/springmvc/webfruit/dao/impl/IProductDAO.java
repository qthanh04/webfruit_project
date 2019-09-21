package com.springmvc.webfruit.dao.impl;

import java.util.List;

import com.springmvc.webfruit.entity.Product;

public interface IProductDAO {

	 public Product enter();//kiem tra du lieu dau vao

	 public boolean checkExist(Product u);

	 public List<Product> getList();

	 public boolean save(Product product);
	 
	 public boolean update(Product product);
	 
	 public boolean delete(Product product);

	 public boolean regis(Product product);

	 public List<Product> search(String name );//by id, name 
	  
	 public Product searchById(Integer id ); 
	 
}
