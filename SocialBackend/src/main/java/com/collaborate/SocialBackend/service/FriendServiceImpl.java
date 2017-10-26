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
	private FriendDao friendDAO;
	public List<User> listOfSuggestedUsers(String userName) {
		return friendDAO.listOfSuggestedUsers(userName);
	}

	public void friendRequest(Friend friend) {
		friendDAO.friendRequest(friend);
		
	}

	public List<Friend> pendingRequests(String toID) {
		return friendDAO.pendingRequests(toID);
	}

	public void updatePendingRequests(Friend friend) {
		friendDAO.updatePendingRequest(friend);
		
	}

	public List<String> listOfFriends(String userName) {
		return friendDAO.listOfFriends(userName);
	}
}
