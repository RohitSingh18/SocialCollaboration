package com.collaborate.CollaborationBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.SocialBackend.Dao.BlogDao;
import com.collaborate.SocialBackend.model.Blog;

public class BlogDaoTestCase {
	
	static BlogDao blogDao;

	@BeforeClass
	public static void intialize() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =  new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collaborate");
		annotationConfigApplicationContext.refresh();
		blogDao=(BlogDao)annotationConfigApplicationContext.getBean("blogDao");
	
	}
	@Test
	public void  blogTest(){
		Blog blog=new Blog();
		blog.setBlogID(18);
		blog.setBlogName("Alpha");
		blog.setBlogContent("Alpha is here");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setStatus("NA");
		blog.setUserID("alpha@gmail.com");
        blogDao.createBlog(blog);
        
        assertTrue("problem in blog creation",blogDao.createBlog(blog));
	}

}
