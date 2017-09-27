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



Repository("userDao")

public class UserDaoImpl implements UserDao {
	
	@Autowired
	SessionFactory sessionFactory;
    
	@Transactional
	public boolean addUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	public boolean updateUser(User user) {
		sessionFactory.getCurrentSession().saveOrUpdate(user);
		return true;
	}

	public boolean deleteUser(int userName) {
		sessionFactory.getCurrentSession();
		User user=(User)sessionFactory.getCurrentSession().get(User.class,userName);
		session.delete(user);
		return true;
	}

	@Transactional
	public List<User> getUser() {
		Session session = sessionFactory.openSession();
		Query query=session.createQuery("from user where status='A'");
		List<User>listuser.query.list();
		return listuser;
	
	}

	public User getUserById(int userName) {
		Session session=sessionFactory.openSession();
		User user=(User)sessionFactory.getCurrentSession().get(User.class,userName);
		return user;
	}

}
