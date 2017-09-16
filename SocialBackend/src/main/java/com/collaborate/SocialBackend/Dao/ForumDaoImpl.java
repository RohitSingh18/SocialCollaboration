package com.collaborate.SocialBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import com.collaborate.SocialBackend.model.Forum;

public class ForumDaoImpl implements ForumDao {
	
	@Autowired
	SessionFactory sessionFactory;
	

	@Transactional

	public boolean createForum(Forum forum) {
		try
		{
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
		}
			catch(Exception e)
		{
				System.out.println("Exception is"+e);
				return false;	
				
			}
	
	}

	public boolean editForum(int forumID) {
		sessionFactory.getCurrentSession().update(forumID);
		return false;
	}

	public boolean deleteForum(int forumID) {
		Session session= sessionFactory.getCurrentSession();
		Forum forum=(Forum)sessionFactory.getCurrentSession().get(Forum.class,forumID);
		return true;
	}

	public List<Forum> getAllForums() {
		Session session= sessionFactory.openSession();
		Query query=session.createQuery("from forum where status='A'");
		List<Forum>listforum=query.list();
		return listforum;
	}

	public Forum getForum(int forumID) {
		Session session= sessionFactory.openSession();
		Forum forum=(Forum)session.get(Forum.class,forumID);
		return forum;
	
	}

	public boolean approveForum(Forum forum) {
		try
		{
		forum.setStatus("A");
		sessionFactory.getCurrentSession().saveOrUpdate(forum);
		return true;
		}
			catch(Exception e)
		{
				System.out.println("Exception is"+e);
				return false;	
				
			}
}
}
