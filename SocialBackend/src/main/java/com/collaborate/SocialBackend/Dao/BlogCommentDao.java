package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.BlogComment;

public interface BlogCommentDao {

	public boolean createBlogComment(BlogComment blogComment);
	public boolean editBlog(int BlogCommentID);
	public boolean deleteBlog(int BlogCommentID);
	public List<BlogComment> getAllBlogComments();
	public BlogComment getBlogComment(int BlogCommentID);
	public boolean approveBlogComment(BlogComment blogComment);
}
