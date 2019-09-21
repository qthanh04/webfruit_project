package com.springmvc.webfruit.dao.impl;

import java.util.List;

import com.springmvc.webfruit.entity.Oder;

public interface IOderDAO {
	
	 public List<Oder> getList();

	 public void save(Oder oder);
	 
	 public boolean update(Oder oder);
	 
	 public boolean delete(Oder oder);
	 
	 public Oder searchById(Integer id );

}
