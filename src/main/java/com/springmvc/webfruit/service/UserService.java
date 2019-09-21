package com.springmvc.webfruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IUserDAO;
import com.springmvc.webfruit.entity.User;
import com.springmvc.webfruit.service.impl.IUserService;

@Service
@Transactional
public class UserService implements IUserService {
	
	@Autowired
	IUserDAO userDAO;	

	@Override
	public Boolean checkExistUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User enter() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExist(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean update(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean regis(User u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User login() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean resetPass(String email) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkExist(String userName, String passWord) {
		boolean check= userDAO.checkExist(userName, passWord);
		return check;
	}

	
}
