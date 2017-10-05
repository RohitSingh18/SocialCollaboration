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
	});
	
	

})
app.run(function($rootScope,$cookieStore,UserService,$location)
{
	if ($rootScope.currentUser==undefined)
	{	$rootScope.currentUser=$cookieStore.get('userDetails')  }
		
		$rootScope.logout=function()
		{   	delete $rootScope.currentUser;
		    UserService.logout().then(function(response){
			
			$cookieStore.remove('userDetails')
			$location.path('/login')
	    	},function(response){
			if(response.status==401){
				delete $rootScope.currentUser;
				$cookieStore.remove('userDetails');
		     	$location.path('/')
			}
		})
		}
	})
