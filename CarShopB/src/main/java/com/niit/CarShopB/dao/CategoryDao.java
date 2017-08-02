package com.niit.CarShopB.dao;
import java.util.List;


import com.niit.CarShopB.model.Category;



public interface CategoryDao {
	public boolean addCategory(Category  c);
	public boolean deleteCategory(int catid);
	public boolean updateCategory(Category c);
	List<Category>getAllCategory();
	Category categoryByid(int catid);
	
	
}



