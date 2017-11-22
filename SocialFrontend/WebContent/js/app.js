/**
 * 
 */
var app=angular.module("app",['ngRoute','ngCookies'])
app.config (function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl:'views/login.html',
		controller:'UserController'
		
	})
	 .when('/addblog', {
        templateUrl : 'views/addblog.html',
        controller:'BlogController'
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
	})
	     .when('/getapproveform/:id', {
        templateUrl : 'Blog/blogapprovalform.html',
        controller:'BlogDetailController'
    
    })
    .when('/getalljobs',{
    	templateUrl:'views/joblist.html',
    	controller:'JobController'
    })

	.when('/profilepic',{
	templateUrl:'views/uploadpicture.html'
	})
	.when('/myprofile',{
		templateUrl:'User/profile.html',
			controller:'UserController'
	})
	.when('/chat',{
		templateUrl:'Chat/chat.html',
		controller:'ChatController'
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
