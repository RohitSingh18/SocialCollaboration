/**
 * 
 */
app.controller('UserController',function($scope,UserService,$location,$rootScope,$cookieStore){
	$scope.registerUser=function(){
		
//		CALL userservice - pass user data in Json format
       
		console.log("USER DATA IS"+ $scope.user)
        UserService.registerUser($scope.user).then(function(response){
        	alert('user registered succesfully!!')
        	console.log(response.data)
        	console.log(response.status)
        	$location.path('/')
        	//redirect  the user to login page with" registration success"
        },function(response){
        	
        	//if status is 406, either username is not valid /email is not valid 
        	//display the error message in registratn form
        	console.log(response.data)
        	console.log(response.status)
        	console.error=response.data
        	$location.path('/register')
        }
        )
	}
	
	$scope.login=function(){
		console.log($scope.user)
		UserService.login($scope.user).then(function(response){
			alert('Login succesfull')
			$rootScope.currentUser=response.data
		//	$cookieStore.put('userDetails',response.data)
			$location.path('/')
		},function(response){
			$scope.error=response.data.message
			$location.path('/login')
			
		})
	}
	
	if($rootScope.currentUser!=undefined){
		UserService.getUser().then(function(response){
			$scope.user=response.data;
		},function(response){
			
		})
		}
	
});