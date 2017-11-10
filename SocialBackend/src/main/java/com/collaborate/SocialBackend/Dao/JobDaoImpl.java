package com.collaborate.SocialBackend.Dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
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
		Session s =(Session) sessionFactory.getCurrentSession().save(job);
	}
		
		
		public List<Job> getAllJobs() {
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Job");
			List<Job>listjob=query.list();
			return listjob;
	}

}
