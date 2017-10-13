/**
 * 
 */
app.controller('BlogController',function($scope,BlogService,$location){
	$scope.postblog=function()
	{
		console.log("blog data is" +$scope.blog)
		BlogService.postblog($scope.blog).then(function(response){
			alert('blog added succesfully')
			console.log(response.data)
			console.log(response.status)
			$location.path('/')
		},function(response)
		{
			console.error=response.data
			if(response.status==401)
				{
				$location.path('/login')
				}
			else
				$location.path('/addblog')
		})
	}
})