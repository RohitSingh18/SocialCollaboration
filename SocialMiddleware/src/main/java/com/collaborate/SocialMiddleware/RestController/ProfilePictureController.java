package com.collaborate.SocialMiddleware.RestController;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.collaborate.SocialBackend.Dao.ProfilePictureDao;
import com.collaborate.SocialBackend.model.ProfilePicture;
import com.collaborate.SocialBackend.model.User;
import com.collaborate.SocialBackend.service.UserService;


@Controller
public class ProfilePictureController {
	@Autowired
	ProfilePictureDao profilepicturedao;
	@Autowired
	UserService userService;

	@RequestMapping(value="/uploadprofilepic",method=RequestMethod.POST)
	public void uploadpicture(@RequestParam CommonsMultipartFile fileUpload,HttpSession session,HttpServletResponse http){
		
		String userName=(String)session.getAttribute("userName");
		

		
		System.out.println("getting friends of: " + userName);
		User user = userService.getUserById(userName);
		System.out.println("User emailId: " + user.getEmailId());
		if (fileUpload != null) {
			CommonsMultipartFile file = fileUpload;
			System.out.println("Saving File: " + file.getOriginalFilename());
			ProfilePicture profilepic = new ProfilePicture();
		
			profilepic.setUserName(user.getUserName());
			profilepic.setImage(file.getBytes());
			profilepic.setFileName(userName);
			System.out.println("File: " +profilepic.getImage());// image
			profilepicturedao.uploadpic(profilepic);
			

			byte[] imagefiles = profilepic.getImage(); // image

			try {
				String path = "C:/Users/Recon/Project2/SocialFrontend/WebContent/resources/img/"
						+ user.getUserName();
				System.out.println("Path: " + path);
				File files = new File(path);
				FileOutputStream fos = new FileOutputStream(files);
				fos.write(imagefiles);
				fos.close();
			} catch (Exception e) {
				
				e.printStackTrace();
			}

		}
		 try {
			    http.sendRedirect("http://localhost:8080/SocialFrontend/index.html");
			  } catch (IOException ex) {

			  }
		
	}

	@RequestMapping(value="/getprofilepic/{userName}", method=RequestMethod.GET)
	public ResponseEntity<?> getProfilePic(@PathVariable String userName,HttpSession session){


		
		String username=(String)session.getAttribute("userName");

		ProfilePicture profilePic=profilepicturedao.getProfilePic(username);

//		String name = profilePic.getFileName();
//		System.out.println("Name: " + name);
//		System.out.println("File: " + profilePic.getImage());
		byte[] imagefiles = profilePic.getImage();
		return new ResponseEntity<byte[]>(imagefiles, HttpStatus.OK);
	}
		
	

}
