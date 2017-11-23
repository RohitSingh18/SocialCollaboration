/**
 * 
 */
//app.factory('UserService',function($http){
//	var userService={}
//	var BASE_URL="http://localhost:8080/SocialMiddleware"
//		
//		userService.registerUser=function(user)
//
//	{
//		return $http.post(BASE_URL + "/registerUser",user)
//
//	}
//		userService.login=function(user)
//		{
//			return $http.post(BASE_URL +"/login",user)
//		}
//	
//		userService.logout=function(){
//			return $http.put(BASE_URL +"/logout")//define in backend 
//		}
//		
//		userService.getUser = function()
//		{
//			return $http.get(BASE_URL+"/getUser")
//		}
//	return userService ;
//		
//})

app.factory('UserService',function($http){
	
	var userService={}
		
	var BASE_URL="http://localhost:8080/SocialMiddleware"
	userService.registerUser = function(user){
		
		return $http.post(BASE_URL+"/registerUser",user);
		
	}
	userService.fetchAllUsers = function() {

		console.log('----entering getAllUsers')
		return $http.get(BASE_URL + "/getAllUsers")
	}
	userService.login = function(user){
		
		return $http.post(BASE_URL+"/login",user);
	}
	userService.logout = function(){
		
		console.log("userservice logout");
		
		return $http.put(BASE_URL+"/logout");
	}
	
	userService.getUser = function()
	{
		return $http.get(BASE_URL+"/getUser")
	}
	
	userService.updateUser = function(user)
	{
		return $http.put(BASE_URL+"/updateUser",user)
	}
	
	
	return userService;
	
	
})