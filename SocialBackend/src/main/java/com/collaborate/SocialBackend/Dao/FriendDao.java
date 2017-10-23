package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.User;

public interface FriendDao {
	List<User>listOfSuggestedUsers(String UserName);

}
