package com.niit.CarShopB.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.niit.CarShopB.model.User;
import com.niit.CarShopB.model.UserOrder;
@Transactional
@Repository("userOrderDAO")
public class UserOrderDaoImpl implements UserOrderDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public boolean addUserOrder(UserOrder userOrder) {
		Session session = sessionFactory.getCurrentSession();

		User user = userOrder.getUserr();
		userOrder.setBillingId(user.getBillingDetails());
		userOrder.setShippingId(user.getShippingDetails());
		userOrder.setOrderStatus("Placed");
		session.saveOrUpdate(userOrder);
		session.saveOrUpdate(user);
		session.saveOrUpdate(user.getBillingDetails());
		session.saveOrUpdate(user.getShippingDetails());

		return true;
	}

	public List<UserOrder> getAllOrders() {
		return sessionFactory.getCurrentSession().createQuery("FROM UserOrder").list();
	}

	public UserOrder getUserOrderById(int id) {
		return sessionFactory.getCurrentSession().get(UserOrder.class, id);
	}

	public int changeOrderStatus(int id, String status) {
		Query query = sessionFactory.getCurrentSession()
				.createQuery("UPDATE UserOrder SET orderStatus = '" + status + "' where orderID = " + id);
		return query.executeUpdate();
	}

}
