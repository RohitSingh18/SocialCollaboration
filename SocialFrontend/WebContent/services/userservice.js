/**
 * 
 */
app.factory('UserService',function($http){
	var userService={}
	var BASE_URL="http://localhost:8080/SocialMiddleware"
		
		userService.registerUser=function(user)

	{
		return $http.post(BASE_URL + "/registerUser",user)

	}
		userService.login=function(user)
		{
			return $http.post(BASE_URL +"/login",user)
		}
	
		userService.logout=function(){
			return $http.put(BASE_URL +"/logout")//define in backend 
		}
		
		userService.getUser = function()
		{
			return $http.get(BASE_URL+"/getUser")
		}
	return userService ;
		
})