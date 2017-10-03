package com.collaborate.SocialBackend.service;

import java.util.List;

import com.collaborate.SocialBackend.model.User;

public interface UserService {
	public boolean addUser(User user);
	public boolean isvalidemail(String emailId);
	public boolean isvalidusername(String userName);
	User login(User user);
	void updateUser(User user);
	public User getUserById(String username);
	public List<User> getallusers();

}
