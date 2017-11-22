package com.collaborate.SocialBackend.service;

import java.util.List;

import com.collaborate.SocialBackend.model.Blog;

public interface BlogService {
	
	public boolean createBlog(Blog blog);
	public boolean editBlog(Blog blog);
	public boolean deleteBlog(Integer blogId);
	public Blog getBlogById(Integer blogId);
	public List<Blog> getAllBlogs();
	public boolean approveBlog(Blog blog);
	public List<Blog> getBlogs(String status);
}

