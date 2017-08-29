package com.niit.CarShopB.model;


	import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
	import javax.persistence.OneToOne;

	import org.springframework.stereotype.Component;

	@Entity
	@Component
	public class User implements Serializable
	{
		
		private static final long serialVersionUID = 1L;
		@Id
		@Column
		@GeneratedValue(strategy = GenerationType.AUTO)

		private int userId;
		
		@Column(unique = true)
		private String username;
		
		@Column
		private String password;
		private boolean active;

		@OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
		private ShippingDetails shippingDetails;
		@OneToOne(fetch = FetchType.EAGER, mappedBy = "user", cascade = CascadeType.ALL)
		private BillingDetails billingDetails;
		@OneToOne(fetch = FetchType.EAGER, mappedBy = "userr", cascade = CascadeType.ALL)
		private UserOrder order;

		private String email;
		
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public static long getSerialversionuid() {
			return serialVersionUID;
		}
		public String getUsername() {
			return username;
		}
		public void setUsername(String username) {
			this.username = username;
		}
		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
		public boolean isActive() {
			return active;
		}
		public void setActive(boolean active) {
			this.active = active;
		}
		public ShippingDetails getShippingDetails() {
			return shippingDetails;
		}
		public void setShippingDetails(ShippingDetails shippingDetails) {
			this.shippingDetails = shippingDetails;
		}
		public BillingDetails getBillingDetails() {
			return billingDetails;
		}
		public UserOrder getOrder() {
			return order;
		}
		public void setOrder(UserOrder order) {
			this.order = order;
		}
		public void setBillingDetails(BillingDetails billingDetails) {
			this.billingDetails = billingDetails;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		
	}
	