/**
 * 
 */
var app=angular.module("app",['ngRoute','ngCookies'])
app.config (function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl:'views/home.html',
		controller:'UserController'
	})
	.when('/login',{
		templateUrl:'views/login.html',
		controller:'UserController'
	})
	.when('/register',{
		templateUrl:'views/registrationform.html',
		controller:'UserController'
	})

	
	.when('/pendingRequests',{
			templateUrl:'views/pendingRequest.html',
			controller:'FriendController'
		})
		.when('/getSuggestedUsers',{
			templateUrl:'views/suggestedUsers.html',
			controller:'FriendController'
			
		})
		.when('/listOfFriends',{
			templateUrl:'views/listoffriends.html',
			controller:'FriendController'
		})
	.when('/addjob',{
		templateUrl:'views/jobform.html',
		controller:'JobController'
})
	.when('/getblogs',{
		templateUrl:'views/bloglist.html',
		controller:'BlogController'
	});
	

})
app.run(function($rootScope,$cookieStore,UserService,$location)
{
	if ($rootScope.currentUser==undefined)
	{	$rootScope.currentUser=$cookieStore.get('userDetails')  }
		
		$rootScope.logout=function()
		{   	
			$cookieStore.remove('userDetails')
			delete $rootScope.currentUser;
			$location.path('/login')	
		    UserService.logout().then(function(response){
		
	    	},function(response){
			if(response.status==401){
				delete $rootScope.currentUser;
				$cookieStore.remove('userDetails');
		     	$location.path('/')
			}
		})
		}
	})
