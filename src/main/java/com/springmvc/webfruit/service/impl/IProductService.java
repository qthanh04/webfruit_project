package com.springmvc.webfruit.service.impl;

import java.util.List;

import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.entity.User;

public interface IProductService {
	
	 public Product enter();//kiem tra du lieu dau vao

	 public boolean checkExist(Product u);

	 public List<Product> getList();

	 public void save(Product product);
	 
	 public boolean update(Product u);
	 
	 public boolean delete(Product u);
	  
	  public List<Product> search(String name );//by id, name 
	  
	  public Product searchById(Integer id );
	  


}
