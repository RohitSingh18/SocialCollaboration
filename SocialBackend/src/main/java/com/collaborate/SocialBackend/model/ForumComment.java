package com.collaborate.SocialBackend.model;

import java.util.Date;

import javax.persistence.Id;

public class ForumComment {
	
	@Id
	private Integer ID;
	private Integer formID;
	private String Comment;
	private Date commentDate;
	private Integer userID;
	private String username;

}
