package com.niit.CarShopB.model;


	import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
	import javax.persistence.OneToOne;

	import org.springframework.stereotype.Component;

	@Entity
	@Component
	public class Customer implements Serializable
	{
		
		private static final long serialVersionUID = 1L;

		public shippingDetails getShippingDetails() {
			return shippingDetails;
		}

		public void setShippingDetails(shippingDetails shippingDetails) {
			this.shippingDetails = shippingDetails;
		}

		public billingDetails getBillingDetails() {
			return billingDetails;
		}

		public void setBillingDetails(billingDetails billingDetails) {
			this.billingDetails = billingDetails;
		}

		public static long getSerialversionuid() {
			return serialVersionUID;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		@Id
		@Column
		private int userId;
		
		@Column(unique = true)
		private String username;
		
		@Column
		private String password;
		private boolean active;

		@OneToOne(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
		private shippingDetails shippingDetails;
		@OneToOne(fetch = FetchType.EAGER, mappedBy = "customer", cascade = CascadeType.ALL)
		private billingDetails billingDetails;
		
		
		private String email;
		

		public String getEmail() {
			return email;
		}

		public void setwEmail(String email) {
			this.email = email;
		}

		public int getUserId() {
			return userId;
		}

		public void setUserId(int userId) {
			this.userId = userId;
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


		public Customer getBillingAddress() {
			// TODO Auto-generated method stub
			return null;
		}

		public Customer getShippingAddress() {
			// TODO Auto-generated method stub
			return null;
		}

	}
	