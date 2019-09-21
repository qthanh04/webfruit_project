package com.springmvc.webfruit.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.springmvc.webfruit.dao.impl.IShoppingCartDAO;
import com.springmvc.webfruit.dao.impl.IUserDAO;
import com.springmvc.webfruit.entity.ShoppingCart;
import com.springmvc.webfruit.entity.User;
import com.springmvc.webfruit.service.impl.IShoppingCartService;
import com.springmvc.webfruit.service.impl.IUserService;

@Controller
@SessionAttributes("idUser")
@RequestMapping("/cart")
public class CartController {

	@Autowired
	IShoppingCartService shoppingCartService;

	@Autowired
	IShoppingCartDAO shoppingCartDAO;

	@Autowired
	IUserService userService;

	@Autowired
	IUserDAO userDAO;
	
	@GetMapping("/myCart")
	public String addCart2(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("idUser");
		if (id == null) {
			return "login";
		} else {
			return "redirect:/myCart";

		}

	}

	@GetMapping("/{id}")
	public String addCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("idUser");
		if (id == null) {
			return "login";
		} else {
			return "redirect:/myCart";

		}

	}

	@RequestMapping(value = "/doLogin", method = RequestMethod.POST)
	public String loginError(Model model, @RequestParam("username") String userName,
			@RequestParam("password") String passWord) {
		boolean check = userDAO.checkExist(userName, passWord);
		if (check) {
			Integer idU = userDAO.searchByUserName(userName).getId();
			model.addAttribute("idUser", idU);
			ShoppingCart shoppingCart = new ShoppingCart();
			User user = new User();
			shoppingCart.setUser(user = userDAO.searchByUserName(userName));
			shoppingCartService.save(shoppingCart);
			return "redirect:/myCart";
		} else if (check == false) {
			return "redirect:/login";
		}
		return "redirect:/login";

	}
}
