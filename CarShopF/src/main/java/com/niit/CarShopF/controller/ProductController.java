package com.niit.CarShopF.controller;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.niit.CarShopB.dao.CategoryDao;
import com.niit.CarShopB.dao.ProductDao;
import com.niit.CarShopB.model.Product;

@Controller
public class ProductController {

	
	@Autowired
	ProductDao productDao;
	@Autowired 
	CategoryDao categoryDao;
	@RequestMapping(value="/addProduct",method=RequestMethod.POST)
	
	public String addProduct(@ModelAttribute("product")Product p,  HttpSession s)
	{
	    if(p.getProductId()==0)
	    {
	    	productDao.addProduct(p);
	    	MultipartFile m=p.getImage();
	    	System.out.println(m.getOriginalFilename());
	    	ServletContext context=s.getServletContext();
	    	String filelocation=context.getRealPath("/resources/images");
	    	System.out.println(filelocation);
	    	String filename=filelocation+"\\"+p.getProductId()+".jpg";
	    	System.out.println(filename);
	    	try{
	    		byte b[]=m.getBytes();
	    		FileOutputStream fos=new FileOutputStream(filename);
	    		fos.write(b);
	    		fos.close();	    		
	    	}
	    	catch( Exception e){}
	    }
	    else
	    {
	    	productDao.updateProduct(p);
	    }
	  return  "redirect:/admin/product";
	}
	@RequestMapping(value="/updateProduct/{productId}")
		public String updateproduct(@PathVariable("productId")Integer pid, Model model)
		{
			model.addAttribute("product",productDao.ProductByid(pid));
			model.addAttribute("categoryList",categoryDao.getAllCategory());
			model.addAttribute("productList",productDao.getAllProduct());
			return  "product";
		}
	@RequestMapping(value="/deleteProduct/{productId}")
	public String deleteproduct(@PathVariable("productId")Integer pid,Model model)
	{
			model.addAttribute("product",productDao.ProductByid(pid));
			productDao.deleteProduct(pid);
		    model.addAttribute("productList",productDao.getAllProduct());
			return "redirect:/admin/product";
	}

}
