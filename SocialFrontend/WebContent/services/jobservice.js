/**
 * 
 */
app.factory('JobService',function($http){
	var jobservice={}
	var BASE_url="http://localhost:8080/SocialMiddleware"
		JobService.addJob=function(job){
		return $http.post(BASE_url+"/addJob",job)
	}
	blogPostService.blogWaitingForApproval=function(){
		return $http.get(BASE_URL+)
	}
})