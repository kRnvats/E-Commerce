package com.niit.CarShopB.dao;

import com.niit.CarShopB.model.User;

public interface UserDao {
	public boolean addUser(User c);

	public java.util.List<User> getAllUsers();

	public User getUserByUserName(String username);

}