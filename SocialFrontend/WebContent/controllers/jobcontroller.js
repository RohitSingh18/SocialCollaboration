/**
 * 
 */
app.controller('JobController',function($scope,$location,JobService){
	$scope.addJob=function(){
		JobService.addjob($scope.job).then(function(response){
			console.log($scope.job)//job object
			console.log(response.status)//200
			$location.path('/home')
		},function(response){
			console.log(response.data)
			console.log(response.status)
			console.error=response.data
        	if(response.status==401)
        		{
        		$scope.error=response.data
        		$location.path('/login')
        		}
        	else{
        		$location.path('/addjob')
        	}
		
		})
	}
	$scope.getAllJobs=function(){
		JobService.getAllJobs().then(function(response){
			$scope.jobs=response.data//List<job>
		},function(response){
			if(response.status==401)
    		{
        		$scope.error=response.data
        		$location.path('/login')
        		}
        	else{
        		$location.path('/addjob')
        	}
			
		}
	 )}
	
});
	