package com.collaborate.SocialBackend.service;

import java.util.List;

import com.collaborate.SocialBackend.model.Friend;
import com.collaborate.SocialBackend.model.User;

public interface FriendService {
	List<User> listOfSuggestedUsers(String userName);
	void friendRequest(Friend friend);
	List<Friend> pendingRequests(String toID);
	void updatePendingRequests(Friend friend);
	List<String> listOfFriends(String userName);
	
}
