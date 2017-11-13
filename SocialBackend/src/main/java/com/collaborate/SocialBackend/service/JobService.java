package com.collaborate.SocialBackend.service;


import java.util.List;

import com.collaborate.SocialBackend.model.Job;

public interface JobService {
    List<Job> getAllJobs();
    
    public boolean updatejob(Job job);
    
    public boolean deletejob(int jobId);
    
    public boolean addjob(Job job);
    
    public Job getjobById(int  jobId);
    
    
        
}
