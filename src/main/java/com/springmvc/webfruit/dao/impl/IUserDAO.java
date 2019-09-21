package com.springmvc.webfruit.dao.impl;

import java.util.List;

import com.springmvc.webfruit.entity.User;

public interface IUserDAO {
	
	public void save(User user);
	
	public User searchByUserName(String userName);
	
	public boolean checkExist(String userName , String passWord);

	public boolean update(User user);

	public boolean delete(Integer user);

	public List<User> search(String name);// by id, name

	public User searchById(Integer id);

	public List<User> getList();
	


}
