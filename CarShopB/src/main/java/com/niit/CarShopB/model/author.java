package com.niit.CarShopB.model;

import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Component
public class Author {
@Id
@Column
@GeneratedValue(strategy=GenerationType.AUTO)
private int authorId;

@Column(unique = true)
private String authorname;

@Column
private String rolename;


public int getAuthorId() {
	return authorId;
}
public void setAuthorId(int authorId) {
	this.authorId = authorId;
}
public String getAuthorname() {
	return authorname;
}
public void setAuthorname(String authorname) {
	this.authorname = authorname;
}

public String getRolename() {
	return rolename;
}
public void setRolename(String rolename) {
	this.rolename = rolename;
}


}

