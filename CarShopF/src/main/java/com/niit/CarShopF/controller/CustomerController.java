package com.niit.CarShopF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.niit.CarShopB.dao.CustomerDao;

@Controller
public class CustomerController {

	@Autowired
	CustomerDao customerDao;
	
		@RequestMapping(value="register")
		public String register()
		{
			
			return "register";
			
		}
		
	}
	
	
	


