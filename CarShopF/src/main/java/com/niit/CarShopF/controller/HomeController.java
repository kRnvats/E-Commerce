package com.niit.CarShopF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.CarShopB.dao.CategoryDao;
import com.niit.CarShopB.dao.ProductDao;
import com.niit.CarShopB.model.Category;
import com.niit.CarShopB.model.Product;

@Controller
public class HomeController {
	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	
	
	@RequestMapping(value="/")
	public String home()
	{
		
		return "index";
		
	}
	
	
	@RequestMapping("product")
	public String Product(Model model)
	{
		model.addAttribute("product", new Product());
		return "product";
		
		
	}
	
	@RequestMapping("powerparts")
	public String powerparts()
	{
		return"powerparts";
		
		
	}


	@RequestMapping("service")
	public String service()
	{
		return"service";
		
		
	}
	@RequestMapping("powerwear")
	public String powerwear()
	{
		return "powerwear";
		
	}
	
	@RequestMapping("brand")
	public String brand()
	{
		return "brand";
		
	}
	
	
	@RequestMapping("category")
	public String Category(Model model)
	{
	model.addAttribute("category", new Category());
		return"Category";
	}
	
	

	
	

}
