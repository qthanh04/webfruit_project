package com.springmvc.webfruit.service.impl;

import java.util.List;

import com.springmvc.webfruit.entity.User;



public interface IUserService {
	public Boolean checkExistUser(User user) ;
	
	 public User enter();//kiem tra du lieu dau vao

	 public boolean checkExist(User u);

	 public List<User> getAll();

	 public boolean insert(User u);
	 
	 public boolean update(User u);
	 
	 public boolean delete(Integer id);

	 public boolean regis(User u);

	  public User login();

	  public boolean resetPass(String email);

	  public List<User> search(String name );//by id, name 

	public  void save(User user);

	public boolean  checkExist(String userName, String passWord);
	  
	  
		
	

}
