package com.niit.CarShopB.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Product {
	@Id	
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int productId;
	private String productName;
	private String productDesc;
	private long productCost;
	

	private String categoryId;
	public String getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	@Transient
	MultipartFile image;
	public MultipartFile getImage() {
		return image;
	}
	public void setImage(MultipartFile image) {
		this.image = image;
	}

	@ManyToOne
	@JoinColumn(name="categoryId",insertable=false,updatable=false,nullable=false)
	Category category;
	
	

	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public long getProductCost() {
		return productCost;
	}
	public void setProductCost(long productCost) {
		this.productCost = productCost;
	}

}
