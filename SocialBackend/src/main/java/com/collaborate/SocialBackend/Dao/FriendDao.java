package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.Friend;
import com.collaborate.SocialBackend.model.User;

public interface FriendDao {
	List<User>listOfSuggestedUsers(String UserName);
	
	public void friendRequest(Friend friend);
	
	public List<Friend> pendingRequests(String toId);
		
	}

