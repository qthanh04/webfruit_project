package com.springmvc.webfruit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IOderDAO;
import com.springmvc.webfruit.entity.Oder;

@Repository
@Transactional
public class OderDAO implements IOderDAO{
	
	
	@Autowired 
	private SessionFactory sessionFactory;
	
	@Override
	public void save(Oder oder) {
		 Session session = this.sessionFactory.getCurrentSession();
		    session.save(oder);
	}


	@Override
	public List<Oder> getList() {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public boolean update(Oder oder) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public boolean delete(Oder oder) {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public Oder searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

}
