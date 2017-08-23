package com.niit.CarShopF.controller;

import java.security.Principal;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.niit.CarShopB.dao.CartDao;
import com.niit.CarShopB.dao.CategoryDao;
import com.niit.CarShopB.dao.ProductDao;
import com.niit.CarShopB.dao.UserDao;
import com.niit.CarShopB.model.Cart;
import com.niit.CarShopB.model.Product;
import com.niit.CarShopB.model.User;

@RequestMapping("/myCart")
@Controller
public class CartController {
	@Autowired(required=true)
	private Cart cart;
	
	@Autowired
	private CartDao cartDao;

	
	@Autowired
	private UserDao userDao;

	@Autowired
	private ProductDao productDao;
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Autowired
	private HttpSession session;

	@RequestMapping("/all")
	public String getCart(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		String loggedInUsername = username;
		session.setAttribute("numberProducts", cartDao.getNumberOfProducts(loggedInUsername));
		session.setAttribute("cartList", cartDao.getCartList(loggedInUsername));
		session.setAttribute("totalAmount", cartDao.getTotalAmount(loggedInUsername));
		model.addAttribute("categoryList",categoryDao.getAllCategory());
		
		return "Cart";
	}

	
	@RequestMapping(value = "/addToCart/{id}")

	public String addToCart(@PathVariable("id") int id, RedirectAttributes redirect, Model model,Principal p) {
		
			Cart cart = new Cart();
			Product product = productDao.getProductId(id);
			System.out.println(product.getProductName());
			cart.setProductName(product.getProductName());
			cart.setCost(product.getProductCost());
			cart.setDate(new Date());
			
			String username=p.getName();
			cart.setUsername(username);
			cart.setStatus("NEW");
			User user =userDao.getUserByUserName(username);
			cart.setUserID(user.getUserId());
			Cart existCart = cartDao.getCartByUsername(username, cart.getProductName());
			if (existCart != null) {
				int currentQuantity = cartDao.getQuantity(username, cart.getProductName());
				cart.setCartID(existCart.getCartID());
				cart.setQuantity(currentQuantity + 1);
				boolean flag = cartDao.update(cart);

				if (flag) {

					redirect.addFlashAttribute("success", product.getProductName() + " " + "Successfully added to cart!");
					session.setAttribute("numberProducts", cartDao.getNumberOfProducts(username));
					return "redirect:/myCart/all";

				} else {
					redirect.addFlashAttribute("error", "Failed to add product to cart!");
					return "redirect:/CatProduct";
				}
			} else {
				System.out.println("first time product is going to add");
				cart.setQuantity(1);
				boolean flag = cartDao.save(cart);

				if (flag) {

					redirect.addFlashAttribute("success", product.getProductName() + " " + "Successfully added to cart!");
					session.setAttribute("numberProducts", cartDao.getNumberOfProducts(username));
					return "redirect:/myCart/all";

				} else {
					redirect.addFlashAttribute("error", "Failed to add product to cart!");
					return "redirect:/CatProduct";
				}
			}
}
	@RequestMapping("/deleteItem/{id}")
	public String deleteCartItem(@PathVariable("id") int id, Model model, RedirectAttributes redirect) {
		try {
			Cart cart = cartDao.getCartById(id);

			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();

			int checkQ = cartDao.getQuantity(username, cart.getProductName());

			if (checkQ > 1) {
				cart.setQuantity(checkQ - 1);
				cartDao.update(cart);
				redirect.addFlashAttribute("success", "Cart updated successfully.");
				return "redirect:/myCart/all";
			} else {
				cartDao.delete(id);
				redirect.addFlashAttribute("success", "Item removed successfully.");
				return "redirect:/myCart/all";
			}
		} catch (Exception e) {
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}
	}

	@RequestMapping("/clearCart")
	public String clearCart(RedirectAttributes redirect, Model model) {
		try {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			String username = auth.getName();
			int flag = cartDao.clearCart(username);

			if (flag >= 1) {
				redirect.addFlashAttribute("success", "All Items removed successfully.");
				return "redirect:/myCart/all";
			} else {
				redirect.addFlashAttribute("error", "Failed to clear cart!");
				return "redirect:/myCart/all";
			}

		} catch (Exception e) {
			model.addAttribute("catchError", "Server is not responding please try again letter.");
			return "error";
		}
	}
}