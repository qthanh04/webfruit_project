package com.springmvc.webfruit.service.impl;

import java.util.List;

import com.springmvc.webfruit.entity.Oder;

public interface IOderService {
	
     public void save(Oder oder);
	 
	 public boolean update(Oder oder);
	 
	 public boolean delete(Integer id);
	  
	 public Oder searchById(Integer id );
	 
	 public List<Oder> getList();
	  

}
