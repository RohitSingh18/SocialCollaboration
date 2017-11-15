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
import com.collaborate.SocialBackend.model.Error;
import com.collaborate.SocialBackend.service.UserService;

@Transactional
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ResponseEntity<?> login(@RequestBody User user,HttpSession session)
	{
	//	user.setStatus("NA");
		//user.setOnline(true);
		
		User validuser=userService.login(user);
		if(validuser==null)
		{
			Error error=new Error(4,"Invalid username/password");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED); 
		}
		
		System.out.println("Online status before update"+ validuser.isOnline());
		validuser.setOnline(true);
		try{
			userService.updateUser(validuser);
		}catch (Exception e)
		{
			Error error=new Error(6,"Invalid username/password");
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR); 
		
		}
		System.out.println("Online status after update" + validuser.isOnline());
		session.setAttribute("userName",user.getUserName());
		return new ResponseEntity<User>(validuser,HttpStatus.OK);
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public ResponseEntity<?> registerUser(@RequestBody User user)
	{
		if(!userService.isvalidusername(user.getUserName()))
		{
			Error error=new Error(2,"username already exits");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE
		);
		}
		
		if(!userService.isvalidusername(user.getEmailId()))
		{
			Error error=new Error(3,"username already exits");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		boolean result=userService.addUser(user);
		if(result)
		{
			return new ResponseEntity<User>(user,HttpStatus.OK);
		}
		else{
			Error error=new Error (1,"unable to register user");
			System.out.println("error"+error);
			return new ResponseEntity<Error>(error,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@RequestMapping(value="/logout",method=RequestMethod.PUT)
	public ResponseEntity<?> logout(HttpSession session)
	{
		String username=(String)session.getAttribute("userName");
		System.out.println("name of the user: "+username);
		if(username==null)
		{
			Error error=new Error(5,"unathorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			
		}
		User user=userService.getUserById(username);
		user.setOnline(false);
		userService.updateUser(user);
		session.removeAttribute(username);
		session.invalidate();
		return new ResponseEntity<User>(user,HttpStatus.OK);
	}
@RequestMapping(value="/getUser",method=RequestMethod.GET)
	
	public ResponseEntity<?> getUser(HttpSession session)
	{
		String userName = (String)session.getAttribute("firstName");
		if(userName==null)
		{
			Error error = new Error(7,"UNAUTHORIZED");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		
		}
		User user = userService.getUserById(userName);
		return new ResponseEntity<User>(user,HttpStatus.OK);

	}
}
