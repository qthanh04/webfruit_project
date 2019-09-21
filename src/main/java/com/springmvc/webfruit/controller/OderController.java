//package com.springmvc.webfruit.controller;
//
//import java.util.List;
//import java.util.Locale;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.springmvc.webfruit.entity.Product;
//import com.springmvc.webfruit.service.impl.IOderService;
//
//@Controller
//public class OderController {
//
//	@Autowired
//	private IOderService oderService;
//	
//	@RequestMapping(value = "/")
//	public String home(Locale locale, Model model) {
//		 List<Product> list = oderService.save(Product product);
//		model.addAttribute("product", list);
//		return "index";
//
//	}
//
//}
