package com.collaborate.SocialMiddleware.RestController;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collaborate.SocialBackend.model.Job;
import com.collaborate.SocialBackend.model.Error;

import com.collaborate.SocialBackend.service.JobService;
import com.collaborate.SocialBackend.service.UserService;

@Controller
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/addjob",method=RequestMethod.POST)
	
	public ResponseEntity<?> addJob(@RequestBody Job job,HttpSession session){
		String username=(String)session.getAttribute("userName");
//		if(username==null){
//			Error error=new Error(10,"Unauthorized access");
//			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
//		}
//		User user=userService.getUserById(username);
//		if(!user.getRole().equals("ADMIN")){
//			Error error=new Error(6,"Access Denied");
//			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
//		}
		try{
			job.setPostedOn(new Date());
			jobService.addjob(job);
			return new ResponseEntity<Job>(job,HttpStatus.OK);
			
		}catch(Exception e){
			Error error=new Error(7,"Unable to insert job details");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	
	@RequestMapping(value="/getallJobs",method=RequestMethod.GET)
	public ResponseEntity<?> getAllJobs(HttpSession session){
		String username=(String)session.getAttribute("userName");
		if(username==null){
			Error error=new Error(10,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		List<Job> jobs=jobService.getAllJobs();
		return new ResponseEntity<List<Job>>(jobs,HttpStatus.ACCEPTED);
		
}
	
	@DeleteMapping(value="/deletejob/{Id}")
	public ResponseEntity<String> deletejob (@PathVariable("Id")Integer jobId)
	{
		if(jobService.deletejob(jobId))
		{return new ResponseEntity<String> ("job Deleted",HttpStatus.OK);}
		 else
		 {return new ResponseEntity <String> ("problem in deleting",HttpStatus.NOT_ACCEPTABLE); }
		

	}
	
	@PutMapping(value="/editjob/{Id}")
	public ResponseEntity<String> editjob (@PathVariable("Id")Integer jobId,@RequestBody Job job)
	{
	Job newjob=jobService.getjobById(jobId);
		newjob.setJobDescription(job.getJobDescription());
		if(jobService.updatejob(newjob))
		 {  return new ResponseEntity <String> ("job edited",HttpStatus.OK);  }
		 else
		 {
			 return new ResponseEntity <String> ("problem in editing",HttpStatus.NOT_ACCEPTABLE); 
		 }
	}
	
	
	@GetMapping(value="/getjobbyid/{id}")
	public ResponseEntity<?> getJobById(@PathVariable int id,HttpSession session)
	{
		String userName=(String) session.getAttribute("userName");
	    if(userName==null)
		{
			Error error=new Error(6,"unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
	   
	    Job job=jobService.getjobById(id);
	    return new ResponseEntity<Job>(job,HttpStatus.OK);
		
	}
}




