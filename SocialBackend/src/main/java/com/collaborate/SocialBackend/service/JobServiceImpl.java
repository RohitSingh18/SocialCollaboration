package com.collaborate.SocialBackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.collaborate.SocialBackend.Dao.JobDao;
import com.collaborate.SocialBackend.model.Job;

@Service
public class JobServiceImpl implements JobService {
	@Autowired
	JobDao jobDao;
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobDao.getAllJobs();
	}
	public boolean updatejob(Job job) {
		return jobDao.updateJob(job);
	}
	public boolean deletejob(int jobId) {
		return jobDao.deletejob(jobId);
	}
	public boolean addjob(Job job) {
		return jobDao.addJob(job);
	}
	public Job getjobById(int jobId) {
		return jobDao.getjobById(jobId);
	}
    
}
