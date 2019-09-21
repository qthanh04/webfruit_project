package com.springmvc.webfruit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.entity.ImageProduct;

@Repository
@Transactional
public class ImageProductDAO {
	
	@Autowired 
	private SessionFactory sessionFactory;

	public void save(ImageProduct imageProduct) {
		 Session session = this.sessionFactory.getCurrentSession();
		    session.save(imageProduct);
	}
	
	public List<ImageProduct> getList() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ImageProduct";
		List<ImageProduct> list = session.createQuery(sql, ImageProduct.class).getResultList();
		return list;

	}
  

}
//SELECT first_table.ID, CASE WHEN EXISTS (SELECT * FROM second_table WHERE first_table.ID = second_table.ID) THEN 1 ELSE 0 END FROM first_table