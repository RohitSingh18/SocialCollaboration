package com.collaborate.SocialBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.SocialBackend.Dao.FriendDao;
import com.collaborate.SocialBackend.model.Friend;
import com.collaborate.SocialBackend.model.User;

@Service
public class FriendServiceImpl implements FriendService {
	
	@Autowired
	private FriendDao friendDao;

	public List<User> listOfSuggestedUsers(String Username) {
		return friendDao.listOfSuggestedUsers(Username);
	}

	public void  friendRequest(Friend friend) {
		// TODO Auto-generated method stub
		
	}

	public List<Friend> pendingRequests(String username) {
		return friendDao.pendingRequests(username);
		
	}

}
