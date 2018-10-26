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
	private int reply_id;
	
	@Column
	private int author;
	@Column
	private String description;
	@Column
	private Date datePost;
	/*@Column
	private int topic_id;	*/
	
	//@JsonBackReference
	/*@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="topic_id",nullable = false)*/
	@ManyToOne
	private Topic topic;	
	
	public Reply() {}

	public Reply(int author, String descripcion, Date datePost,Topic topic) {
		super();
		this.author = author;
		this.description = descripcion;
		Date d= new Date();
		this.datePost = d;
		this.topic=topic;
	}

	public int getId() {
		return reply_id;
	}

	public int getAuthor() {
		return author;
	}

	public void setAuthor(int author) {
		this.author = author;
	}

	public String getDescripcion() {
		return description;
	}

	public void setDescripcion(String descripcion) {
		this.description = descripcion;
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
