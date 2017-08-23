package com.niit.CarShopB.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Entity
@Component
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
private int categoryID;
private String categoryName;
private String categoryDesc;
@Transient 
MultipartFile image;
@ManyToOne
@JoinColumn(name="productId",insertable=false,updatable=false,nullable=false)
public MultipartFile getImage() {
	return image;
}

public void setImage(MultipartFile image) {
	this.image = image;
}
@OneToMany(mappedBy="category",fetch=FetchType.EAGER)
Set<Product>products;
public int getCategoryID() {
	return categoryID;
	
}
public void setCategoryID(int categoryID) {
	this.categoryID = categoryID;
}

public String getCategoryName() {
	return categoryName;
}
public void setCategoryName(String categoryName) {
	this.categoryName = categoryName;
}
public String getCategoryDesc() {
	return categoryDesc;
}
public void setCategoryDesc(String categoryDesc) {
	this.categoryDesc = categoryDesc;
}

public String getProductId() {
	// TODO Auto-generated method stub
	return null;
}
}
