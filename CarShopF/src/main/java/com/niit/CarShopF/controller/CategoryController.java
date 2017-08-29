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

import com.niit.CarShopB.dao.CategoryDao;
import com.niit.CarShopB.dao.ProductDao;
import com.niit.CarShopB.model.Category;

@Controller
public class CategoryController {

	@Autowired
	ProductDao productDao;
	@Autowired
	CategoryDao categoryDao;
	
	@RequestMapping(value="/addCategory",method=RequestMethod.POST)
	
	public String addCategory(@ModelAttribute("category")Category c,HttpSession s)
	{
	    if(c.getCategoryID()==0)
	    {
	    	
		categoryDao.addCategory(c);
	    
	    }
	    
	    else
	    {
	    
	    	categoryDao.updateCategory(c);
	   
	    }
		return "redirect:/category";
	}
	@RequestMapping(value="/updateCategory/{categoryId}")
		public String updatecategory(@PathVariable("categoryId")Integer catid, Model model)
		{
			model.addAttribute("category",categoryDao.categoryByid(catid));
			model.addAttribute("categoryList",categoryDao.getAllCategory());
			return  "category";
		}
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deletecategory(@PathVariable("categoryId")Integer catid,Model model)
	{
			model.addAttribute("category",categoryDao.categoryByid(catid));
			categoryDao.deleteCategory(catid);
		    model.addAttribute("categoryList",categoryDao.getAllCategory());
			return "redirect:/category";
	}
}
