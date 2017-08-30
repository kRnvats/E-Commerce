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
	

	@RequestMapping("service")
	public String service()
	{
		return"service";
		
		
	}
	
	@RequestMapping("brand")
	public String brand()
	{
		return "brand";
	}
	
		
		@RequestMapping("/ProductDetail/{proId}")
		public String ProductDetail(@PathVariable("proId")Integer pro,Model model1)
		{
			model1.addAttribute("product",productDao.getAllProduct());
			model1.addAttribute("categoryList",categoryDao.getAllCategory());
			model1.addAttribute("productList",productDao.getAllProduct());
			model1.addAttribute("pro",productDao.getAllProduct());
			return "productdetail";
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
	
	

	@RequestMapping("/admin/category")
	public String Category(Model model)
	{
		model.addAttribute("categoryList",categoryDao.getAllCategory());
		model.addAttribute("category", new Category());
		return "category";
		
		
	}
	

}
