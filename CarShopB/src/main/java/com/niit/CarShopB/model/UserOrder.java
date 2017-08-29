package com.niit.CarShopB.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.springframework.stereotype.Component;

@Entity
@Component
public class UserOrder implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int orderID;
	private String orderStatus;
	@OneToOne
	@JoinColumn(name = "userID")
	private User userr;

	@OneToOne
	@JoinColumn(name="shippingId")
	private ShippingDetails shippingId;
	@OneToOne
	@JoinColumn(name="billingId")
	private BillingDetails billingId;
	public int getOrderID() {
		return orderID;
	}
	public void setOrderID(int orderID) {
		this.orderID = orderID;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public User getUserr() {
		return userr;
	}
	public void setUserr(User userr) {
		this.userr = userr;
	}
	public ShippingDetails getShippingId() {
		return shippingId;
	}
	public void setShippingId(ShippingDetails shippingId) {
		this.shippingId = shippingId;
	}
	public BillingDetails getBillingId() {
		return billingId;
	}
	public void setBillingId(BillingDetails billingId) {
		this.billingId = billingId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}