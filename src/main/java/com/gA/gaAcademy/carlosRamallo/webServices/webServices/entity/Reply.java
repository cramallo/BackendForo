package com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Reply {
	@Id 
	@GeneratedValue
	private int id;
	
	@Column
	private int author;
	@Column
	private String description;
	@Column
	private Date datePost;
	
	
	@JsonBackReference
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="topic_id")
	private Topic topic;	
	
	public Reply() {}

	public Reply(int author, String description, Date datePost,Topic topic) {
		super();
		this.author = author;
		this.description = description;
		Date d= new Date();
		this.datePost = d;
		this.topic=topic;
	}

	public int getId() {
		return id;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getdescription() {
		return description;
	}

	public void setdescription(String description) {
		this.description = description;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public Topic getTopic() {
		return topic;
	}

	public void setTopic(Topic topic) {
		this.topic = topic;
	}		

	
}
