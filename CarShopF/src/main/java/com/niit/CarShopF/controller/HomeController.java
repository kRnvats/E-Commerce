package com.niit.CarShopF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.CarShopB.dao.CategoryDao;
import com.niit.CarShopB.model.Category ;

@Controller
public class HomeController 
{
@Autowired	
CategoryDao categoryDao;

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
	@RequestMapping("/Category")
	public String Category(Model model)
	
	{
		model.addAttribute("categoryList",categoryDao.getAllCategory());
		model.addAttribute("category", new Category());
		
		return "Category";
	}
}


