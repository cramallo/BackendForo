package com.gA.gaAcademy.carlosRamallo.webServices.webServices.response;
import java.util.Date;

import com.gA.gaAcademy.carlosRamallo.webServices.webServices.entity.Topic;


public class TopicResponse {	
	
	private String title;	
	private Date datePost;	
	private String description;
	
	public TopicResponse(String title, Date datePost, String description) {
		super();
		this.title = title;
		this.datePost = datePost;
		this.description = description;
	}

	public TopicResponse(Topic topic) {
		// TODO Auto-generated constructor stub
		this.title = topic.getTitle();
		this.datePost = topic.getDatePost();
		this.description = topic.getDescription();
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

}
