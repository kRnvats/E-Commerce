package com.niit.CarShopF.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.CarShopB.dao.CategoryDao;
import com.niit.CarShopB.dao.ProductDao;
import com.niit.CarShopB.dao.UserDao;

import com.niit.CarShopB.model.User;

@Controller
public class CheckoutController {


	@Autowired
	UserDao userDAO;
	@Autowired
	CategoryDao categoryDao;
	@Autowired
	ProductDao productDao;
	@Autowired
	HttpSession httpSession;
	
	@RequestMapping("/order")
	public String createOrder(Model model1) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		String loggedInUsername = username;

		User user = userDAO.getUserByUserName(loggedInUsername);
	
		System.out.println("hey");
		model1.addAttribute("categoryList",categoryDao.getAllCategory());
	
		model1.addAttribute("productList",productDao.getAllProduct());
		return "redirect:/checkout?userId=" + user.getUserId();
		
	}
}