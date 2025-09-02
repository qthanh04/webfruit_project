package com.springmvc.webfruit.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.springmvc.webfruit.entity.CartItem;
import com.springmvc.webfruit.entity.ShoppingCart;
import com.springmvc.webfruit.entity.User;
import com.springmvc.webfruit.service.impl.ICartItemService;
import com.springmvc.webfruit.service.impl.IShoppingCartService;

@Controller
@RequestMapping("/checkout")
public class CheckoutController {

	@Autowired
	private ICartItemService cartItemService;
	
	@Autowired
	private IShoppingCartService shoppingCartService;

	@GetMapping
	public String checkout(Model model, HttpSession session) {
		User user = (User) session.getAttribute("user");
		if (user == null) {
			return "redirect:/login";
		}
		
		ShoppingCart cart = shoppingCartService.getShoppingCartByUserId(user.getId());
		if (cart != null) {
			List<CartItem> cartItems = cartItemService.getCartItemsByShoppingCartId(cart.getId());
			
			// Calculate totals manually to avoid LazyInitializationException
			Double total = 0.0;
			Integer totalItems = 0;
			for (CartItem item : cartItems) {
				total += item.getSubtotal();
				totalItems += item.getQuantity();
			}
			
			model.addAttribute("cartItems", cartItems);
			model.addAttribute("cart", cart);
			model.addAttribute("total", total);
			model.addAttribute("totalItems", totalItems);
		} else {
			model.addAttribute("total", 0.0);
			model.addAttribute("totalItems", 0);
		}
		
		return "checkout";
	}

	@PostMapping("/place-order")
	@ResponseBody
	public String placeOrder(@RequestParam("shippingAddress") String shippingAddress,
							@RequestParam("paymentMethod") String paymentMethod,
							HttpSession session) {
		try {
			User user = (User) session.getAttribute("user");
			if (user == null) {
				return "{\"success\": false, \"message\": \"Please login first\"}";
			}
			
			// Here you would implement the order placement logic
			// For now, we'll just return success
			
			return "{\"success\": true, \"message\": \"Order placed successfully!\"}";
		} catch (Exception e) {
			return "{\"success\": false, \"message\": \"Error placing order\"}";
		}
	}
}
