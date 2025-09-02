package com.springmvc.webfruit.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springmvc.webfruit.dao.impl.IUserDAO;
import com.springmvc.webfruit.entity.ShoppingCart;
import com.springmvc.webfruit.entity.User;
import com.springmvc.webfruit.service.impl.IShoppingCartService;

@Controller
public class LoginController {

	@Autowired
	private IUserDAO userDAO;
	
	@Autowired
	private IShoppingCartService shoppingCartService;

	@GetMapping("/login")
	public String loginPage() {
		return "login";
	}

	@PostMapping("/login")
	public String login(@RequestParam("username") String username,
						@RequestParam("password") String password,
						HttpSession session,
						Model model) {
		
		boolean isValid = userDAO.checkExist(username, password);
		
		if (isValid) {
			User user = userDAO.searchByUserName(username);
			session.setAttribute("user", user);
			
			// Create shopping cart for user if not exists
			ShoppingCart cart = shoppingCartService.getShoppingCartByUserId(user.getId());
			if (cart == null) {
				cart = new ShoppingCart();
				cart.setUser(user);
				shoppingCartService.save(cart);
			}
			
			return "redirect:/";
		} else {
			model.addAttribute("error", "Invalid username or password");
			return "login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
