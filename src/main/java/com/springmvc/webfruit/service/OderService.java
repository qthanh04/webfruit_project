package com.springmvc.webfruit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IOderDAO;
import com.springmvc.webfruit.entity.Oder;
import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.service.impl.IOderService;

@Service
@Transactional
public class OderService implements IOderService {
	
	@Autowired
	private IOderDAO oderDAO;
	
	@Override
	public void save(Oder oder) {
		oderDAO.save(oder);
	}

	

	@Override
	public boolean update(Oder oder) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public boolean delete(Integer id) {
		// TODO Auto-generated method stub
		return false;
	}



	@Override
	public Oder searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}




	@Override
	public List<Oder> getList() {
		// TODO Auto-generated method stub
		return null;
	}

}
