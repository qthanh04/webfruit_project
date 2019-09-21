package com.springmvc.webfruit;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.springmvc.webfruit.entity.Oder;
import com.springmvc.webfruit.entity.User;

public class Test {
	
	public static void main(String[] args) {
	    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
	    EntityManager entityManager = entityManagerFactory.createEntityManager();
	    entityManager.getTransaction().begin();
	    User user = new User();
	    user.setName("quy");
	    entityManager.persist(user);
	    
	    Oder oder = new Oder();
	    oder.setPaymentMethod("atm");
	    oder.setUser(user);
	    
	    Oder oder2 = new Oder();
	    oder.setPaymentMethod("atm1");
	    oder.setUser(user);
	    
	    entityManager.persist(oder);
	    entityManager.persist(oder2);
	    
	    entityManager.getTransaction().commit();
	   
	    entityManager.close();
	    entityManagerFactory.close();
	  }


}
