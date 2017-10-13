package com.collaborate.SocialBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.SocialBackend.Dao.BlogDao;
import com.collaborate.SocialBackend.model.Blog;

@Service
public class BlogServiceImpl implements BlogService {
	@Autowired
	private BlogDao blogdao;

	public boolean createBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogdao.createBlog(blog);
	}

	public boolean editBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogdao.editBlog(blog);
	}

	public boolean deleteBlog(int BlogID) {
		// TODO Auto-generated method stub
		return blogdao.deleteBlog(BlogID);
	}

	public List<Blog> getAllBlogs() {
		// TODO Auto-generated method stub
		return blogdao.getAllBlogs();
	}

	public Blog getBlog(int BlogID) {
		// TODO Auto-generated method stub
		return blogdao.getBlog(BlogID);
	}

	public boolean approveBlog(Blog blog) {
		// TODO Auto-generated method stub
		return blogdao.approveBlog(blog);
	}

}
