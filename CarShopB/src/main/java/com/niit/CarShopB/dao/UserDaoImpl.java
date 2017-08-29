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
		public User getUsersById(int id) {
			try {
				@SuppressWarnings("rawtypes")
				Query query = sessionFactory.getCurrentSession().createQuery("FROM User where userId=" + id);
				return (User) query.uniqueResult();
			} catch (HibernateException e) {
				
				e.printStackTrace();
				throw e;
			}
		}

		public boolean getStatus(int id) {
			User users = getUsersById(id);
			return users.isActive();
		}

		
		public int changeStatus(int id)  {
			try {
				User users = getUsersById(id);
				boolean isEnable = users.isActive();

				if (isEnable) {
					@SuppressWarnings("rawtypes")
					Query query = sessionFactory.getCurrentSession()
							.createQuery("UPDATE User SET enabled = " + false + " WHERE userId = " + id);
					return query.executeUpdate();
				} else {
					@SuppressWarnings("rawtypes")
					Query query = sessionFactory.getCurrentSession()
							.createQuery("UPDATE User SET enabled = " + true + " WHERE userId = " + id);
					return query.executeUpdate();
				}
			} catch (HibernateException e) {
				
				e.printStackTrace();
				throw e;
				
			}
		}
		public boolean update(User u) {
			Session s1 =sessionFactory.getCurrentSession();
			u.setActive(true);
			s1.update(u);
			u.setUsername(u.getUsername());
			
			return true;
		}


		
			public User getUserById(int id) {
				
				try {
					return (User) sessionFactory.getCurrentSession().get(User.class, id);
				} catch (HibernateException e) {
					
					e.printStackTrace();
					throw e;
					
				}
			}

			public User getUserByUserName(String username) {
				
				try {
					@SuppressWarnings("rawtypes")
					Query query = sessionFactory.getCurrentSession().createQuery("from User where username= '" + username + "'");
					User user = (User) query.uniqueResult();

					return user;
				} catch (HibernateException e) {
					
					e.printStackTrace();
					throw e;
				}
			}
}