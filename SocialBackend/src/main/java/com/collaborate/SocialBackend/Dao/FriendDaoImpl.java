package com.collaborate.SocialBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.SocialBackend.model.Friend;
import com.collaborate.SocialBackend.model.User;

@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {

	@Autowired
	private SessionFactory sessionFactory;
	public List<User> listOfSuggestedUsers(String UserName) {
		Session session=sessionFactory.getCurrentSession();
SQLQuery query=	session.createSQLQuery("select * from user where username in (select username from user where username!=? minus(select fromId from Friend where toId=?union select toId from Friend where fromId=?))");
		query.setString(0, UserName);
		query.setString(1, UserName);
		query.setString(2, UserName);
		query.addEntity(User.class);//to convert records to User Objects
		List<User>suggestedUsers=query.list();
		return suggestedUsers; //List<User>
	}
	public void friendRequest(Friend friend) {
		Session session=sessionFactory.getCurrentSession();
		session.save(friend);
		
	}
	public List<Friend> pendingRequests(String toId) {
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery("from friend where toId=? and status='P'");
		query.setString(0, toId);
		return query.list();
	}

}

