/**
 * 
 */
app.factory('BlogService',function($http){
	var blogservice={}
	var BASE_url="http://localhost:8080/SocialMiddleware"
		BlogService.addBlog=function(blog){
		return $http.post(BASE_URL + "/addblog",blog)
	}
	blogPostService.blogsWaitingForApproval=function(){
		return $http.get(BASE_URL+"/getblogs/"+0)
	}
	blogPostService.blogsApproved=function(){
		return $http.get(BASE_URL)
	}
	
})