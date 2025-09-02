package com.springmvc.webfruit.controller;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.springmvc.webfruit.entity.Product;
import com.springmvc.webfruit.service.impl.IProductService;

@Controller
public class HomeController {
	
	@Autowired
	private IProductService productService;

	@RequestMapping(value = "/")
	public String home(Locale locale, Model model) {
		List<Product> list = productService.getList();
		model.addAttribute("product", list);
		return "index";
	}
	
	@RequestMapping(value = "/index")
	public String index(Locale locale, Model model) {
		return home(locale, model);
	}
	
	@RequestMapping(value = "/home")
	public String homePage(Locale locale, Model model) {
		return home(locale, model);
	}
}
