package com.collaborate.SocialBackend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Entity
@Component 
@Table(name="Blog")
public class BlogComment {
	
	@Id
	private Integer ID;
	private Integer blogID;
	private String blogComment;
	private Date commentDate;
	private Integer userID;
	private String username;

}
