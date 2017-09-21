package com.collaborate.SocialBackend.model;

import java.util.Date;

public class Forum {
	
	private Integer forumID;
	private String forumName;
	private String forumContent;
	private String status;
	private String userID;
	private Date createDate;
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Integer getForumID() {
		return forumID;
	}
	public void setForumID(Integer forumID) {
		this.forumID = forumID;
	}
	public String getForumName() {
		return forumName;
	}
	public void setForumName(String forumName) {
		this.forumName = forumName;
	}
	public String getForumContent() {
		return forumContent;
	}
	public void setForumContent(String forumContent) {
		this.forumContent = forumContent;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}

	

}
