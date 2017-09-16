package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.Blog;

public interface BlogDao {
	
	public boolean createBlog(Blog blog);
	public boolean editBlog(Blog blog);
	public boolean deleteBlog(int BlogID);
	public List<Blog> getAllBlogs();
	public Blog getBlog(int BlogID);
	public boolean approveBlog(Blog blog);
	
}
