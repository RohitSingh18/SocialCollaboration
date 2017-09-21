package com.collaborate.SocialBackend;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
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
	@Ignore
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
	
	@Ignore
	@Test
	public void getBlogByBlogID()
	{
		assertNotNull("Problem getting blog",blogDao.getBlog(18));
	}
   
	@Ignore
	@Test
	public void EditBlog(){
		Blog blog=blogDao.getBlog(18);
		//blog.setBlogID(18);
		blog.setBlogName("Bravo");
		blog.setBlogContent("Bravo is here");
		blog.setCreateDate(new java.util.Date());
		blog.setLikes(0);
		blog.setStatus("NA");
		blog.setUserID("bravo@gmail.com");
	
		assertTrue("problem in blog editing",blogDao.editBlog(blog));
		
	}
	@Ignore
	@Test
    public void	approveblog()
    {  Blog blog=new Blog();
       blog.setBlogID(18);
	   blog.setBlogName("Alpha");
	   blog.setBlogContent("Alpha is here");
	   blog.setCreateDate(new java.util.Date());
	   blog.setLikes(0);
	   blog.setStatus("A");
	   blog.setUserID("alpha@gmail.com");
       
       assertTrue("approved blog",blogDao.approveBlog(blog));
    }
	
	@Test
	public void getallapprovedblogtest()
	{
		List<Blog> listblog=blogDao.getAllBlogs();
		assertTrue("No approved blogs",listblog.size()>0);
	}
	

	
}

