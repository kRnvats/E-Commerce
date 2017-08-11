    package com.niit.CarShopB.model;
	import java.io.Serializable;

	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import com.niit.CarShopB.model.Customer;

	import org.springframework.stereotype.Component;

	@Entity
		@Component
		public class billingDetails implements Serializable {

			private static final long serialVersionUID = 127L;

			public Customer getCustomer() {
				return customer;
			}

			public void setCustomer(Customer customer) {
				this.customer = customer;
			}

			@Id
			@GeneratedValue(strategy = GenerationType.AUTO)
			private int billingAddressId;
			private String StreetName;
			private String ApartNo;
			private String City;
			private String State;
			private String Country;
			private long Zipcode;

			@OneToOne
			@JoinColumn
			private Customer customer;
			
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

			public String getApartNo() {
				return ApartNo;
			}

			public void setApartNo(String apartNo) {
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



