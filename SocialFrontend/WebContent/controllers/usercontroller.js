/**
 * 
 */
app.controller('UseController',function($scope){
	$scope.registerUser=function(){
		
//		CALL userservice - pass user data in Json format
       
		console.log("USER DATA IS"+ $scope.user)
        UserService.registerUser().then(function(response){
        	//redirect  the user to login page with" registration success"
        },function(response){
        	
        	//if status is 406, either username is not valid /email is not valid 
        	//display the error message in registratn form
        })
	}
})