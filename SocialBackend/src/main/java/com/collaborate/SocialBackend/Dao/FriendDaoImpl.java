package com.collaborate.SocialBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.type.StandardBasicTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.SocialBackend.model.Friend;
import com.collaborate.SocialBackend.model.User;

@Repository
@Transactional
public class FriendDaoImpl implements FriendDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<User> listOfSuggestedUsers(String userName) {
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		SQLQuery query = session.createSQLQuery("select * from usertable where userName in"
				+"(select userName from usertable where userName!=? minus"
				+"(select fromId from friend where toId=?"
				+"union select toId from friend where fromId=?"
				+"))");
				query.setString(0,userName );
				query.setString(1,userName );
				query.setString(2,userName );
				query.addEntity(User.class);
				List<User> suggestedUser = query.list();
				return suggestedUser;

	}
	public void friendRequest(Friend friend) {
		Session session = sessionFactory.getCurrentSession();
		session.save(friend);
		
	}
	public List<Friend> pendingRequests(String toID) {
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery("from Friend where toId=? and status='P'");
		query.setString(0, toID);
		return query.list();
	}
	public void updatePendingRequest(Friend friend) {
		Session s = sessionFactory.getCurrentSession();
		if(friend.getStatus()=='A'){
		s.update(friend);
		}
		else
			s.delete(friend);
	}
	public List<String> listOfFriends(String userName) {
		Session session= sessionFactory.getCurrentSession();
		@SuppressWarnings("deprecation")
		SQLQuery query1 = session.createSQLQuery("select fromId from Friend where toId=? and status='A'")
				.addScalar("fromID", StandardBasicTypes.STRING);
				query1.setString(0, userName);
		List<String> list = query1.list();
		System.out.println(list);
		Query query2 = session.createSQLQuery("select toId from Friend where fromId=? and status='A'")
				.addScalar("toID",StandardBasicTypes.STRING);
		query2.setString(0, userName);

		List<String> list1 = query2.list();
		System.out.println(list1);
		list1.addAll(list);
		return list1;
	}
}

