package com.collaborate.SocialBackend.Dao;


import java.util.List;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.SocialBackend.model.User;




@Repository("userDao")
@Transactional

public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
    
	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	public void updateUser(User user) {
		sessionFactory.getCurrentSession().update(user);
		
	}


	public List<User> getallusers() {
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("from user where status='A'");
		List<User> listuser=query.list();
		return listuser;
	
	}

	public User getUserById(String userName) {
		Session session=sessionFactory.openSession();
		User user=(User)sessionFactory.getCurrentSession().get(User.class,userName);
		return user;
	}
	
	public User login (User user){
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where username=? and password=?");
		query.setString(0, user.getUserName());
		query.setString(1,  user.getPassword());
		user=(User)query.uniqueResult();
		return user;
	}

	public boolean isvalidemail(String emailId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from User where emailId=?");
		query.setString(0, emailId);
		User user=(User)query.uniqueResult();
		if(user==null)
			return true;
		else
		return false;
	}

	public boolean isvalidusername(String userName) {
		Session session=sessionFactory.getCurrentSession();
		User user=(User)session.get(User.class, userName);
		
		if(user==null)
			return true;
		else
		return false;
	}

	

}
