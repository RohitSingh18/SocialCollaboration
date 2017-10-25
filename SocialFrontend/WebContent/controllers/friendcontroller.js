/**
 * 
 */
app.controller('FriendController',function($scope,$location,FriendService){
	$scope.listofsuggestedusers=function(){
		FriendService.listofsuggestedusers().then(function(response){
			$scope.suggestedUsers=response.data//List<user>
		
		},function(response){
			if (response.status==401)
				$location.path('/login')
		})
	}
	
	$scope.updatePendingRequest=function(request,statusValue){//statusValue=A/D
		//before assignment request.status is P
		console.log(request.status)//P
		request.status=statusValue
		console.log(request.status)//A (Accept)/ D (Delete)
		FriendService.updatePendingRequest (request).then(function(response){
			pendingRequests()
			$location.path('/pendingrequest')
		},function(response){
			
		})
	}
		listOfSuggestedUsers()
		pendingRequests()
	})
	
	