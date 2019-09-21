package com.springmvc.webfruit.dao;

import java.util.List;

import javax.persistence.NoResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IUserDAO;
import com.springmvc.webfruit.entity.User;

@Repository
@Transactional
public class UserDAO implements IUserDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(user);
	}

	@Override
	public User searchByUserName(String userName) {
		
		Query query = sessionFactory.getCurrentSession().createQuery("FROM User u where u.userName=:userName",
				User.class);
		query.setParameter("userName", userName);
		User user = (User) query.uniqueResult();
		if(user != null) {
			return  user;
		} 
		else {
			return null;
		}

	}

	@Override
	public boolean update(User user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<User> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> getList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean checkExist(String userName, String passWord) {

			Query query = sessionFactory.getCurrentSession()
					.createQuery("FROM User u where u.userName=:userName and u.passWord=:passWord", User.class);
			query.setParameter("userName", userName);
			query.setParameter("passWord", passWord);
				boolean exist = query.uniqueResult() !=null;
				System.out.println("chay vao day2");
				System.out.println("e : "+ exist);
				return  exist;
		
			
	    
			
			
	
		
	
	
	}

}
