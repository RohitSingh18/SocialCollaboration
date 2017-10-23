package com.collaborate.SocialBackend.service;

import java.util.List;

import com.collaborate.SocialBackend.model.User;

public interface FriendService {
	List<User>listOfSuggestedUsers(String UserName);
}
