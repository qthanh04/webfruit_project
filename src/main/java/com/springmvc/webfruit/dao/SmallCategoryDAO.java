package com.springmvc.webfruit.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.entity.SmallCategory;

@Repository
@Transactional
public class SmallCategoryDAO {

	@Autowired 
	private SessionFactory sessionFactory;

	public void save(SmallCategory smallCategory) {
		 Session session = this.sessionFactory.getCurrentSession();
		    session.save(smallCategory);
	}
}
