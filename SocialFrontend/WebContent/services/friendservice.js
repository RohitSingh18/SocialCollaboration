/**
 * 
 */
app.factory('FriendService',function($http){
	var friendService={}
	var BASE_URL="http://localhost:8080/SocialMiddleware"
		friendService.listOfSuggestedUsers=function(){
		return $http.get(BASE_URL + "/getsuggestedusers")
	}
	friendService.sendFriendRequest=function(toId){
		return $http.get(BASE_URL +"/friendrequest/"+toId)
	}
	
	friendService.listOfSuggestedUsers=function(){
		return $http.get(BASE_URL +"/pendingrequests")
	}
	return friendService;
})