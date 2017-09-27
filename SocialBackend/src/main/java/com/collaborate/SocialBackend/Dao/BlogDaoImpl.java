package com.collaborate.SocialBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.SocialBackend.model.Blog;

@Repository("blogDao")
public class BlogDaoImpl implements BlogDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Transactional
	public boolean createBlog(Blog blog) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
		}
			catch(Exception e)
		{
				System.out.println("Exception is"+e);
				return false;	
				
			}
		}

	@Transactional
	public boolean editBlog(Blog blog) {
		
		sessionFactory.getCurrentSession().update(blog);
		System.out.println("updated ");
		return true;
	}

	public boolean deleteBlog(int blogID) {
		Session session= sessionFactory.getCurrentSession();
		Blog blog=(Blog)sessionFactory.getCurrentSession().get(Blog.class,blogID);
		session.delete(blog);
		return true;
	}
	@Transactional
	public List<Blog> getAllBlogs() {
		Session session= sessionFactory.openSession();
		Query query=session.createQuery("from Blog where status='A'");
		List<Blog>listblog=query.list();
		return listblog;
	}
	@Transactional
	public Blog getBlog(int blogID) {
		Session session= sessionFactory.openSession();
		Blog blog=(Blog)session.get(Blog.class,blogID);
		return blog;
	}

	@Transactional
	public boolean approveBlog(Blog blog) {
		try
		{
		blog.setStatus("A");
		sessionFactory.getCurrentSession().saveOrUpdate(blog);
		return true;
		}
			catch(Exception e)
		{
				System.out.println("Exception is"+e);
				return false;	
				
			}
	}

}
