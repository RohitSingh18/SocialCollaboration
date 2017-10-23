package com.collaborate.SocialBackend.Dao;

import javax.transaction.Transactional;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.collaborate.SocialBackend.model.Job;
@Repository
@Transactional
public class JobDaoImpl implements JobDao {
     
	@Autowired
	SessionFactory sessionFactory;
	public void addJob(Job job) {
		sessionFactory.getCurrentSession().saveOrUpdate(job);
	}

}
