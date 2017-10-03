package com.collaborate.SocialMiddleware.RestController;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collaborate.SocialBackend.model.User;
import com.collaborate.SocialBackend.service.UserService;

@Transactional

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session)
	{
		user.setStatus("NA");
		user.setOnline(true);
		
		User validuser=userService.login(user);
		if(validuser==null)
		{
			Error error=new Error(4,"Invalid username/password");
			return new ResponsibiltyEntity<Error>(error,HttpStatus.UNAUTHORIZED); 
		}
	}
	
	

}
