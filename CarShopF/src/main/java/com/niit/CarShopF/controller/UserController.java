package com.niit.CarShopF.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.niit.CarShopB.dao.UserDao;
import com.niit.CarShopB.model.BillingDetails;
import com.niit.CarShopB.model.Category;
import com.niit.CarShopB.model.User;
import com.niit.CarShopB.model.ShippingDetails;


@Controller
public class UserController {

	@Autowired
	UserDao userDao;
	@RequestMapping(value="/addUser",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")User c)
	{
		userDao.addUser(c);
		return "register";
		
	}

	@RequestMapping("register")
	public String register(Model model)

	{
		ShippingDetails s = new ShippingDetails();
		BillingDetails b = new BillingDetails();
		User c = new User();
		c.setBillingDetails(b);
		c.setShippingDetails(s);
		model.addAttribute("user", new User());
		return "register";
		
	}
	@RequestMapping("logg")
	public String logg()
	{
		return "/";
		
	}
	
}

	
	
	


