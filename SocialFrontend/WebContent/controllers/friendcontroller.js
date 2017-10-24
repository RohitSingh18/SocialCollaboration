/**
 * 
 */
app.controller('FriendController',function($scope,$location,FriendService){
	$scope.listofsuggestedusers=function(){
		FriendService.listofsuggestedusers($scope.friend).then(function(response){
			$scope.suggestedUsers=response.data//List<user>
		}
		,function(response){
			if (response.status==401)
				$loacation.path('/login')
		})
	}
	
	
})