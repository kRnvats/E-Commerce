package com.niit.CarShopB.dao;

import java.util.List;
import com.niit.CarShopB.model.Product;

public interface ProductDao {
	public boolean addProduct(Product  p);
	public boolean deleteProduct(int pid);
	public boolean updateProduct(Product p);
	List<Product>getAllProduct();
	Product ProductByid(int pid);
	public Product getProductId(int id);	
	
}



