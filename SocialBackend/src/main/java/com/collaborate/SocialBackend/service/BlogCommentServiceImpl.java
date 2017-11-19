package com.collaborate.SocialBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import com.collaborate.SocialBackend.model.BlogComment;

public class BlogCommentServiceImpl implements BlogCommentService {
	
	@Autowired 
	com.collaborate.SocialBackend.Dao.BlogCommentDao blogcommentdao;
	
	 public boolean createBlogcomment(BlogComment blogcomment) {
		// TODO Auto-generated method stub
		return blogcommentdao.createBlogcomment(blogcomment);
	}

	public List<BlogComment> getBlogcomments(int blogId) {
		// TODO Auto-generated method stub
		return blogcommentdao.getBlogcomment(blogId);
	}

}
