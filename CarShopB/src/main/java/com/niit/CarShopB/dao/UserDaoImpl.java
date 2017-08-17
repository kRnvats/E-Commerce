	package com.niit.CarShopB.dao;
	import java.util.List;
	import java.util.logging.Logger;
	import javax.transaction.Transactional;
	import org.hibernate.HibernateException;
	import org.hibernate.Session;
	import org.hibernate.SessionFactory;
	import org.hibernate.annotations.common.util.impl.LoggerFactory;
	import org.hibernate.query.Query;
	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Repository;
	import com.niit.CarShopB.model.User;
	import com.niit.CarShopB.model.Author;
	import com.niit.CarShopB.model.BillingDetails;
	import com.niit.CarShopB.model.ShippingDetails;

	@Repository("UserDao")
	@Transactional
	public class UserDaoImpl implements UserDao {
		@Autowired 
		SessionFactory sessionFactory;
		private final org.jboss.logging.Logger logger = LoggerFactory.logger(UserDaoImpl.class);

		
		@SuppressWarnings("unchecked")
		public List<User> getAllUsers() {
			
			logger.info("Starting getAllUser method of userDao");
			try {
				return sessionFactory.getCurrentSession().createQuery("from User").list();
			} catch (HibernateException e) {
				
				e.printStackTrace();
				throw e;
			}
		}
	
		public boolean addUser(User user) {

		logger.info("Starting method save() in UserDaoImpl");

		try {
				Session session = sessionFactory.getCurrentSession();
				
				user.getShippingDetails().setUser(user);
				user.getBillingDetails().setUser(user);
				user.setActive(true);	
				
				
				session.persist(user);
				session.persist(user.getBillingDetails());
				session.persist(user.getShippingDetails());
				
				logger.info("User details inserted");

				Author auth = new Author();
				auth.setRolename("ROLE_USER");
				auth.setAuthorname(user.getUsername());
				session.persist(auth);
				return true;
			} catch (HibernateException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		
		}

	}
	
		