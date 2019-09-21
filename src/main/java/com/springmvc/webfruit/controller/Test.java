//package com.springmvc.webfruit.controller;
//
//import java.util.HashSet;
//import java.util.Locale;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.springmvc.webfruit.dao.BigCategoryDAO;
//import com.springmvc.webfruit.dao.ImageProductDAO;
//import com.springmvc.webfruit.dao.MediumCategoryDAO;
//import com.springmvc.webfruit.dao.RateDAO;
//import com.springmvc.webfruit.dao.ShippingDAO;
//import com.springmvc.webfruit.dao.SmallCategoryDAO;
//import com.springmvc.webfruit.dao.UserDAO;
//import com.springmvc.webfruit.dao.impl.IOderDAO;
//import com.springmvc.webfruit.entity.Oder;
//import com.springmvc.webfruit.entity.Product;
//import com.springmvc.webfruit.entity.Rate;
//import com.springmvc.webfruit.entity.User;
//
//@Controller
//
//@RequestMapping("/")
//public class Test {
//	
//	@Autowired
//	UserDAO userDao;
//	
//	@Autowired
//	IOderDAO oderDao;
//	
//	@Autowired
//	ShippingDAO shippingDAO;
//	
//	@Autowired
//	SmallCategoryDAO smallCategoryDAO;
//	
//	@Autowired 
//	MediumCategoryDAO mediumCategoryDAO;
//	
//	@Autowired
//	BigCategoryDAO bigCategoryDAO;
//	
//	@Autowired
//	ImageProductDAO imageProductDAO;
//	
//	@Autowired
//	RateDAO rateDAO;
//	
////	@Autowired
////	IShoppingCartDAO shoppingCartDAO;
////	
//	@GetMapping
//	public String home(Locale locale, Model model) {
//					
//			User user = new User();
//			
//			user.setName("quy");
//			user.setAddress("ha noi");
//			user.setEmail("quy.nd172778@gmail.com");
//			user.setPhone("0868970605");
//			user.setUserName("nguyenducquy");
//			user.setPassWord("12345aDs@");
//			user.setImg("resources/images/product-2.jpg");
//			user.setStatus(true);
//			
//			userDao.save(user);
//			System.out.println("luu user thanh cong" );
//			
//			Rate rate = new Rate();
//			rate.setContent("San pham tot");
//			rate.setStatus(true);
//			rate.setRateUser(user);
//			
//			Rate rate1 = new Rate();
//			rate1.setContent("San pham chua tot");
//			rate1.setRateUser(user);
//			
//			rateDAO.save(rate);
//			rateDAO.save(rate1);
//			
//			System.out.println("lưu rate thành công");
//			
//			
//		    Product product1 = new Product();
//		    product1.setName("Carrots");
//		    product1.setSupplier("Poland");
//		    product1.setPrice(80000.0);
//		    product1.setPriceSaled(60000.0);
//		    product1.setAvaiable(500.0);
//		    product1.setDescription("A small river named Duden flows by their place and supplies it with tof sentences fly into your mouth. n to its own, since her and so it didn’t take long until.");
//		    product1.setSaleCode("2134er");
//		    product1.setSalePercent(15.0);
//		    product1.setStatus(true);
//		   
//		 
//		   
//		    Product product2 = new Product();
//		    product2.setName(" Green Beans");
//		    product2.setSupplier("Thailand");
//		    product2.setPrice(80000.0);
//		    product2.setPriceSaled(60000.0);
//		    product2.setAvaiable(500.0);
//		    product2.setDescription("far from the countries Vokalia and Consonantia, there live the blind text ");
//		    product2.setSalePercent(15.0);
//		    product2.setStatus(true);
//		
//
//		    Set<Product> products = new HashSet<Product>();
//		    products.add(product1);
//		    products.add(product2);
//		    
//		    Oder oder2 = new Oder();
//		    oder2.setName("Da Dat hang");
//		    oder2.setPrice(400.0);
//		    oder2.setTotalMoney(500.0);
//		    oder2.setQuantity(3);
//		    oder2.setPaymentMethod("momo");
//		    oder2.setStatus(true);
//		    oder2.setUser(user);	 
//		    oder2.setProducts(products); 
//		
//		    oderDao.save(oder2);
//		    System.out.println("luu oder thanh cong");
//		    
//		    ShoppingCart shoppingCart= new ShoppingCart();
//		    shoppingCart.setUser(user);
//		    shoppingCart.setListProduct(products);
//		    shoppingCartDAO.save(shoppingCart);
////		    
//		    
//		    
//			
//	    
////		    
////		    ImageProduct imageProduct1= new ImageProduct();
////		    imageProduct1.setUrl("D://data");
////		    imageProduct1.setStatus(true);
////		    imageProduct1.setImageProduct(product1);
////		    
////		    ImageProduct imageProduct2= new ImageProduct();
////		    imageProduct2.setUrl("D://data2");
////		    imageProduct2.setStatus(true);
////		    imageProduct2.setImageProduct(product1);
////		    
////		    imageProductDAO.save(imageProduct1);
////		    imageProductDAO.save(imageProduct2);
////		    
////		    
////		    
//////		    SmallCategory smallCategory = new SmallCategory();
//////		    smallCategory.setName("Banana");
//////		    smallCategory.setStatus(true);
//////		    smallCategory.setProducts(products);
//////		    smallCategoryDAO.save(smallCategory);
//////		    
////		    
////		    
////		    Shipping shipping= new Shipping();
////		    shipping.setFee(500.0);
////		    shipping.setOder(oder2);
////		    shipping.setStatus(true);
////		    shippingDAO.save(shipping);
////		    
//////		    BigCategory bigCategory = new BigCategory();
//////			bigCategory.setName("rau xanh");
//////			bigCategory.setStatus(true);
//////			bigCategoryDAO.save(bigCategory);
//////		    
//////		    MediumCategory mediumCategory=new MediumCategory();
//////			mediumCategory.setName("rau nhap khau");
//////			mediumCategory.setStatus(true);
//////			mediumCategory.setBigCategory(bigCategory);
//////			mediumCategoryDAO.save(mediumCategory);
//////			
//////			MediumCategory mediumCategory2=new MediumCategory();
//////			mediumCategory2.setName("rau xuat khau");
//////			mediumCategory2.setStatus(true);
//////			mediumCategory2.setBigCategory(bigCategory);
//////			mediumCategoryDAO.save(mediumCategory2);
//////			
//////			
//////			
//////			
//////			 SmallCategory smallCategory1 = new SmallCategory();
//////			    smallCategory1.setName("hoa qua tuoi");
//////			    smallCategory1.setProducts(products);
//////			    smallCategory1.setMediumCategory(mediumCategory);
//////			    smallCategoryDAO.save(smallCategory1);
//////			    
//////			    SmallCategory smallCategory2 = new SmallCategory();
//////			    smallCategory2.setName("hoa tuoi");
//////			    smallCategory2.setProducts(products);
//////			    smallCategory2.setMediumCategory(mediumCategory);
//////			    
//////			    smallCategoryDAO.save(smallCategory1);
//////			    smallCategoryDAO.save(smallCategory2);
////			    
////			
////		
////		    
////		  
////		
////		   System.out.println("luu thanh cong 3" );
////		
//		return "index";
////
//}
//}
