package com.niit.CarShopF.controller;

import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CarShopB.dao.ProductDaoImpl;
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
		return "Product";
		
		
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
	
	@RequestMapping("category")
	public String Category(Model model)
	{
	model.addAttribute("category", new Category());
		return"Category";
	}
	
	

	
	

}
