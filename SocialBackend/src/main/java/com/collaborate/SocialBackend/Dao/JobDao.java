package com.collaborate.SocialBackend.Dao;

import java.util.List;

import com.collaborate.SocialBackend.model.Job;

public interface JobDao {
	
	public boolean addJob(Job job); 
    public List<Job> getAllJobs(); 
	public boolean updateJob(Job job);
	public boolean deletejob(int jobId);
	public Job getjobById(int jobId);
	
}