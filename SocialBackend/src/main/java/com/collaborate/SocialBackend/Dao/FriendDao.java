package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.Friend;
import com.collaborate.SocialBackend.model.User;

public interface FriendDao {
	List<User> listOfSuggestedUsers(String userName);
	void friendRequest(Friend friend);
	List<Friend> pendingRequests(String toID);
	void updatePendingRequest(Friend friend);
	List<String> listOfFriends(String userName); 
		
	}

