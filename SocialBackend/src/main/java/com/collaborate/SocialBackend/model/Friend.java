package com.collaborate.SocialBackend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Friend")
public class Friend {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
private int id;
private String fromId;
private String toId;
private char status;


}
