package com.niit.CarShopF.controller;

import java.security.Principal;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.niit.CarShopB.dao.CartDao;
import com.niit.CarShopB.dao.UserDao;
import com.niit.CarShopB.model.BillingDetails;
import com.niit.CarShopB.model.Cart;
import com.niit.CarShopB.model.Category;
import com.niit.CarShopB.model.User;
import com.niit.CarShopB.model.ShippingDetails;


@Controller
public class UserController {
	@Autowired
	HttpSession httpSession;
	@Autowired
	UserDao userDao;
	@Autowired
	CartDao cartDao;
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
	@RequestMapping(value="/logg",method=RequestMethod.POST)
	public String validate(HttpServletRequest httpServletRequest,Principal p,Model model)
	{
		
			
		
		 	httpSession=httpServletRequest.getSession(true);
			httpSession.setAttribute("loggedInUser", true);
			httpSession.setAttribute("loggedInUsername",userDao.getUserByUserName(p.getName()));
			httpSession.setAttribute("loggedInName",p.getName());
			Cart cart=new Cart();
			httpSession.setAttribute("numberProducts", cartDao.getNumberOfProducts(p.getName()));
			httpSession.setAttribute("cartList", cartDao.getCartList(p.getName()));
			
		return "/";
	}
}

	
	
	

