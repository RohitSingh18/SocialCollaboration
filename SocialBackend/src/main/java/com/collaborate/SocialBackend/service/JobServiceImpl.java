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
	public void addJob(Job job) {
		// TODO Auto-generated method stub

	}
	public List<Job> getAllJobs() {
		// TODO Auto-generated method stub
		return jobDao.getAllJobs();
	}
    
}
