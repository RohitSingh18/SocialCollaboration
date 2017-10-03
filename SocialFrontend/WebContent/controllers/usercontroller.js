/**
 * 
 */
app.controller('UseController',function($scope){
	$scope.registerUser=function(){
		
//		CALL userservice - pass user data in Json format
       
		console.log("USER DATA IS"+ $scope.user)
        UserService.registerUser($scope.user).then(function(response){
        	console.log(response.data)
        	console.log(response.status)
        	$location.path('/login')
        	//redirect  the user to login page with" registration success"
        },function(response){
        	
        	//if status is 406, either username is not valid /email is not valid 
        	//display the error message in registratn form
        	console.log(response.data)
        	console.log(response.status)
        	console.erroe=response.data
        	$location.path('/register')
        }
        )
	}
	
	$scope.login=function(){
		console.log($scope.user)
		UserService.login($scope.user).then(function(response){
			$cookieStore.put('user')
			$location.path('/home')
		},function(response){
			$scope.error-=response.data.message
			$location.path('/login')
			
		})
	}
})