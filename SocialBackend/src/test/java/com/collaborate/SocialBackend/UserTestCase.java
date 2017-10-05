package com.collaborate.SocialBackend;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.collaborate.SocialBackend.Dao.UserDao;
import com.collaborate.SocialBackend.model.Blog;
import com.collaborate.SocialBackend.model.User;

public class UserTestCase {

	static UserDao userDao;

	@BeforeClass
	public static void intialize() {
		AnnotationConfigApplicationContext annotationConfigApplicationContext =  new AnnotationConfigApplicationContext();
		annotationConfigApplicationContext.scan("com.collaborate");
		annotationConfigApplicationContext.refresh();
		userDao=(UserDao)annotationConfigApplicationContext.getBean("userDao");
	}
	
	@Test
	public void  userTest(){
		User user=new User();
		user.setEmailId("xyz@gmail");
		user.setFirstName("recon");
		user.setLastName("rec");
		user.setOnline(false);;
		user.setPassword("pass");
		user.setRole("student");
		user.setStatus("NA");
		user.setUserName("rohit");

         assertTrue("problem in blog creation",userDao.addUser(user));
	}
	
}
