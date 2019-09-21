package com.springmvc.webfruit.controller;

import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.service.impl.IProductService;

@Controller

public class ProductController {
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		List<Product> list = productService.getList();
		model.addAttribute("product", list);
		return "index";

	}
	
	@RequestMapping(value = "/shop")
	public String shop(Locale locale, Model model) {
		List<Product> list = productService.getList();
		model.addAttribute("product", list);
		return "shop";

	}

	@RequestMapping("/{id}")
	public String editPerson(@PathVariable("id") int id, Model model) {
		model.addAttribute("product", this.productService.searchById(id));
		model.addAttribute("product1", this.productService.getList());
	    
		
		
		return "detailProduct";
	}

}
