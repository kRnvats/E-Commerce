package com.niit.CarShopB.dao;

import com.niit.CarShopB.model.User;

public interface UserDao {

public boolean addUser (User u);
	
	
	public User getUserById(int id);

	public User getUsersById(int id);

	public User getUserByUserName(String username);
	
	public boolean getStatus(int id);

	public int changeStatus(int id)  ;
	
	public boolean update(User u);



}
