package com.niit.CarShopB.model;

import javax.persistence.Column;
import javax.persistence.Id;
import org.springframework.stereotype.Component;
import javax.persistence.Entity;

@Entity
@Component
public class author {
@Id
@Column
private String authorId;

@Column(unique = true)
private String authorname;

@Column
private String rolename;

public String getAuthorId() {
	return authorId;
}
public void setAuthorId(String authorId) {
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

