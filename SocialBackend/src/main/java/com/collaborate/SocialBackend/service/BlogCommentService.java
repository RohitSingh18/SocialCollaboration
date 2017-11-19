package com.collaborate.SocialBackend.service;

import java.util.List;

import com.collaborate.SocialBackend.model.BlogComment;

public interface BlogCommentService {
	

	public boolean createBlogcomment(BlogComment blogcomment);
	public List<BlogComment> getBlogcomments(int blogId);
}

