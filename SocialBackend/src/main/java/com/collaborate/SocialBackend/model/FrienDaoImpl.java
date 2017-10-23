package com.collaborate.SocialBackend.model;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.SocialBackend.Dao.FriendDao;

@Repository
@Transactional
public class FrienDaoImpl implements FriendDao {

	@Autowired
	private SessionFactory sessionFactory;
	public List<User> listOfSuggestedUsers(String UserName) {
		Session session=sessionFactory.getCurrentSession();
		session.createSQLQuery("select*from user where username in"
				+"(select username from user where username!=? minus"
				+"(select fromId from Friend where toId=?"
				+"union select toId from Friend where fromId=?)"
				+")");
		query.setString(0, UserName);
		query.setString(1, UserName);
		query.setString(2, UserName);
		query.addEntity(User.class);//to convert records to User Objects
		List<User>suggestedUsers;
	}
	
		
		
		
	}

}
