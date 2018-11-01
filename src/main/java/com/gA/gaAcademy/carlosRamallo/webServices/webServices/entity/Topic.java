package com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	@Column(name="title")
	private String title;
	
	@Column(name="datePost")
	private Date datePost;
	
	@Column(name="description")
	private String description;
	
	@Column(name="author")
	private int author;
	
	@Column(name="deleted")
	private boolean deleted=false;
	
	/*
	@JsonManagedReference
	@OneToMany(mappedBy="topic",cascade=CascadeType.ALL)		
	private List<Reply>replies=new ArrayList<>();
	*/
	
	@OneToMany(fetch=FetchType.LAZY,mappedBy="topic",cascade=CascadeType.ALL,orphanRemoval=true)
	private List<Reply>replies=new ArrayList<Reply>();
	
	public Topic(){	}

	public Topic(String title,String description, int author) {
		super();
		this.title = title;
		Date d= new Date();
		this.datePost = d;
		this.description = description;
		this.author = author;		
	}	
	
	public Topic(String title,String description, int author,List<Reply> replies) {
		super();
		this.title = title;
		Date d= new Date();
		this.datePost = d;
		this.description = description;
		this.author = author;		
		this.replies=replies;
	}	

	public int getId() {
		return id;
	}

	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDatePost() {
		return datePost;
	}

	public void setDatePost(Date datePost) {
		this.datePost = datePost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void delete() {
		this.deleted = false;
	}

	public void deleteReplies() {
		this.replies.clear();		
	}	

	
}
