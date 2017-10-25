package com.collaborate.SocialMiddleware.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.collaborate.SocialBackend.model.Error;
import com.collaborate.SocialBackend.model.Friend;
import com.collaborate.SocialBackend.model.User;
import com.collaborate.SocialBackend.service.FriendService;

@Controller
public class FriendController {
	@Autowired
	private FriendService friendService;
	
	@RequestMapping(value="/getsuggestedusers",method=RequestMethod.GET)
	public ResponseEntity<?> getSuggestedUsers(){
		//String username=(String)session.getAttribute("userName");
		String username="rohit";
		if(username==null){
			Error error=new Error(5,"Unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
			
		}
		List<User> suggestedUsers=friendService.listOfSuggestedUsers(username);
		return new ResponseEntity<List<User>>(suggestedUsers,HttpStatus.OK);
	}
	
	@RequestMapping(value="/friendrequest/toId")
	public ResponseEntity<?> friendRequst(@PathVariable String toId,HttpSession session){
		String username=(String)session.getAttribute("userName");
		if(username==null){
			Error error=new Error(5,"Unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		}
		Friend friend=new Friend();
		friend.setFromId(username);
		friend.setStatus('P');
		friendService.friendRequest(friend);//insert into friend table
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
		
		}


   @RequestMapping(value="/pendingrequest",method=RequestMethod.PUT)
   public ResponseEntity<?>PendingRequest(HttpSession session){
	   String username=(String)session.getAttribute("userName");
		if(username==null){
			Error error=new Error(5,"Unauthorised access");
			return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
   }
		List<Friend> pendingRequests=friendService.pendingRequests(username);
		return new ResponseEntity<List<Friend>>(pendingRequests,HttpStatus.OK);
   }
}
		
		