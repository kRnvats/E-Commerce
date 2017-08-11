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
	import com.niit.CarShopB.model.Customer;
	import com.niit.CarShopB.model.author;
	import com.niit.CarShopB.model.billingDetails;
	import com.niit.CarShopB.model.shippingDetails;






	@Repository("CustomerDao")
	@Transactional
	public class CustomerDaoImpl implements CustomerDao {
		@Autowired 
		SessionFactory sessionFactory;
		private final org.jboss.logging.Logger logger = LoggerFactory.logger(CustomerDaoImpl.class);

		
		@SuppressWarnings("unchecked")
		public List<Customer> getAllCustomers() {
			
			logger.info("Starting getAllCustomer method of customerDao");
			try {
				return sessionFactory.getCurrentSession().createQuery("from Customer").list();
			} catch (HibernateException e) {
				
				e.printStackTrace();
				throw e;
			}
		}
	
		public boolean addCustomer(Customer customer) {

		logger.info("Starting method save() in CustomerDaoImpl");

		try {
				Session session = sessionFactory.getCurrentSession();

			
				customer.getShippingDetails().setCustomer(customer);
				customer.getBillingDetails().setCustomer(customer);
				customer.setActive(true);	
				
				
				session.persist(customer);
				session.persist(customer.getBillingDetails());
				session.persist(customer.getShippingDetails());
				
				logger.info("Customer details inserted");

				author auth = new author();
				auth.setRolename("ROLE_USER");
				auth.setAuthorname(customer.getUsername());
				session.persist(auth);
				return true;
			} catch (HibernateException e) {
				// TODO: handle exception
				e.printStackTrace();
				return false;
			}
		
		}

	}
	
		