    package com.niit.CarShopB.model;
	import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
    import javax.persistence.JoinColumn;
    import javax.persistence.OneToOne;
    import com.niit.CarShopB.model.User;
	import org.springframework.stereotype.Component;

		@Entity
		@Component
		public class BillingDetails implements Serializable {

			private static final long serialVersionUID = 127L;

			public User getUser() {
				return user;
			}

			public void setUser(User user) {
				this.user = user;
			}

			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private int billingAddressId;
			private String StreetName;
			private int ApartNo;
			private String City;
			private String State;
			private String Country;
			private long Zipcode;

			@OneToOne
			@JoinColumn
			private User user;
			@OneToOne(fetch = FetchType.EAGER, mappedBy = "billingId", cascade = CascadeType.ALL)
			private UserOrder order;

			public UserOrder getOrder() {
				return order;
			}

			public void setOrder(UserOrder order) {
				this.order = order;
			}

			public static long getSerialversionuid() {
				return serialVersionUID;
			}

			public int getBillingAddressId() {
				return billingAddressId;
			}

			public void setBillingAddressId(int billingAddressId) {
				this.billingAddressId = billingAddressId;
			}
			
			public String getStreetName() {
				return StreetName;
			}

			public void setStreetName(String streetName) {
				this.StreetName = streetName;
			}

			public int getApartNo() {
				return ApartNo;
			}

			public void setApartNo(int apartNo) {
				this.ApartNo = apartNo;
			}

			public String getCity() {
				return City;
			}

			public void setCity(String city) {
				this.City = city;
			}

			public String getState() {
				return State;
			}

			public void setState(String state) {
				this.State = state;
			}

			public String getCountry() {
				return Country;
			}

			public void setCountry(String country) {
				this.Country = country;
			}

			public long getZipcode() {
				return Zipcode;
			}

			public void setZipcode(long zipcode) {
				this.Zipcode = zipcode;
			}

			


	}



