package com.collaborate.SocialBackend.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component 
@Table(name="Blog")
public class BlogComment {
	
	@Id
	private Integer blogID;
	private String blogName;
	private String blogContent;
	private String status;
	private String userID;
	private Integer likes;

}
