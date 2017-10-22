package com.collaborate.SocialMiddleware.RestController;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.collaborate.SocialBackend.model.User;
import com.collaborate.SocialBackend.service.JobService;
import com.collaborate.SocialBackend.service.UserService;

@Controller
public class JobController {
	
	@Autowired
	private JobService jobService;
	
	@Autowired
	private UserService userService;
	@RequestMapping(value="/addjob",method=RequestedMethod.POST)
	
	public ResponseEntity<?>addJob(@RequestBody Job job,HttpSession session){
		String username=(String)session.getAttribute("userName");
		if(username==null){
			Error error=new Error(5,"Unauthorized access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		User user=userService.getUserByUsername(username);
		if(!user.getRole().equals("ADMIN")){
			Error error=new Error(6,"Access Denied");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		try{
			jobService.addJob(job);
			return new ResponseEntity<job>(job,HttpStatus.OK);
			
		}catch(Exception e){
			Error error=new Error(7,"Unable to insert job details");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
	}
	

}
