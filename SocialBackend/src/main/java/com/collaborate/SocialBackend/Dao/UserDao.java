package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.User;

public interface UserDao {
	public boolean addUser(User user);
	public boolean updateUser(User user);
	public boolean deleteUser(int userName);
	List<User> getUser();
	User getUserById (int userName);

}
