package com.niit.CarShopF.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.niit.CarShopB.dao.CategoryDao;
import com.niit.CarShopB.dao.ProductDao;
import com.niit.CarShopB.model.Category;
import com.niit.CarShopB.model.User;
import com.niit.CarShopB.model.Product;
import com.niit.CarShopB.model.BillingDetails;
import com.niit.CarShopB.model.ShippingDetails;

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
		model.addAttribute("productList",productDao.getAllProduct());
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
	@RequestMapping("ROYAL ENFIELD")
	public String royalpowerparts()
	{
		return "royalpowerparts";
		
	}
	
	@RequestMapping("brand")
	public String brand()
	{
		return "brand";
		
	}

	
	@RequestMapping("Sing in")
	public String Signin()
	{
		return "login";
		
	}

	@RequestMapping("contact")
	public String contact()
	{
		return "contact";
		
	}
	
	

	@RequestMapping("ktm")
	public String ktm()
	{
		return"powerparts";
		
		
	} 
	
	@RequestMapping("catgory")
	public String category()
	{
		return "category";
		
	}
	
	

}
