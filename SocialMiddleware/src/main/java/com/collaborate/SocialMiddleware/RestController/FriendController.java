package com.collaborate.SocialMiddleware.RestController;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/getSuggestedUsers",method=RequestMethod.GET)
	public ResponseEntity<?> listOfSuggestedUsers(HttpSession httpSession)
	{
		String userName = (String)httpSession.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		List<User> suggestedUser = friendService.listOfSuggestedUsers(userName);
		return new ResponseEntity<List<User>>(suggestedUser,HttpStatus.OK);
	}
	@RequestMapping(value="/pendingRequests",method=RequestMethod.GET)
	public ResponseEntity<?> pendingRequests(HttpSession httpSession)
	{
		String userName = (String)httpSession.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
	
		List<Friend> pendingRequest=friendService.pendingRequests(userName);
		return new ResponseEntity<List<Friend>>(pendingRequest,HttpStatus.OK);
	}
	
	@RequestMapping(value="/friendRequest/{toID}",method=RequestMethod.GET)
	public ResponseEntity<?> friendRequest(@PathVariable String toID,HttpSession httpSession) 
	{
		String userName = (String)httpSession.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		Friend friend = new Friend();
		friend.setFromId(userName);
		friend.setToId(toID);
		friend.setStatus('P');
		friendService.friendRequest(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping(value="/updatePendingRequests",method=RequestMethod.PUT)
	public ResponseEntity<?> updatePendingRequests(@RequestBody Friend friend,HttpSession httpSession)
	{
		String userName = (String)httpSession.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
	
		friendService.updatePendingRequests(friend);
		return new ResponseEntity<Friend>(friend,HttpStatus.OK);
	}
	@RequestMapping(value="/listOfFriends",method=RequestMethod.GET)
	public ResponseEntity<?> listOfFriends(HttpSession httpSession) 
	{
		String userName = (String)httpSession.getAttribute("userName");
		if(userName==null)
		{
			Error error = new Error(5,"Unauthorized Access");
			return new ResponseEntity<Error>(error,HttpStatus.NOT_ACCEPTABLE);
		}
		List<String> list = friendService.listOfFriends(userName);
		return new ResponseEntity<List<String>>(list,HttpStatus.OK);
	}
}
		
		