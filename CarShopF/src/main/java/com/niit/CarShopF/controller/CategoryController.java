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
    	MultipartFile m=c.getImage();
    	System.out.println(m.getOriginalFilename());
		ServletContext context=s.getServletContext();
    	String filelocation=context.getRealPath("/resources/images");
    	System.out.println(filelocation);
    	String filename=filelocation+"\\"+c.getProductId()+".jpg";
    	System.out.println(filename);
    	try{
    		byte b[]=m.getBytes();
    		FileOutputStream fos=new FileOutputStream(filename);
    		fos.write(b);
    		fos.close();
    	}
    	catch (Exception e){}
	    }
	    
	    else
	    {
	    	categoryDao.updateCategory(c);
	    }
		return "category";
	}
	@RequestMapping(value="/updateCategory/{categoryId}")
		public String updatecategory(@PathVariable("categoryId")Integer catid, Model model)
		{
			model.addAttribute("category",categoryDao.categoryByid(catid));
			model.addAttribute("categoryList",categoryDao.getAllCategory());
			return  "Category";
		}
	@RequestMapping(value="/deleteCategory/{categoryId}")
	public String deletecategory(@PathVariable("categoryId")Integer catid,Model model)
	{
			model.addAttribute("category",categoryDao.categoryByid(catid));
			categoryDao.deleteCategory(catid);
		    model.addAttribute("categoryList",categoryDao.getAllCategory());
			return "redirect:/Category";
	}
}
