package com.collaborate.SocialMiddleware.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.collaborate.SocialBackend.model.User;
import com.collaborate.SocialBackend.service.FriendService;

@Controller
public class FriendController {
	@Autowired
	private FriendService friendService;
	@RequestMapping(value="/getsuggestedusers",method=RequestMethod.GET)
	public ResponseEntity<?> getSuggestedUsers(){
		String username=(String)session.getAttribute("userName");
		if(username==null){
			Error error=new Error(5,"Unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			
		}
		List<User> suggestedUsers=friendService.listOfSuggestedUsers(UserName);
		return new ResponseEntity<list<User>>(suggestedUsers,HttpStatus.OK);
	}

}
