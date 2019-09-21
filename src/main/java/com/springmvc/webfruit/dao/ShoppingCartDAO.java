package com.springmvc.webfruit.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.webfruit.dao.impl.IShoppingCartDAO;
import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.entity.ShoppingCart;

@Repository
@Transactional
public class ShoppingCartDAO implements IShoppingCartDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void save(ShoppingCart shoppingCartDAO) {
		Session session = this.sessionFactory.getCurrentSession();
		session.save(shoppingCartDAO);
	}

	@Override
	public boolean update(ShoppingCart u) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Integer shoppingCart) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<ShoppingCart> search(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product searchById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<ShoppingCart> getList() {
		Session session = sessionFactory.getCurrentSession();
		String sql = "From ShoppingCart ";
		List<ShoppingCart> list = session.createQuery(sql, ShoppingCart.class).getResultList();
		return list;

	}

	@Override
	public List<Product> getListProduct(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT p FROM Product as p Inner JOIN ShoppingCart as s ON p.shoppingCart.id = s.id  WHERE s.user.id =:id ";
		  List<Product> listProduct = session.createQuery(hql,Product.class).setParameter("id", id).getResultList(); 
		    return listProduct;
	}

	@Override
	public List<Product> getListProductSale(String saleCode) {
		Session session = sessionFactory.getCurrentSession();
		String hql = "SELECT p FROM Product as p WHERE saleCode Like :saleCode ";
		  List<Product> listProductSale = session.createQuery(hql,Product.class).setParameter("saleCode", "%"+saleCode+"%").getResultList(); 
		    return listProductSale;
	}

	

	

}
