package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.BlogComment;

public interface BlogCommentDao {

	public boolean createBlogcomment(BlogComment blogcomment);
	public boolean editBlogcomment(BlogComment blogcomment);
	public boolean deleteBlogcomment(int blogcommentId);
	public BlogComment getBlogcomment(int blogcommentId);
	public List<BlogComment> getBlogcomments(int blogId);

}
