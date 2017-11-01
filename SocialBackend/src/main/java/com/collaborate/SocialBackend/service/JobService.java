package com.collaborate.SocialBackend.service;

import com.collaborate.SocialMiddleware.RestController.List;
import com.collaborate.SocialMiddleware.RestController.job;
import com.collaborate.SocialBackend.model.Job;

public interface JobService {
	void addJob(Job job);

	List<job> getAllJobs();
}
