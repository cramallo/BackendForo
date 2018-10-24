package com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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
	@Column
	private int parentId;

	@ManyToOne(fetch=FetchType.LAZY,optional=false)
	@JoinColumn(name="id",nullable=false)
	private Topic topic;	
	
	public Reply() {}

	public Reply(int author, String descripcion, Date datePost) {
		super();
		this.author = author;
		this.description = descripcion;
		this.datePost = datePost;
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

}
