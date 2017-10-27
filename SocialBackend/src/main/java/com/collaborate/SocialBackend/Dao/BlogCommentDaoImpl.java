package com.collaborate.SocialBackend.Dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.SocialBackend.model.BlogComment;
@Repository("blogCommentDao")

public class BlogCommentDaoImpl implements BlogCommentDao {
	@Autowired
	SessionFactory sessionfactory;
	

	public boolean createBlogComment(BlogComment blogComment) {
		sessionfactory.getCurrentSession().save(blogComment);
	   return true;
	}

	public boolean editBlog(int BlogCommentID) {
		Session session = sessionfactory.getCurrentSession();
		BlogComment blogComment=(BlogComment)sessionfactory.getCurrentSession().get(BlogComment.class,BlogCommentID);
		session.update(blogComment);
		return true;
		
	}

	public boolean deleteBlog(int BlogCommentID) {
		Session session = sessionfactory.getCurrentSession();
		BlogComment blogComment=(BlogComment)sessionfactory.getCurrentSession().get(BlogComment.class,BlogCommentID);
		session.delete(blogComment);
		return true;
	}

	public List<BlogComment> getAllBlogComments() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public BlogComment getBlogComment(int BlogCommentID) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean approveBlogComment(BlogComment blogComment) {
		// TODO Auto-generated method stub
		return false;
	}

}
