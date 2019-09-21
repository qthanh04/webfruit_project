package com.springmvc.webfruit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IProductDAO;
import com.springmvc.webfruit.entity.Product;

@Repository
@Transactional
public class ProductDAO implements IProductDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public boolean save(Product product) {
		 Session session = this.sessionFactory.getCurrentSession();
		    session.save(product);
			return false;
	}
	
   @Override
	public List<Product> getList() {
	Session session = sessionFactory.getCurrentSession();
		String sql = "From Product ";
		List<Product> list = session.createQuery(sql, Product.class).getResultList();
		return list;

	}


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
	public boolean update(Product product) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Product product) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean regis(Product product) {
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
		
		return (Product) sessionFactory.getCurrentSession().get(
				Product.class, id);
	}
	
	
	
	
}
