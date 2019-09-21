package com.springmvc.webfruit.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.webfruit.dao.impl.IShoppingCartDAO;
import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.service.impl.IShoppingCartService;

@Controller

public class ShoppingCartController {
	@Autowired
	private IShoppingCartService shoppingCartService;
	
	@Autowired
	private IShoppingCartDAO shoppingCartDAO;
	
	@RequestMapping("/myCart")
	public String myCart(@RequestParam("idUser") String id, Model model) {
	
		List<Product> listProduct= new ArrayList<Product>();
		Integer idX = Integer.parseInt(id);
		System.out.println(id);
		
		listProduct= shoppingCartDAO.getListProduct(idX);
		model.addAttribute("product",listProduct);
		return "myCart";
	}

	@RequestMapping("/saleCode")
	public String saleCode(@RequestParam("saleCode") String saleCode, Model model) {
		List<Product> listProduct= new ArrayList<Product>();
		listProduct=shoppingCartDAO.getListProductSale(saleCode);
		
		return "";
	}
	
	
}
