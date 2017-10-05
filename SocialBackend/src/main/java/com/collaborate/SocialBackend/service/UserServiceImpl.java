package com.collaborate.SocialBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.SocialBackend.Dao.UserDao;
import com.collaborate.SocialBackend.model.User;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userdao;

	public boolean addUser(User user) {
		return userdao.addUser(user);
	}

	public boolean isvalidemail(String emailId) {
		return userdao.isvalidemail(emailId);
	}

	public boolean isvalidusername(String userName) {
		
		return userdao.isvalidusername(userName);
	}

	public User login(User user) {
		
		return userdao.login(user);
	}

	public void updateUser(User user) {
		userdao.updateUser(user);

	}

	public User getUserById(String username) {
		
		return userdao.getUserById(username);
	}

	public List<User> getallusers() {
		
		return userdao.getallusers();
	}

}
