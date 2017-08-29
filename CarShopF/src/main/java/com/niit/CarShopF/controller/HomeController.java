package com.niit.CarShopF.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
	@Autowired
	HttpSession session;
	@Autowired
	SessionFactory sessionFactory;
	@RequestMapping(value="/")
	public String home()
	{
		session.setAttribute("catList", categoryDao.getAllCategory());
		return "index";
		
	}

	@Transactional
	@RequestMapping(value="/products/{id}")
	public String showProductsById(@PathVariable("id")String cid, Model model)
	{
		System.out.println("xncvmb,mnvbc"+cid);
		List<Product> list=sessionFactory.getCurrentSession().createQuery("from Product where categoryID='"+cid+"'").list();
		model.addAttribute("proList",list);
		return "products";		
		
	}
	@RequestMapping("/LogOut")
	public String Logout()
	{
		return "redirect:/index";
	}
	@RequestMapping("/admin/product")
	public String Product(Model model)
	{
		model.addAttribute("categoryList",categoryDao.getAllCategory());

		model.addAttribute("productList",productDao.getAllProduct());
		model.addAttribute("product", new Product());
		return "product";
		
		
	}
	
	@RequestMapping("powerparts")
	public String powerparts(Model model)
	{
		model.addAttribute("productList",productDao.getAllProduct());
		return"powerparts";
		}
	


	@RequestMapping("service")
	public String service()
	{
		return"service";
		
		
	}
	@RequestMapping("powerwear")
	public String powerwear(Model model)
	{
		model.addAttribute("productList",productDao.getAllProduct());
		return "powerwear";
		
	}
	@RequestMapping("royalpowerwear")
	public String royalpowerwear(Model model)
	{
		model.addAttribute("productList",productDao.getAllProduct());
		return "royalpowerwear";
		
	}
	@RequestMapping("harleypowerwear")
	public String harleypowerwear(Model model)
	{
		model.addAttribute("productList",productDao.getAllProduct());
		return "harleypowerwear";
		
	}
	@RequestMapping("royalpowerparts")
	public String royalpowerparts(Model model)
	{
		model.addAttribute("productList",productDao.getAllProduct());
		return "royalpowerparts";
		
	}
	@RequestMapping("harleypowerparts")
	public String harleypowerparts(Model model)
	{
		model.addAttribute("productList",productDao.getAllProduct());
		return "harleypowerparts";
		
	}
	
	@RequestMapping("brand")
	public String brand()
	{
		return "brand";
		
	}

	
	@RequestMapping("login")
	public String login()
	{
		return "login";
		
	}

	@RequestMapping("contact")
	public String contact()
	{
		return "contact";
		
	}
	
	

	@RequestMapping("ktm")
	public String ktm(Model model)
	{
		model.addAttribute("productList",productDao.getAllProduct());
		return"powerparts";
		
		
	} 

	@RequestMapping("/admin/category")
	public String Category(Model model)
	{
		model.addAttribute("categoryList",categoryDao.getAllCategory());
		model.addAttribute("category", new Category());
		return "category";
		
		
	}
	

}
