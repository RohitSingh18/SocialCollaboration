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
			
		public List<Job> getAllJobs() {
			Session session= sessionFactory.openSession();
			Query query=session.createQuery("from Job");
			List<Job>listjob=query.list();
			return listjob;
	   }
       public boolean addJob(Job job) {
		
			sessionFactory.getCurrentSession().save(job);
			return true;
		}


		public boolean updateJob(Job job) {
			// TODO Auto-generated method stub
			sessionFactory.getCurrentSession().update(job);
			return true;
		}
		

		public boolean deletejob(int jobId) {
			Session session=sessionFactory.getCurrentSession();
			Job job=(Job)session.load(Job.class,jobId);
			session.delete(job);
			return true;
		}


		public Job getjobById(int jobId) {
			// TODO Auto-generated method stub
			Session session =sessionFactory.getCurrentSession();
			Query query=session.createQuery("from Job where jobId=?");
			query.setParameter(0, jobId);
			Job joblist=(Job)query.uniqueResult();
			return joblist;
		}

}
