package com.niit.CarShopB.dao;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.niit.CarShopB.dao.*;
import com.niit.CarShopB.model.*;


@Repository("productDao")
@Transactional
public class ProductDaoImpl implements ProductDao{
	@Autowired
	SessionFactory sessionFactory;
	
	public boolean addProduct(Product p) {
		
		Session s=sessionFactory.getCurrentSession();
		s.persist(p);
		return true;
	}

	public boolean deleteProduct(int pid) {
		Session s=sessionFactory.getCurrentSession();
	Product p=(Product)s.load(Product.class,pid);
	s.delete(p);
		return true;
	}

	public boolean updateProduct(Product p) {
		Session s=sessionFactory.getCurrentSession();
		s.update(p);
		return true;
	}

	public List<Product> getAllProduct() {
		 Session s=sessionFactory.getCurrentSession();
		Query q= s.createQuery("from Product");
		List<Product> list=q.getResultList();
		
		return list;
	}
	public Product ProductByid(int pid)
	{
		Session s=sessionFactory.getCurrentSession();
		Query<Product> q=s.createQuery("from Product where productId="+pid);
		Product plist=(Product)q.getSingleResult();
		return plist;
		
	}



	
	}


	





