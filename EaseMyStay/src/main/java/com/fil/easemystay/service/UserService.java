package com.fil.easemystay.service;


import com.fil.easemystay.entities.User;

public interface UserService {
	
	public User createUser(User user);
	
	public User loginUser(String username, String password);

	public User updateUser(User user);

	public boolean deleteUser(User user);
}

