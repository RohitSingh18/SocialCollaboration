package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.Job;

public interface JobDao {
	void addJob(Job job);
   
	List<Job> getAllJobs(); 
		
	
}