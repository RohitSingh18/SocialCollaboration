package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.Forum;

public interface ForumDao {
	public boolean createForum(Forum forum);
	public boolean editForum(int ForumID);
	public boolean deleteForum(int ForumID);
	public List<Forum> getAllForums();
	public Forum getForum(int ForumID);
	public boolean approveForum(Forum forum);

}
