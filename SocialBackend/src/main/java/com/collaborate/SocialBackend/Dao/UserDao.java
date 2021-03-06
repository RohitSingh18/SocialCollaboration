package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.User;

public interface UserDao {
	public boolean addUser(User user);
	public boolean isvalidemail(String emailId);
	public boolean isvalidusername(String userName);
	User login(User user);
	void updateUser(User user);
	public User getUserById(String username);
	public List<User> getallusers();

}
